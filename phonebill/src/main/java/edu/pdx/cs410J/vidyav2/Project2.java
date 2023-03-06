package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*****************************************************
 * The main class for the CS410J phone bill Project
 *****************************************************/
public class Project2 {
    public static void main(String[] args) throws Exception {

        for (String commandLineArg : args) {
            if (commandLineArg.contains("-print")) {
                break;
            }
        }

        ArrayList<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));

        boolean readMeFlag = HelperFunctions.readMeFlagCheck(args);
        if (readMeFlag) {
            String FileContentReadMe = HelperFunctions.readFromReadMeFileOnly();
            System.out.println(FileContentReadMe);
            DisplayPhoneBill.printValues();
            return;
        }

        if (commandLineArgs.size() < 11) {
            System.err.println("\nThere are some missing arguments.\n");
            DisplayPhoneBill.printValues();
        }

        switch(args.length) {
            case 0: {
                DisplayPhoneBill.noArguments();
                break;
            }

            case 11: {
                textFileChecker(commandLineArgs);
                break;
            }

            case 12: {
                if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains("-pretty") ||
                        (commandLineArgs.get(0).equals("-pretty") && commandLineArgs.get(1).equals("-textFile") &&
                                commandLineArgs.get(2).contains(".txt")) || commandLineArgs.get(0).contains("-print") &&
                        commandLineArgs.get(1).equals("-pretty") && commandLineArgs.get(2).contains(".txt"))) {

                    String fileName = commandLineArgs.get(2);
                    TextDumper dumper = new TextDumper();
                    TextParser parser = new TextParser(fileName, commandLineArgs.get(commandLineArgs.indexOf("-pretty")));
                    parser.setFilename(fileName);
                    dumper.setFileName(fileName);
                    parser.setCustomerName(commandLineArgs.get(3));
                    PhoneBill bill = parser.parse();
                    PhoneCall call = new PhoneCall();
                    call.setCallerName(commandLineArgs.get(3));
                    call.setCallerNumber(commandLineArgs.get(4));
                    call.setCalleeNumber(commandLineArgs.get(5));
                    call.setPhoneCallBeginDate(commandLineArgs.get(6));
                    call.setPhoneCallBeginTime(commandLineArgs.get(6), commandLineArgs.get(7), commandLineArgs.get(8));
                    call.setPhoneCallEndDate(commandLineArgs.get(9));
                    call.setPhoneCallEndTime(commandLineArgs.get(9), commandLineArgs.get(10), commandLineArgs.get(11));
                    boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
                    if (!allRequiredArgumentsAreValid) {
                        return;
                    }
                    bill.addPhoneCall(call);
                    dumper.dump(bill);
                    PrettyPrinter printer = new PrettyPrinter();
                    printer.setFilename(commandLineArgs.get(2));
                    printer.setCustomerName(commandLineArgs.get(3));
                    printer.getpretty(call, commandLineArgs.get(4));
                    printer.dump(bill);
                    //System.out.println("\nPretty file is printed. Check the pretty file folder." );
                }
                else if ((commandLineArgs.get(0).contains("-pretty") && commandLineArgs.get(1).contains(".txt"))) {
                    String fileName = commandLineArgs.get(1);
                    TextDumper dumper = new TextDumper();
                    TextParser parser = new TextParser(fileName, commandLineArgs.get(2));
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
                    boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
                    if (!allRequiredArgumentsAreValid) {
                        printThisUsageMessage();
                    }
                    bill.addPhoneCall(call);
                    dumper.dump(bill);
                    PrettyPrinter printer = new PrettyPrinter();
                    printer.setFilename(commandLineArgs.get(1));
                    printer.setCustomerName(commandLineArgs.get(2));
                    printer.getpretty(call, commandLineArgs.get(2));
                    printer.dump(bill);
                }
                break;
            }

            case 13: {
                if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
                        commandLineArgs.get(2).equals("-pretty") && !commandLineArgs.get(3).equals("-"))) {
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
                    boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
                    if (!allRequiredArgumentsAreValid) {
                        printThisUsageMessage();
                    }
                    bill.addPhoneCall(call);
                    dumper.dump(bill);

                    PrettyPrinter printer = new PrettyPrinter();
                    printer.setFilename(commandLineArgs.get(3));
                    printer.setCustomerName(commandLineArgs.get(4));
                    printer.getpretty(call, commandLineArgs.get(5));
                    printer.dump(bill);
                }
                else if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
                        (commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).contains("-")) ||
                        (commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
                                commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).equals(".txt")))){

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
                    boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
                    if (!allRequiredArgumentsAreValid) {return;}
                    bill.addPhoneCall(call);
                    dumper.dump(bill);
                    PrettyPrinter printer = new PrettyPrinter();
                    printer.setFilename(commandLineArgs.get(3));
                    printer.setCustomerName(commandLineArgs.get(4));
                    printer.getpretty(call, commandLineArgs.get(5));
                    printer.dump(bill);
                }
                break;
            }

            default: {
                System.err.println("Extraneous or wrong arguments are being printed, this is not allowed.");
                break;
            }

        }
    }

    private static void textFileChecker(ArrayList<String> commandLineArgs) throws ParserException, IOException {
        if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") ||
                (commandLineArgs.get(0).equals("-print") && commandLineArgs.get(1).equals("-textFile") &&
                        commandLineArgs.get(2).contains(".txt")))) {
            indexSeparator(commandLineArgs);
        }
        else if ((commandLineArgs.get(1).contains("-"))) {
                String fileName = commandLineArgs.get(commandLineArgs.indexOf("-pretty"));
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
                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
                if (!allRequiredArgumentsAreValid) {
                    printThisUsageMessage();
                }
                bill.addPhoneCall(call);
                PrettyPrinter printer = new PrettyPrinter();
                System.out.println("\nThis is a pretty file, printing the following Phone details:\n" + printer.getpretty(call, bill.getCustomer()));
            }
    }

    private static void indexSeparator(ArrayList<String> commandLineArgs) throws ParserException, IOException {
        String fileName = commandLineArgs.get(commandLineArgs.indexOf("-textFile"));
        TextDumper dumper = new TextDumper();
        TextParser parser = new TextParser(fileName, commandLineArgs.get(commandLineArgs.indexOf("-textFile")));
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
        boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
        if (!allRequiredArgumentsAreValid) {
            printThisUsageMessage();
        }
        bill.addPhoneCall(call);
        dumper.dump(bill);
        System.out.println("\nA new file called " + fileName + " is created.");
    }

    /*************
     * This method displays the missing args message
     *************/
    public static void printThisUsageMessage()
    {
        System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project-2 [options] <args> args are (in this order):");
        DisplayPhoneBill.printValues();
        System.exit(1);
    }

        /**
         * checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
         *
         * @param commandLineArgs denotes the entries at the command line
         * @return returns the command line input data if it is correct
         */
        static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs) {
            if (commandLineArgs.size() == 11) {

                boolean isCallerNumberValid = HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(3));
                if (!isCallerNumberValid) {
                    return false;
                }
                boolean isCalleeNumberValid = HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(4));
                if (!isCalleeNumberValid) {
                    return false;
                }
                boolean isPhoneCallBeginDateValid = HelperFunctions.checkForValidDate(commandLineArgs.get(5));
                if (!isPhoneCallBeginDateValid) {
                    return false;
                }
                boolean isPhoneCallBeginTimeValid = HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(6));
                if (!isPhoneCallBeginTimeValid) {
                    return false;
                }
                boolean isPhoneCallEndDateValid = HelperFunctions.checkForValidDate(commandLineArgs.get(8));
                if (!isPhoneCallEndDateValid) {
                    return false;
                }
                return HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(9));
            }
            else if (commandLineArgs.size() == 12) {

                boolean isCallerNumberValid = HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(4));
                if (!isCallerNumberValid) {
                    return false;
                }
                boolean isCalleeNumberValid = HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(5));
                if (!isCalleeNumberValid) {
                    return false;
                }
                boolean isPhoneCallBeginDateValid = HelperFunctions.checkForValidDate(commandLineArgs.get(6));
                if (!isPhoneCallBeginDateValid) {
                    return false;
                }
                boolean isPhoneCallBeginTimeValid = HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(7));
                if (!isPhoneCallBeginTimeValid) {
                    return false;
                }
                boolean isPhoneCallEndDateValid = HelperFunctions.checkForValidDate(commandLineArgs.get(9));
                if (!isPhoneCallEndDateValid) {
                    return false;
                }
                return HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(10));
            }
            else if (commandLineArgs.size() == 13) {

                boolean isCallerNumberValid = HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(5));
                if (!isCallerNumberValid) {
                    return false;
                }
                boolean isCalleeNumberValid = HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(6));
                if (!isCalleeNumberValid) {
                    return false;
                }
                boolean isPhoneCallBeginDateValid = HelperFunctions.checkForValidDate(commandLineArgs.get(7));
                if (!isPhoneCallBeginDateValid) {
                    return false;
                }
                boolean isPhoneCallBeginTimeValid = HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(8));
                if (!isPhoneCallBeginTimeValid) {
                    return false;
                }
                boolean isPhoneCallEndDateValid = HelperFunctions.checkForValidDate(commandLineArgs.get(10));
                if (!isPhoneCallEndDateValid) {
                    return false;
                }
                return HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(11));
            }

            else {
                System.err.println("No args. Go check back.");
            }
            return true;
        }
}




