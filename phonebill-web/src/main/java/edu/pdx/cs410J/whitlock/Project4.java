package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.vidyav2.PhoneBill;
import edu.pdx.cs410J.vidyav2.PhoneCall;
import edu.pdx.cs410J.vidyav2.PrettyPrinter;
import edu.pdx.cs410J.vidyav2.TextDumper;
import edu.pdx.cs410J.vidyav2.TextParser;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * The main class that parses the command line and communicates with the
 * Phone Bill server using REST.
 */
public class Project4 {

    public static void main(String[] args) throws ParserException, IOException {
        //This is the case when there are no arguments
        if (args.length == 0) {
            System.err.println("No arguments!");
            return;
        }

        //This is the case when -README is included
        for (String arg : args) {
            if (arg.equals("-README")) {
                readmeinfo();
            }
        }

        String hostName = args[1];
        int portName;
        //hostName = args[5];
        if (args[1] == null) {
            System.err.println("The port number cannot be null");
        }
        portName = Integer.parseInt(args[3]);
        if (hostName == null) {
            System.err.println("The hostname cannot be null");
            return;
        }
        if (portName == 0) {
            System.err.println("The port number cannot be 0");
        }

        ArrayList<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));

        //Case when the number of arguments are less than 10 (bare minimum arguments)
        if (commandLineArgs.size() < 13) {
            System.err.println("There are some missing arguments.");
        }

        if (commandLineArgs.size() == 13) {

        }
