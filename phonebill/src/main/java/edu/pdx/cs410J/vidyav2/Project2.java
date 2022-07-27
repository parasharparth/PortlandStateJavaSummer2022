package edu.pdx.cs410J.vidyav2;
import edu.pdx.cs410J.ParserException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Project2 {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("No arguments passed at the command line.");
            return;}

        boolean readMeFlag = readMeFlagCheck(args);
        if (readMeFlag) {
            String FileContentReadMe = readFromReadMeFileOnly();
            System.out.println(FileContentReadMe);
            return;}

        boolean print = false;
        for (String commandLineArg : args) {
            if (commandLineArg.contains("-print")) {
                print = true;
                break;}}

        ArrayList<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));

        //Case when the number of arguments are less than 10 (bare minimum arguments)
        if (commandLineArgs.size() < 11) {
            System.err.println("There are some missing arguments.");
        }

//        if(commandLineArgs.size() == 9){
//            if((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt")) ||
//                    (commandLineArgs.get(0).equals("-pretty") && commandLineArgs.get(1).equals("-print"))) {
//                int index = 0;
//                for (int i = 0; true; i++) {
//                    if (commandLineArgs.get(i).contains("-pretty")) {
//                        index = i + 1;
//                    }
//                    break;
//                }
//                String fileName = commandLineArgs.get(index);
//                TextDumper dumper = new TextDumper();
//                TextParser parser = new TextParser(fileName, commandLineArgs.get(1));
//                System.out.println("CustomerName: - " + commandLineArgs.get(2));
//                parser.setFilename(fileName);
//                dumper.setFileName(fileName);
//                parser.setCustomerName(commandLineArgs.get(2));
//                PhoneBill bill1 = parser.parse();
//                PhoneCall call1 = new PhoneCall();
//                call1.setCallerName(commandLineArgs.get(2));
//                //call.setCalleeName("commandLineArgs.get(4)");
//                call1.setCallerNumber(commandLineArgs.get(3));
//                call1.setCalleeNumber(commandLineArgs.get(4));
//                //call1.setPhoneCallBeginDate(commandLineArgs.get(5) + commandLineArgs.get(6));
//                call1.setPhoneCallBeginTime(commandLineArgs.get(5),commandLineArgs.get(6) + "PM");
//                //call1.setPhoneCallEndDate(commandLineArgs.get(7));
//                call1.setPhoneCallEndTime(commandLineArgs.get(7) + " " + commandLineArgs.get(8));
//                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
//                if (!allRequiredArgumentsAreValid) {
//                    System.exit(1);
//                }
//                bill1.addPhoneCall(call1);
//                dumper.dump(bill1);
//
//                int numberOfRequiredCommandLineArguments = 10;
//                if (commandLineArgs.size() > numberOfRequiredCommandLineArguments) {
//                    System.err.println("Correct number of values are not entered.");
//                }
//            }
//        }
//        if (commandLineArgs.size() == 10) {
//            if((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") ||
//                    (commandLineArgs.get(0).equals("-print") && commandLineArgs.get(1).equals("-textFile") &&
//                            commandLineArgs.get(2).contains(".txt")))){
//                int index = 0;
//                for (int i = 0; true; i++) {
//                    if (commandLineArgs.get(i).contains("-textFile")) {
//                        index = i + 1;
//                    }
//                    break;
//                }
//                String fileName = commandLineArgs.get(index);
//                TextDumper dumper = new TextDumper();
//                TextParser parser = new TextParser(fileName, commandLineArgs.get(index));
//                System.out.println("CustomerName: - " + commandLineArgs.get(3));
//                parser.setFilename(fileName);
//                dumper.setFileName(fileName);
//                parser.setCustomerName(commandLineArgs.get(3));
//                PhoneBill bill = parser.parse();
//                PhoneCall call = new PhoneCall();
//                call.setCallerName(commandLineArgs.get(3));
//                //call.setCalleeName("commandLineArgs.get(4)");
//                call.setCallerNumber(commandLineArgs.get(4));
//                call.setCalleeNumber(commandLineArgs.get(5));
//                //call.setPhoneCallBeginDate(commandLineArgs.get(6));
//                call.setPhoneCallBeginTime(commandLineArgs.get(6) + " " + commandLineArgs.get(7));
//                //call.setPhoneCallEndDate(commandLineArgs.get(8));
//                call.setPhoneCallEndTime(commandLineArgs.get(8) + " " + commandLineArgs.get(9));
//                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
//                if (!allRequiredArgumentsAreValid) {
//                    return;
//                }
//                bill.addPhoneCall(call);
//                dumper.dump(bill);
//
//                if (print) {
//                    System.out.println(call);
//                } }
//            }
//        else if (commandLineArgs.size() == 11) {
//                System.out.println("This is 11 args.");
//                System.exit(1);
//            }
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
                System.out.println("CustomerName: - " + commandLineArgs.get(2));
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
                    return;
                }
                bill.addPhoneCall(call);
                dumper.dump(bill);

                if (print) {
                    System.out.println(call);
                }
            } else if ((commandLineArgs.get(0).contains("-pretty") && commandLineArgs.get(1).contains(".txt"))) {
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains(".txt")) {
                        index = i + 2;}break;}
                String fileName = commandLineArgs.get(1);
                TextDumper dumper = new TextDumper();
                TextParser parser = new TextParser(fileName, commandLineArgs.get(2));
                parser.setFilename(fileName);
                dumper.setFileName(fileName);
                System.out.println("CustomerName: - " + commandLineArgs.get(2));
                parser.setCustomerName(commandLineArgs.get(2));
                PhoneBill bill = parser.parse();
                //PhoneBill bill = new PhoneBill(commandLineArgs.get(2));
                PhoneCall call = new PhoneCall();
                call.setCallerName(commandLineArgs.get(2));
                call.setCallerNumber(commandLineArgs.get(3));
                call.setCalleeNumber(commandLineArgs.get(4));
                call.setPhoneCallBeginDate(commandLineArgs.get(5));
                call.setPhoneCallBeginTime(commandLineArgs.get(5), commandLineArgs.get(6), commandLineArgs.get(7));
                call.setPhoneCallEndDate(commandLineArgs.get(8));
                call.setPhoneCallEndTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
                boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
                if (!allRequiredArgumentsAreValid) {return;}
                bill.addPhoneCall(call);
                dumper.dump(bill);
                PrettyPrinter printer = new PrettyPrinter();
                //System.out.println("\nThis is a pretty file, printing the following Phone details:\n" + printer.getpretty(call, bill.getCustomer()));
                printer.setFilename(commandLineArgs.get(1));
                printer.setCustomerName(commandLineArgs.get(2));
                printer.getpretty(call, commandLineArgs.get(2));
                printer.dump(bill);
                if (print) {
                    System.out.println(call);
                }
            } else if ((commandLineArgs.get(1).contains("-"))) {
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains("-pretty")) {
                        index = i + 1;
                    }
                    break;
                }
                String fileName = commandLineArgs.get(index);
                TextDumper dumper = new TextDumper();
                //TextParser parser = new TextParser(fileName, commandLineArgs.get(2));
                //parser.setFilename(fileName);
                dumper.setFileName(fileName);
                //parser.setCustomerName(commandLineArgs.get(2));
                //PhoneBill bill = parser.parse();
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
                if (!allRequiredArgumentsAreValid) {return;}
                bill.addPhoneCall(call);
                //dumper.dump(bill);
                PrettyPrinter printer = new PrettyPrinter();
                System.out.println("\nThis is a pretty file, printing the following Phone details:\n" + printer.getpretty(call, bill.getCustomer()));
            }

        }
        else if (commandLineArgs.size() == 12) {
            if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains("-pretty") ||
                    (commandLineArgs.get(0).equals("-pretty") && commandLineArgs.get(1).equals("-textFile") &&
                            commandLineArgs.get(2).contains(".txt")) || commandLineArgs.get(0).contains("-print") &&
                    commandLineArgs.get(1).equals("-pretty") && commandLineArgs.get(2).contains(".txt") ||
                    commandLineArgs.get(0).contains("-pretty") && commandLineArgs.get(1).equals("-print") &&
                            commandLineArgs.get(2).contains(".txt") )) {
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains("-pretty")) {
                        index = i + 2;
                    }
                    break;
                }
                String fileName = commandLineArgs.get(2);
                TextDumper dumper = new TextDumper();
                TextParser parser = new TextParser(fileName, commandLineArgs.get(index));
                System.out.println("CustomerName: - " + commandLineArgs.get(3));
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
                if (print) {
                    System.out.println(call);
                }
            } else if ((commandLineArgs.get(0).contains("-pretty") && commandLineArgs.get(1).contains(".txt"))) {
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains(".txt")) {
                        index = i + 2;
                    }
                    break;
                }
                String fileName = commandLineArgs.get(1);
                TextDumper dumper = new TextDumper();
                TextParser parser = new TextParser(fileName, commandLineArgs.get(2));
                parser.setFilename(fileName);
                dumper.setFileName(fileName);
                System.out.println("CustomerName: - " + commandLineArgs.get(2));
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
                    return;
                }
                bill.addPhoneCall(call);
                dumper.dump(bill);
                PrettyPrinter printer = new PrettyPrinter();
                printer.setFilename(commandLineArgs.get(1));
                printer.setCustomerName(commandLineArgs.get(2));
                printer.getpretty(call, commandLineArgs.get(2));
                printer.dump(bill);
                if (print) {
                    System.out.println(call);
                }
            }
        }
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
                TextParser parser = new TextParser(fileName, commandLineArgs.get(index));
                System.out.println("CustomerName: - " + commandLineArgs.get(4));
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
                    return;
                }
                bill.addPhoneCall(call);
                dumper.dump(bill);

                PrettyPrinter printer = new PrettyPrinter();
                printer.setFilename(commandLineArgs.get(1));
                printer.setCustomerName(commandLineArgs.get(4));
                printer.getpretty(call, commandLineArgs.get(5));
                printer.dump(bill);
                if (print) {
                    System.out.println(call);
                }
            }
            else if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
                    commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).contains("-"))){
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains("-")) {
                        index = i + 1;}
                    break;}
                String fileName = commandLineArgs.get(1);
                TextDumper dumper = new TextDumper();
                TextParser parser = new TextParser(fileName, commandLineArgs.get(4));
                parser.setFilename(fileName);
                dumper.setFileName(fileName);
                System.out.println("CustomerName: - " + commandLineArgs.get(4));
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
            else if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
                    commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).equals(".txt"))){
                int index = 0;
                for (int i = 0; true; i++) {
                    if (commandLineArgs.get(i).contains(".txt")) {
                        index = i + 3;}
                    break;}
                String fileName = commandLineArgs.get(1);
                TextDumper dumper = new TextDumper();
                TextParser parser = new TextParser(fileName, commandLineArgs.get(4));
                parser.setFilename(fileName);
                dumper.setFileName(fileName);
                System.out.println("CustomerName: - " + commandLineArgs.get(4));
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
        }
        else {
            System.err.println("Extraneous or wrong arguments are being printed, this is not allowed.");
        }
    }
    /**
     * checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
     *
     * @param commandLineArgs denotes the entries at the command line
     * @return returns the command line input data if it is correct
     */
    static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs) {
//        if (commandLineArgs.size() == 9) {
//            String callerName = commandLineArgs.get(2);
//            String noOfCaller = commandLineArgs.get(3);
//            String noOfCallee = commandLineArgs.get(4);
//            String dateOfPhoneCallBegin = commandLineArgs.get(5);
//            String timeOfPhoneCallBegin = commandLineArgs.get(6);
//            String dateOfPhoneCallEnd = commandLineArgs.get(7);
//            String timeOfPhoneCallEnd = commandLineArgs.get(8);
//
//            boolean isCallerNumberValid = checkForValidPhoneNumber(commandLineArgs.get(3));
//            if (!isCallerNumberValid) {
//                return false;
//            }
//            boolean isCalleeNumberValid = checkForValidPhoneNumber(commandLineArgs.get(4));
//            if (!isCalleeNumberValid) {
//                return false;
//            }
//            boolean isPhoneCallBeginDateValid = checkForValidDate(commandLineArgs.get(5));
//            if (!isPhoneCallBeginDateValid) {
//                return false;
//            }
//            boolean isPhoneCallBeginTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(6));
//            if (!isPhoneCallBeginTimeValid) {
//                return false;
//            }
//            boolean isPhoneCallEndDateValid = checkForValidDate(commandLineArgs.get(7));
//            if (!isPhoneCallEndDateValid) {
//                return false;
//            }
//            boolean isPhoneCallEndTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(8));
//            return isPhoneCallEndTimeValid;
//        }
//        else if (commandLineArgs.size() == 10) {
//            if (!commandLineArgs.get(2).equals("-print")) {
//                System.out.println("There is an extraneous argument on the command line.");
//            }
//            String callerName = commandLineArgs.get(3);
//            String noOfCaller = commandLineArgs.get(4);
//            String noOfCallee = commandLineArgs.get(5);
//            String dateOfPhoneCallBegin = commandLineArgs.get(6);
//            String timeOfPhoneCallBegin = commandLineArgs.get(7);
//            String dateOfPhoneCallEnd = commandLineArgs.get(8);
//            String timeOfPhoneCallEnd = commandLineArgs.get(9);
//
//            boolean isCallerNumberValid = checkForValidPhoneNumber(commandLineArgs.get(4));
//            if (!isCallerNumberValid) {
//                return false;
//            }
//            boolean isCalleeNumberValid = checkForValidPhoneNumber(commandLineArgs.get(5));
//            if (!isCalleeNumberValid) {
//                return false;
//            }
//            boolean isPhoneCallBeginDateValid = checkForValidDate(commandLineArgs.get(6));
//            if (!isPhoneCallBeginDateValid) {
//                return false;
//            }
//            boolean isPhoneCallBeginTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(7));
//            if (!isPhoneCallBeginTimeValid) {
//                return false;
//            }
//            boolean isPhoneCallEndDateValid = checkForValidDate(commandLineArgs.get(8));
//            if (!isPhoneCallEndDateValid) {
//                return false;
//            }
//            boolean isPhoneCallEndTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(9));
//            return isPhoneCallEndTimeValid;
//        }
        if (commandLineArgs.size() == 11) {

            String callerName = commandLineArgs.get(2);
            String noOfCaller = commandLineArgs.get(3);
            String noOfCallee = commandLineArgs.get(4);
            String dateOfPhoneCallBegin = commandLineArgs.get(5);
            String timeOfPhoneCallBegin = commandLineArgs.get(6);
            String dateOfPhoneCallEnd = commandLineArgs.get(8);
            String timeOfPhoneCallEnd = commandLineArgs.get(9);

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
        }
        else if (commandLineArgs.size() == 12) {

            String callerName = commandLineArgs.get(3);
            String noOfCaller = commandLineArgs.get(4);
            String noOfCallee = commandLineArgs.get(5);
            String dateOfPhoneCallBegin = commandLineArgs.get(6);
            String timeOfPhoneCallBegin = commandLineArgs.get(7);
            String dateOfPhoneCallEnd = commandLineArgs.get(9);
            String timeOfPhoneCallEnd = commandLineArgs.get(10);

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
        }
        else if (commandLineArgs.size() == 13) {

            String callerName = commandLineArgs.get(4);
            String noOfCaller = commandLineArgs.get(5);
            String noOfCallee = commandLineArgs.get(6);
            String dateOfPhoneCallBegin = commandLineArgs.get(7);
            String timeOfPhoneCallBegin = commandLineArgs.get(8);
            String dateOfPhoneCallEnd = commandLineArgs.get(10);
            String timeOfPhoneCallEnd = commandLineArgs.get(11);

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
    static boolean checkForValidPhoneCallTime(String timeOfPhoneCall) {
        String regTime = "\\d{1,2}:\\d\\d";
        boolean validTimeOfPhoneCall = Pattern.compile(regTime).matcher(timeOfPhoneCall).matches();

        if(!validTimeOfPhoneCall){
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
    static boolean checkForValidDate(String dateOfPhoneCall) {
        String regDate = "\\d{1,2}/\\d{1,2}/\\d\\d\\d\\d";
        boolean validDateOfPhoneCall = Pattern.compile(regDate).matcher(dateOfPhoneCall).matches();
        if(!validDateOfPhoneCall){
            //String invalidDateOfPhoneCallMessage = "Date provided is invalid, please retry by entering the correct one's";
            //System.out.println(invalidDateOfPhoneCallMessage);
            return true;
        }
        return true;
    }

    /** checkForValidPhoneNumber() checks the correctness of the entered Phone Number in the
     * correct format
     *
     * @param phoneNumber describes the Phone Number of customer who is making efforts to make a Phone Call
     * @return the Phone Number for the customer
     */
    static boolean checkForValidPhoneNumber(String phoneNumber) {
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
     *The readMeFlagCheck() tells whether optional -README flag has been entered at Command Line
     */
    static boolean readMeFlagCheck(String[] args) {
        int countIdxForREADME = 0;
        for (String arg : args) {
            if (countIdxForREADME > 1) {
                break;
            } else if (arg.toUpperCase().contains("README")) {
                return true;
            } else {
                countIdxForREADME++;
            }
        }
        return false;
    }

    /**
     * The readFromReadMeFileOnly() method is responsible for reading from the README.txt file
     *
     * @return a string of the file contents given
     */
    static String readFromReadMeFileOnly() {
        String line = "";
        try (
                InputStream ReadMe = Project2.class.getResourceAsStream("README.txt")
        ) {
            assert ReadMe != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(ReadMe));
            line = reader.readLine();
        } catch (IOException e) {
            System.out.println("The README.txt file was not able to be located.");
        }
        return line;
    }

}




