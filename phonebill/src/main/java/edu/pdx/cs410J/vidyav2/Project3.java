package edu.pdx.cs410J.vidyav2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The main class for the CS410J phone bill Project
 */

public class Project3 {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("\nNo arguments passed at the command line.\n");
            System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project3 [options] <args> args are (in this order):");
            System.out.println("customer --> Person whose phone bill we’re modeling");
            System.out.println("callerNumber --> Phone number of caller");
            System.out.println("calleeNumber --> Phone number of person who was called");
            System.out.println("begin --> Date and time (am/pm) call began");
            System.out.println("end --> Date and time (am/pm) call ended");
            System.out.println("Options are (options may appear in any order):");
            System.out.println("-pretty file --> Pretty print the phone bill to a text file or standard out (file -)");
            System.out.println("-textFile file --> Where to read/write the phone bill");
            System.out.println("-print --> Prints a description of the new phone call");
            System.out.println("-README --> Prints a README for this project and exits");
            return;}

        boolean readMeFlag = HelperFunctions.readMeFlagCheck(args);
        if (readMeFlag) {
            String FileContentReadMe = HelperFunctions.readFromReadMeFileOnlyProject3();
            System.out.println(FileContentReadMe);
            System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project3 [options] <args> args are (in this order):");
            System.out.println("customer --> Person whose phone bill we’re modeling");
            System.out.println("callerNumber --> Phone number of caller");
            System.out.println("calleeNumber --> Phone number of person who was called");
            System.out.println("begin --> Date and time (am/pm) call began");
            System.out.println("end --> Date and time (am/pm) call ended");
            System.out.println("Options are (options may appear in any order):");
            System.out.println("-pretty file --> Pretty print the phone bill to a text file or standard out (file -)");
            System.out.println("-textFile file --> Where to read/write the phone bill");
            System.out.println("-print --> Prints a description of the new phone call");
            System.out.println("-README --> Prints a README for this project and exits");
            return;}

        boolean print = false;
        for (String commandLineArg : args) {
            if (commandLineArg.contains("-print")) {
                print = true;
                break;}}

        ArrayList<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));

        //Case when the number of arguments are less than 11 (bare minimum arguments)
        if (commandLineArgs.size() < 11) {
            System.err.println("\nThere are some missing arguments.\n");
            System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project3 [options] <args> args are (in this order):");
            System.out.println("customer --> Person whose phone bill we’re modeling");
            System.out.println("callerNumber --> Phone number of caller");
            System.out.println("calleeNumber --> Phone number of person who was called");
            System.out.println("begin --> Date and time (am/pm) call began");
            System.out.println("end --> Date and time (am/pm) call ended");
            System.out.println("Options are (options may appear in any order):");
            System.out.println("-pretty file --> Pretty print the phone bill to a text file or standard out (file -)");
            System.out.println("-textFile file --> Where to read/write the phone bill");
            System.out.println("-print --> Prints a description of the new phone call");
            System.out.println("-README --> Prints a README for this project and exits");
        }

        if (commandLineArgs.size() == 11) {
            if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") ||
                    (commandLineArgs.get(0).equals("-print") && commandLineArgs.get(1).equals("-textFile") &&
                            commandLineArgs.get(2).contains(".txt")))) {
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains("-textFile")) {
                        index = i + 1;
                    }
                    break;
                }
                String fileName = commandLineArgs.get(index);
                TextDumper dumper = new TextDumper();
                TextParser parser = new TextParser(fileName, commandLineArgs.get(index));
                parser.setFilename(fileName);
                dumper.setFileName(fileName);
                parser.setCustomerName(commandLineArgs.get(2));
                PhoneBill bill = parser.parse();
                PhoneCall call = new PhoneCall();
                call.setCallerName(commandLineArgs.get(2));
                call.setCallerNumber(commandLineArgs.get(3));
                call.setCalleeNumber(commandLineArgs.get(4));
                call.setPhoneCallBeginDate(commandLineArgs.get(5));
                call.setPhoneCallBeginTime(commandLineArgs.get(5), commandLineArgs.get(6), commandLineArgs.get(7));
                call.setPhoneCallEndDate(commandLineArgs.get(8));
                call.setPhoneCallEndTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
                boolean allRequiredArgumentsAreValid = HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs);
                bill.addPhoneCall(call);
                dumper.dump(bill);
                System.out.println("\nA new file called "+ fileName +" is created." );
            }
            else if ((commandLineArgs.get(1).contains("-"))) {
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains("-pretty")) {
                        index = i + 1;
                    }
                    break;
                }
                String fileName = commandLineArgs.get(index);
                TextDumper dumper = new TextDumper();
                dumper.setFileName(fileName);
                PhoneBill bill = new PhoneBill(commandLineArgs.get(2));
                PhoneCall call = new PhoneCall();
                call.setCallerName(commandLineArgs.get(2));
                call.setCallerNumber(commandLineArgs.get(3));
                call.setCalleeNumber(commandLineArgs.get(4));
                call.setPhoneCallBeginDate(commandLineArgs.get(5));
                call.setPhoneCallBeginTime(commandLineArgs.get(5), commandLineArgs.get(6), commandLineArgs.get(7));
                call.setPhoneCallEndDate(commandLineArgs.get(8));
                call.setPhoneCallEndTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
                boolean allRequiredArgumentsAreValid = HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs);
                bill.addPhoneCall(call);
                PrettyPrinter printer = new PrettyPrinter();
                System.out.println("\nThis is a pretty file, printing the following Phone details:\n" + printer.getPretty(call, bill.getCustomer()));
            }

        }
        else if (commandLineArgs.size() == 12) {}
        else if (commandLineArgs.size() == 13) {
            if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
                    commandLineArgs.get(2).equals("-pretty") && !commandLineArgs.get(3).equals("-"))) {
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains("-textFile")) {
                        index = i + 1;
                    }
                    break;
                }
                String fileName = commandLineArgs.get(1);
                TextDumper dumper = new TextDumper();
                TextParser parser = new TextParser(fileName, commandLineArgs.get(2));
                parser.setFilename(fileName);
                dumper.setFileName(fileName);
                parser.setCustomerName(commandLineArgs.get(4));
                PhoneBill bill = parser.parse();
                PhoneCall call = new PhoneCall();
                call.setCallerName(commandLineArgs.get(4));
                call.setCallerNumber(commandLineArgs.get(5));
                call.setCalleeNumber(commandLineArgs.get(6));
                call.setPhoneCallBeginDate(commandLineArgs.get(7));
                call.setPhoneCallBeginTime(commandLineArgs.get(7), commandLineArgs.get(8), commandLineArgs.get(9));
                call.setPhoneCallEndDate(commandLineArgs.get(10));
                call.setPhoneCallEndTime(commandLineArgs.get(10), commandLineArgs.get(11), commandLineArgs.get(12));
                boolean allRequiredArgumentsAreValid = HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs);
                if (!allRequiredArgumentsAreValid) {
                }
                bill.addPhoneCall(call);
                dumper.dump(bill);

	            edu.pdx.cs410J.vidyav2.PrettyPrinter printer = new edu.pdx.cs410J.vidyav2.PrettyPrinter();
                printer.setFilename(commandLineArgs.get(3));
                printer.setCustomerName(commandLineArgs.get(4));
                printer.getPretty(call, commandLineArgs.get(5));
                printer.dump(bill);
                //System.out.println("\nPretty file is printed. Check the pretty file folder." );
            }
            else if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
                    (commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).contains("-")) ||
                    (commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
                            commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).equals(".txt")))){
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains(".txt")) {
                        index = i + 1;}
                    break;}
                String fileName = commandLineArgs.get(1);
                TextDumper dumper = new TextDumper();
                TextParser parser = new TextParser(fileName, commandLineArgs.get(4));
                parser.setFilename(fileName);
                dumper.setFileName(fileName);
                parser.setCustomerName(commandLineArgs.get(4));
                PhoneBill bill = parser.parse();
                PhoneCall call = new PhoneCall();
                call.setCallerName(commandLineArgs.get(4));
                call.setCallerNumber(commandLineArgs.get(5));
                call.setCalleeNumber(commandLineArgs.get(6));
                call.setPhoneCallBeginDate(commandLineArgs.get(7));
                call.setPhoneCallBeginTime(commandLineArgs.get(7), commandLineArgs.get(8), commandLineArgs.get(9));
                call.setPhoneCallEndDate(commandLineArgs.get(10));
                call.setPhoneCallEndTime(commandLineArgs.get(10), commandLineArgs.get(11), commandLineArgs.get(12));
                boolean allRequiredArgumentsAreValid = HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs);
                if (!allRequiredArgumentsAreValid) {return;}
                bill.addPhoneCall(call);
                dumper.dump(bill);
                PrettyPrinter printer = new PrettyPrinter();
                printer.setFilename(commandLineArgs.get(3));
                printer.setCustomerName(commandLineArgs.get(4));
                printer.getPretty(call, commandLineArgs.get(5));
                printer.dump(bill);
                //System.out.println("\nPretty file is printed. Check the pretty file folder." );
            }
        }
        else {
            System.err.println("Extraneous or wrong arguments are being printed, this is not allowed.");
        }
    }

}