//            if ((commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port"))) {
//                int index = 0;
//                for (int i = 0; i<commandLineArgs.size(); i++) {
//                    if (commandLineArgs.get(i).contains("-host")) {
//                        index = i;
//                    }
//                }
//                String fileName = commandLineArgs.get(index);
//                edu.pdx.cs410J.vidyav2.TextDumper dumper = new edu.pdx.cs410J.vidyav2.TextDumper();
//                edu.pdx.cs410J.vidyav2.TextParser parser = new edu.pdx.cs410J.vidyav2.TextParser(fileName, commandLineArgs.get(index));
//                System.out.println("CustomerName: - " + commandLineArgs.get(2));
//                parser.setFilename(fileName);
//                dumper.setFileName(fileName);
//                parser.setCustomerName(commandLineArgs.get(2+3));
//                edu.pdx.cs410J.vidyav2.PhoneBill bill = parser.parse();
//                PhoneCall call = new PhoneCall();
//                call.setCallerName(commandLineArgs.get(2));
//                call.setCallerNumber(commandLineArgs.get(3));
//                call.setCalleeNumber(commandLineArgs.get(4));
//                call.setPhoneCallBeginDate(commandLineArgs.get(5));
//                call.setPhoneCallBeginTime(commandLineArgs.get(5), commandLineArgs.get(6), commandLineArgs.get(7));
//                call.setPhoneCallEndDate(commandLineArgs.get(8));
//                call.setPhoneCallEndTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
//                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
//                if (!allRequiredArgumentsAreValid) {
//                    return;
//                }
//                bill.addPhoneCall(call);
//                dumper.dump(bill);
//            } else if ((commandLineArgs.get(1).contains("-"))) {
//                int index ;
//                for (int i = 0; true; i++) {
//                    if (commandLineArgs.get(i).contains("-pretty")) {
//                        index = i;
//                        break;
//                    }
//                }
//                String fileName = commandLineArgs.get(index);
//                edu.pdx.cs410J.vidyav2.TextDumper dumper = new edu.pdx.cs410J.vidyav2.TextDumper();
//                dumper.setFileName(fileName);
//                edu.pdx.cs410J.vidyav2.PhoneBill bill = new edu.pdx.cs410J.vidyav2.PhoneBill(commandLineArgs.get(2));
//                PhoneCall call = new PhoneCall();
//                call.setCallerName(commandLineArgs.get(2));
//                call.setCallerNumber(commandLineArgs.get(3));
//                call.setCalleeNumber(commandLineArgs.get(4));
//                call.setPhoneCallBeginDate(commandLineArgs.get(5));
//                call.setPhoneCallBeginTime(commandLineArgs.get(5), commandLineArgs.get(6), commandLineArgs.get(7));
//                call.setPhoneCallEndDate(commandLineArgs.get(8));
//                call.setPhoneCallEndTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
//                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
//                if (!allRequiredArgumentsAreValid) {
//                    return;
//                }
//                bill.addPhoneCall(call);
//                edu.pdx.cs410J.vidyav2.PrettyPrinter printer = new edu.pdx.cs410J.vidyav2.PrettyPrinter();
//                System.out.println("\nThis is a pretty file, printing the following Phone details:\n" + printer.getpretty(call, bill.getCustomer()));
//            }
//
//        } else if (commandLineArgs.size() == 12) {
//            if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains("-pretty") ||
//                    (commandLineArgs.get(0).equals("-pretty") && commandLineArgs.get(1).equals("-textFile") &&
//                            commandLineArgs.get(2).contains(".txt")) || commandLineArgs.get(0).contains("-print") &&
//                    commandLineArgs.get(1).equals("-pretty") && commandLineArgs.get(2).contains(".txt") ||
//                    commandLineArgs.get(0).contains("-pretty") && commandLineArgs.get(1).equals("-print") &&
//                            commandLineArgs.get(2).contains(".txt"))) {
//                int index = 0;
//                for (int i = 0; i<commandLineArgs.size(); i++) {
//                    if (commandLineArgs.get(i).contains("-pretty")) {
//                        index = i + 2;
//                        break;
//                    }
//                }
//                String fileName = commandLineArgs.get(2);
//                edu.pdx.cs410J.vidyav2.TextDumper dumper = new edu.pdx.cs410J.vidyav2.TextDumper();
//                edu.pdx.cs410J.vidyav2.TextParser parser = new edu.pdx.cs410J.vidyav2.TextParser(fileName, commandLineArgs.get(index));
//                System.out.println("CustomerName: - " + commandLineArgs.get(3));
//                parser.setFilename(fileName);
//                dumper.setFileName(fileName);
//                parser.setCustomerName(commandLineArgs.get(3));
//                edu.pdx.cs410J.vidyav2.PhoneBill bill = parser.parse();
//                PhoneCall call = new PhoneCall();
//                call.setCallerName(commandLineArgs.get(3));
//                call.setCallerNumber(commandLineArgs.get(4));
//                call.setCalleeNumber(commandLineArgs.get(5));
//                call.setPhoneCallBeginDate(commandLineArgs.get(6));
//                call.setPhoneCallBeginTime(commandLineArgs.get(6), commandLineArgs.get(7), commandLineArgs.get(8));
//                call.setPhoneCallEndDate(commandLineArgs.get(9));
//                call.setPhoneCallEndTime(commandLineArgs.get(9), commandLineArgs.get(10), commandLineArgs.get(11));
//                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
//                if (!allRequiredArgumentsAreValid) {
//                    return;
//                }
//                bill.addPhoneCall(call);
//                dumper.dump(bill);
//
//                edu.pdx.cs410J.vidyav2.PrettyPrinter printer = new edu.pdx.cs410J.vidyav2.PrettyPrinter();
//                printer.setFilename(commandLineArgs.get(2));
//                printer.setCustomerName(commandLineArgs.get(3));
//                printer.getpretty(call, commandLineArgs.get(4));
//                printer.dump(bill);
//            } else if ((commandLineArgs.get(0).contains("-pretty") && commandLineArgs.get(1).contains(".txt"))) {
//                 String fileName = commandLineArgs.get(1);
//                edu.pdx.cs410J.vidyav2.TextDumper dumper = new edu.pdx.cs410J.vidyav2.TextDumper();
//                edu.pdx.cs410J.vidyav2.TextParser parser = new edu.pdx.cs410J.vidyav2.TextParser(fileName, commandLineArgs.get(2));
//                parser.setFilename(fileName);
//                dumper.setFileName(fileName);
//                System.out.println("CustomerName: - " + commandLineArgs.get(2));
//                parser.setCustomerName(commandLineArgs.get(2));
//                edu.pdx.cs410J.vidyav2.PhoneBill bill = parser.parse();
//                PhoneCall call = new PhoneCall();
//                call.setCallerName(commandLineArgs.get(2));
//                call.setCallerNumber(commandLineArgs.get(3));
//                call.setCalleeNumber(commandLineArgs.get(4));
//                call.setPhoneCallBeginDate(commandLineArgs.get(5));
//                call.setPhoneCallBeginTime(commandLineArgs.get(5), commandLineArgs.get(6), commandLineArgs.get(7));
//                call.setPhoneCallEndDate(commandLineArgs.get(8));
//                call.setPhoneCallEndTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
//                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
//                if (!allRequiredArgumentsAreValid) {
//                    return;
//                }
//                bill.addPhoneCall(call);
//                dumper.dump(bill);
//                edu.pdx.cs410J.vidyav2.PrettyPrinter printer = new edu.pdx.cs410J.vidyav2.PrettyPrinter();
//                printer.setFilename(commandLineArgs.get(1));
//                printer.setCustomerName(commandLineArgs.get(2));
//                printer.getpretty(call, commandLineArgs.get(2));
//                printer.dump(bill);
//                }
//            }
//         else if (commandLineArgs.size() == 13) {
//            if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
//                    commandLineArgs.get(2).equals("-pretty") && !commandLineArgs.get(3).equals("-"))) {
//                String fileName = commandLineArgs.get(1);
//                edu.pdx.cs410J.vidyav2.TextDumper dumper = new edu.pdx.cs410J.vidyav2.TextDumper();
//                edu.pdx.cs410J.vidyav2.TextParser parser = new edu.pdx.cs410J.vidyav2.TextParser(fileName, commandLineArgs.get(2));
//                System.out.println("CustomerName: - " + commandLineArgs.get(4));
//                parser.setFilename(fileName);
//                dumper.setFileName(fileName);
//                parser.setCustomerName(commandLineArgs.get(4));
//                edu.pdx.cs410J.vidyav2.PhoneBill bill = parser.parse();
//                PhoneCall call = new PhoneCall();
//                call.setCallerName(commandLineArgs.get(4));
//                call.setCallerNumber(commandLineArgs.get(5));
//                call.setCalleeNumber(commandLineArgs.get(6));
//                call.setPhoneCallBeginDate(commandLineArgs.get(7));
//                call.setPhoneCallBeginTime(commandLineArgs.get(7), commandLineArgs.get(8), commandLineArgs.get(9));
//                call.setPhoneCallEndDate(commandLineArgs.get(10));
//                call.setPhoneCallEndTime(commandLineArgs.get(10), commandLineArgs.get(11), commandLineArgs.get(12));
//                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
//                if (!allRequiredArgumentsAreValid) {
//                    return;
//                }
//                bill.addPhoneCall(call);
//                dumper.dump(bill);
//
//                edu.pdx.cs410J.vidyav2.PrettyPrinter printer = new edu.pdx.cs410J.vidyav2.PrettyPrinter();
//                printer.setFilename(commandLineArgs.get(3));
//                printer.setCustomerName(commandLineArgs.get(4));
//                printer.getpretty(call, commandLineArgs.get(5));
//                printer.dump(bill);
//            } else if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
//                    (commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).contains("-")) ||
//                    (commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).contains(".txt")))) {
//
//                String fileName = commandLineArgs.get(1);
//                edu.pdx.cs410J.vidyav2.TextDumper dumper = new TextDumper();
//                edu.pdx.cs410J.vidyav2.TextParser parser = new TextParser(fileName, commandLineArgs.get(4));
//                parser.setFilename(fileName);
//                dumper.setFileName(fileName);
//                System.out.println("CustomerName: - " + commandLineArgs.get(4));
//                parser.setCustomerName(commandLineArgs.get(4));
//                PhoneBill bill = parser.parse();
//                PhoneCall call = new PhoneCall();
//                call.setCallerName(commandLineArgs.get(4));
//                call.setCallerNumber(commandLineArgs.get(5));
//                call.setCalleeNumber(commandLineArgs.get(6));
//                call.setPhoneCallBeginDate(commandLineArgs.get(7));
//                call.setPhoneCallBeginTime(commandLineArgs.get(7), commandLineArgs.get(8), commandLineArgs.get(9));
//                call.setPhoneCallEndDate(commandLineArgs.get(10));
//                call.setPhoneCallEndTime(commandLineArgs.get(10), commandLineArgs.get(11), commandLineArgs.get(12));
//                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
//                if (!allRequiredArgumentsAreValid) {
//                    return;
//                }
//                bill.addPhoneCall(call);
//                dumper.dump(bill);
//                edu.pdx.cs410J.vidyav2.PrettyPrinter printer = new PrettyPrinter();
//                printer.setFilename(commandLineArgs.get(3));
//                printer.setCustomerName(commandLineArgs.get(4));
//                printer.getpretty(call, commandLineArgs.get(5));
//                printer.dump(bill);
//            } else {
//                System.err.println("Extraneous or wrong arguments are being printed, this is not allowed.");
//            }
//        }
   }
        /**
         * checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
         *
         * @param commandLineArgs denotes the entries at the command line
         * @return returns the command line input data if it is correct
         */
        public static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs)
        {

            if (commandLineArgs.size() == 11) {

                boolean isCallerNumberValid = checkForValidPhoneNumber(commandLineArgs.get(3));
                if (!isCallerNumberValid) {
                    return false;
                }
                boolean isCalleeNumberValid = checkForValidPhoneNumber(commandLineArgs.get(4));
                if (!isCalleeNumberValid) {
                    return false;
                }
                boolean isPhoneCallBeginDateValid = checkForValidDate(commandLineArgs.get(5));
                if (!isPhoneCallBeginDateValid) {
                    return false;
                }
                boolean isPhoneCallBeginTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(6));
                if (!isPhoneCallBeginTimeValid) {
                    return false;
                }
                boolean isPhoneCallEndDateValid = checkForValidDate(commandLineArgs.get(8));
                if (!isPhoneCallEndDateValid) {
                    return false;
                }
                return checkForValidPhoneCallTime(commandLineArgs.get(9));
            } else if (commandLineArgs.size() == 12) {


                boolean isCallerNumberValid = checkForValidPhoneNumber(commandLineArgs.get(4));
                if (!isCallerNumberValid) {
                    return false;
                }
                boolean isCalleeNumberValid = checkForValidPhoneNumber(commandLineArgs.get(5));
                if (!isCalleeNumberValid) {
                    return false;
                }
                boolean isPhoneCallBeginDateValid = checkForValidDate(commandLineArgs.get(6));
                if (!isPhoneCallBeginDateValid) {
                    return false;
                }
                boolean isPhoneCallBeginTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(7));
                if (!isPhoneCallBeginTimeValid) {
                    return false;
                }
                boolean isPhoneCallEndDateValid = checkForValidDate(commandLineArgs.get(9));
                if (!isPhoneCallEndDateValid) {
                    return false;
                }
                return checkForValidPhoneCallTime(commandLineArgs.get(10));
            } else if (commandLineArgs.size() == 13) {

                boolean isCallerNumberValid = checkForValidPhoneNumber(commandLineArgs.get(5));
                if (!isCallerNumberValid) {
                    return false;
                }
                boolean isCalleeNumberValid = checkForValidPhoneNumber(commandLineArgs.get(6));
                if (!isCalleeNumberValid) {
                    return false;
                }
                boolean isPhoneCallBeginDateValid = checkForValidDate(commandLineArgs.get(7));
                if (!isPhoneCallBeginDateValid) {
                    return false;
                }
                boolean isPhoneCallBeginTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(8));
                if (!isPhoneCallBeginTimeValid) {
                    return false;
                }
                boolean isPhoneCallEndDateValid = checkForValidDate(commandLineArgs.get(10));
                if (!isPhoneCallEndDateValid) {
                    return false;
                }
                return checkForValidPhoneCallTime(commandLineArgs.get(11));
            } else {
                System.err.println("No args. Go check back.");
            }
            return true;
        }

        /** checkForValidPhoneCallTime() method is used to describe the correctness of the Time specified for a
         * Phone Call created
         *
         * @param timeOfPhoneCall parameter tells about the time of the Phone Call start/end
         * @return the value of the Phone Call time validity
         */
        static boolean checkForValidPhoneCallTime (String timeOfPhoneCall){
            String regTime = "\\d{1,2}:\\d\\d";
            boolean validTimeOfPhoneCall = Pattern.compile(regTime).matcher(timeOfPhoneCall).matches();

            if (!validTimeOfPhoneCall) {
                String invalidTimeOfPhoneCallMessage = "PhoneCall Time Argument provided is invalid, please retry by entering the correct one's";
                System.out.println(invalidTimeOfPhoneCallMessage);
                return false;
            }
            return true;
        }


        /** checkForValidDate() checks the correctness of the entered Date
         *
         * @param dateOfPhoneCall describes the date of Phone Call start/end
         * @return the start or end Date of Phone Call
         */
        static boolean checkForValidDate (String dateOfPhoneCall){
            String regDate = "\\d{1,2}/\\d{1,2}/\\d\\d\\d\\d";
            return Pattern.compile(regDate).matcher(dateOfPhoneCall).matches();
        }

        /** checkForValidPhoneNumber() checks the correctness of the entered Phone Number in the
         * correct format
         *
         * @param phoneNumber describes the Phone Number of customer who is making efforts to make a Phone Call
         * @return the Phone Number for the customer
         */
        static boolean checkForValidPhoneNumber (String phoneNumber){
            String regPhoneNumber = "\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d";
            boolean validNumberOfCaller = Pattern.compile(regPhoneNumber).matcher(phoneNumber).matches();
            if (!validNumberOfCaller) {
                String invalidPhoneNumberMessage = "Phone Number provided is invalid, please retry by entering the correct one's";
                System.out.println(invalidPhoneNumberMessage);
                return false;
            }
            return true;
        }

    /**
     * This method prints out the README information for this project and exits
     */
    public static void readmeinfo(){
        System.out.println("README for Project 4\nName: Vidyavarshini");
        System.out.println("Project 4 : A REST-ful Phone Bill Web Service");
//        System.out.println("This project will extend my airline application to support an airline server that provides REST-ful web services to an airline client.");
//        System.out.println("The Airline class extends AbstractAirline and the Flight class extends AbstractFlight");
//        System.out.println("Airline class - it has a name and consists of multiple flights.");
//        System.out.println("Flight class - it consists of details like flightnumber, source, departure time, destination, arrival time.");
//        System.out.println("Project3 class - it consists of the main method that parses the command line, creates an Airline and a FLight as specified.\nIt adds the Flight to the Airline and optionally prints a description of the flight.");
//        System.out.println("PrettyPrinter class - it prints the list of flights in an airline in a pretty way");
//        System.out.println("XmlDumper class - it converts the airline object into XML format");
//        System.out.println("XmlParser class - it converts the airline in XML format into an airline object");
//        System.out.println("AirlineRestClient class - it is the REST client via which our program interact with the server");
//        System.out.println("AirlineServlet class - it provides REST access to the airline");
        System.exit(0);
    }
}