package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * The main class that parses the command line and communicates with the
 * Phone Bill server using REST.
 */
public class Project4 {

    public static void main(String[] args) throws ParserException, IOException,NullPointerException {
        String hostname = null;
        int port = 0;
        String prettyFileName=null;
        String fileName= "Project4_PrettyFile";


        if (args.length == 0) {
            System.err.println("No arguments!");
            readmeinfo();
            return;
        }


        for (String arg : args) {
            if (arg.equals("-README")) {
                readmeinfo();
                return;
            }
        }
        
//            String hostName = args[1];
//            String portName;

            ArrayList<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));

            if (args.length < 5) {
                System.err.println("There are some missing arguments.");
                readmeinfo();
                return;
            }
            
        if(commandLineArgs.size() == 14){
            if ((commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port") ||
                    commandLineArgs.get(4).contains("-print") )) {
                int index = 0;
                for (int i = 0; i < commandLineArgs.size(); i++) {
                    if (commandLineArgs.get(i).contains("-print")) {
                        index = i + 2;
                        break;
                    }
                }
                String hostName = "";
                String portName = "";
                for (int i = 0; i < args.length; i++) {
                    if (args[i].equals("-host")) {
                        hostName = args[i + 1];
                    }
                    if (args[i].equals("-port")) {
                        portName = args[i + 1];
                    }
                }
                checkhostandport(hostName, portName);
                int portnum = Integer.parseInt(portName);
                PhoneBillRestClient client = new PhoneBillRestClient(hostName, portnum);
                String customerName = "";
                PhoneBill bill = new PhoneBill(commandLineArgs.get(5));
                PhoneCall call = new PhoneCall();
                call.setCallerName(commandLineArgs.get(5));
                call.setCallerNumber(commandLineArgs.get(6));
                call.setCalleeNumber(commandLineArgs.get(7));
                call.setPhoneCallBeginDate(commandLineArgs.get(8));
                call.setPhoneCallBeginTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
                call.setPhoneCallEndDate(commandLineArgs.get(11));
                call.setPhoneCallEndTime(commandLineArgs.get(11), commandLineArgs.get(12), commandLineArgs.get(13));
                client.addCustomer(customerName, call);
                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
                if (!allRequiredArgumentsAreValid) {
                    return;
                }
                for (String arg : args) {
                    if (arg.equals("-print")) {
                        System.out.println("This is the Printed text:");
                        System.out.println("CallerNumber : " + commandLineArgs.get(6));
                        System.out.println("CalleeNumber : " + commandLineArgs.get(7));
                        System.out.println("Date of Begin : " + commandLineArgs.get(8));
                        System.out.println("Time of Begin : " + commandLineArgs.get(9) + " " + commandLineArgs.get(10));
                        System.out.println("Date of End : " + commandLineArgs.get(11));
                        System.out.println("Time of End : " + commandLineArgs.get(12) + " " + commandLineArgs.get(13));
                    }

                }
            }

        }
     //   0)-host 1)localhost 2)-port 3)12345 \
      //  4)"Dave" 5)503-245-2345 6)765-389-1273 7)02/27/2022 8)8:56 9)am 10)02/27/2022 11)10:27 12)am
        else if(commandLineArgs.size() == 13){
            if ((commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port") )) {
                String hostName = "";
                String portName = "";
                for (int i = 0; i < args.length; i++) {
                    if (args[i].equals("-host")) {
                        hostName = args[i + 1];
                    }
                    if (args[i].equals("-port")) {
                        portName = args[i + 1];
                    }
                }
                checkhostandport(hostName, portName);
                int portnum = Integer.parseInt(portName);
                PhoneBillRestClient client = new PhoneBillRestClient(hostName, portnum);
                String customerName = "";
                PhoneBill bill = new PhoneBill(commandLineArgs.get(4));
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
                    return;
                }
                client.addCustomer(customerName, call);
                System.err.println("\nThis is to inform you that the server cannot be contacted at the moment. " +
                        "Please connect to the server and retry.");
            }
        }
        else if (commandLineArgs.size() == 12) {
            if ((commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port") ||
                    (commandLineArgs.get(4).equals("-search") || (commandLineArgs.get(0).equals("-search") ||
                            commandLineArgs.get(3).contains("-port") || (commandLineArgs.get(1).contains("-host")))))) {
                int index = 0;
                for (int i = 0; i < commandLineArgs.size(); i++) {
                    if (commandLineArgs.get(i).contains("-search")) {
                        index = i + 2;
                        break;
                    }
                }
                String hostName = "";
                String portName = "";
                for (int i = 0; i < args.length; i++) {
                    if (args[i].equals("-host")) {
                        hostName = args[i + 1];
                    }
                    if (args[i].equals("-port")) {
                        portName = args[i + 1];
                    }
                }
                checkhostandport(hostName, portName);
                int portnum = Integer.parseInt(portName);
                PhoneBillRestClient client = new PhoneBillRestClient(hostName, portnum);
                String customerName = "";
                //PhoneBill bill = new PhoneBill(commandLineArgs.get(5));
                PhoneCall call = new PhoneCall();
                call.setCallerName(commandLineArgs.get(5));
                call.setCallerNumber("111-222-3333");
                call.setCalleeNumber("111-222-3333");
                call.setPhoneCallBeginDate(commandLineArgs.get(6));
                call.setPhoneCallBeginTime(commandLineArgs.get(6), commandLineArgs.get(7), commandLineArgs.get(8));
                call.setPhoneCallEndDate(commandLineArgs.get(9));
                call.setPhoneCallEndTime(commandLineArgs.get(9), commandLineArgs.get(10), commandLineArgs.get(11));
                //client.addCustomer(commandLineArgs.get(5), call);
                client.addCustomer(customerName, call);
                System.out.println("Error");
            }
        }
        else if (commandLineArgs.size() == 5) {
            if ((commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port"))) {
                int index = 0;
                for (int i = 0; i < commandLineArgs.size(); i++) {
                    if (commandLineArgs.get(i).contains("-host")) {
                        index = i + 2;
                        break;
                    }
                }
                TextDumper dumper = new TextDumper();
                TextParser parser = new TextParser(fileName, commandLineArgs.get(index));
                System.out.println("CustomerName: - " + commandLineArgs.get(4));
                parser.setFilename(fileName);
                dumper.setFileName(fileName);
                parser.setCustomerName(commandLineArgs.get(4));
                PhoneBill bill = parser.parse();
                PhoneCall call = new PhoneCall();
                bill.addPhoneCall();
                dumper.dump(bill);

                PrettyPrinter printer = new PrettyPrinter();
                System.out.println("This is the pretty text:");
                //System.out.println("Customer : " + call.getCaller());
                System.out.println("CallerNumber : " + call.getCallerNumber());
                System.out.println("CalleeNumber : " + call.getCalleeNumber());
                System.out.println("Date of Begin : " + call.getPhoneCallBeginDate());
                System.out.println("Time of Begin : " + call.getPhoneCallBeginTime());
                System.out.println("Date of End : " + call.getPhoneCallEndDate());
                System.out.println("Time of End : " + call.getPhoneCallEndTime());
                printer.setFilename("Project4_PrettyFile");
                printer.setCustomerName(commandLineArgs.get(4));
                printer.getpretty(call, commandLineArgs.get(4));

                printer.dump(bill);
            }
        } else if (commandLineArgs.size() == 15) {
            System.out.println("Extraneous Arguments.\nPlease check the number of arguments entered.");
        }
    }


    public static void checkhostandport(String hostName, String portName) {
        if (hostName == null) {
            System.err.println("Missing hostname!");
            System.exit(1);

        } else if ( portName == null) {
            System.err.println("Missing port number!");
            System.exit(1);
        }
        int portnum;
        try {
            portnum = Integer.parseInt( portName );

        } catch (NumberFormatException ex) {
            System.err.println("Port Number must be an integer!");
            System.exit(1);
        }
    }

        /**
         * checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
         *
         * @param commandLineArgs denotes the entries at the command line
         * @return returns the command line input data if it is correct
         */
        public static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs)
        {
            if (commandLineArgs.size() == 12) {

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
            }
            else if (commandLineArgs.size() == 13) {

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
            }
            else if (commandLineArgs.size() == 14) {

                boolean isCallerNumberValid = checkForValidPhoneNumber(commandLineArgs.get(6));
                if (!isCallerNumberValid) {
                    return false;
                }
                boolean isCalleeNumberValid = checkForValidPhoneNumber(commandLineArgs.get(7));
                if (!isCalleeNumberValid) {
                    return false;
                }
                boolean isPhoneCallBeginDateValid = checkForValidDate(commandLineArgs.get(8));
                if (!isPhoneCallBeginDateValid) {
                    return false;
                }
                boolean isPhoneCallBeginTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(9));
                if (!isPhoneCallBeginTimeValid) {
                    return false;
                }
                boolean isPhoneCallEndDateValid = checkForValidDate(commandLineArgs.get(11));
                if (!isPhoneCallEndDateValid) {
                    return false;
                }
                return checkForValidPhoneCallTime(commandLineArgs.get(12));
            }
            else {
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
        System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project4 [options] <args> args are (in this order):");
        System.out.println("customer --> Person whose phone bill we???re modeling");
        System.out.println("callerNumber --> Phone number of caller");
        System.out.println("calleeNumber --> Phone number of person who was called");
        System.out.println("begin --> Date and time (am/pm) call began");
        System.out.println("end --> Date and time (am/pm) call ended");
        System.out.println("\nOptions are (options may appear in any order):");
        System.out.println("-host hostname --> Host computer on which the server runs");
        System.out.println("-port port --> Port on which the server is listening");
        System.out.println("-search --> Phone calls should be searched for");
        System.out.println("-print --> Prints a description of the new phone call");
        System.out.println("-README --> Prints a README for this project and exits");
    }
}