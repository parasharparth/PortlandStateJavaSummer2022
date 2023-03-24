package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import groovyjarjarpicocli.CommandLine;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * The main class that parses the command line and communicates with the
 * Phone Bill server using REST.
 */
public class Project4 {

    public static void main(String[] args) throws ParserException, IOException,NullPointerException {
        String fileName= "Project4_PrettyFile";

        if (args.length == 0) {
            System.err.println("No arguments!");
            HelperFunctions.readMeInfo();
            return;
        }


        for (String arg : args) {
            if (arg.equals("-README")) {
                HelperFunctions.readMeInfo();
                return;
            }
        }

            ArrayList<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));

            if (args.length < 5) {
                System.err.println("There are some missing arguments.");
                HelperFunctions.readMeInfo();
                return;
            }
            
        if(commandLineArgs.size() == 14){
            if ((commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port") ||
                    commandLineArgs.get(4).contains("-print") )) {

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
                HelperFunctions.checkHostAndPort(hostName, portName);
                int portNum = Integer.parseInt(portName);
                PhoneBillRestClient client = new PhoneBillRestClient(hostName, portNum);
                String customerName = "";
                PhoneBill bill = new PhoneBill(commandLineArgs.get(5));
                System.out.println(bill);
                PhoneCall call = new PhoneCall();
                call.setCallerName(commandLineArgs.get(5));
                call.setCallerNumber(commandLineArgs.get(6));
                call.setCalleeNumber(commandLineArgs.get(7));
                call.setPhoneCallBeginDate(commandLineArgs.get(8));
                call.setPhoneCallBeginTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
                call.setPhoneCallEndDate(commandLineArgs.get(11));
                call.setPhoneCallEndTime(commandLineArgs.get(11), commandLineArgs.get(12), commandLineArgs.get(13));
                client.addCustomer(customerName,call);
                boolean allRequiredArgumentsAreValid = HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs);
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
                HelperFunctions.checkHostAndPort(hostName, portName);
                int portNum = Integer.parseInt(portName);
                PhoneBillRestClient client = new PhoneBillRestClient(hostName, portNum);
                String customerName = "";
                PhoneBill bill = new PhoneBill(commandLineArgs.get(4));
                System.out.println(bill);
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
                HelperFunctions.checkHostAndPort(hostName, portName);
                int portNum = Integer.parseInt(portName);
                PhoneBillRestClient client = new PhoneBillRestClient(hostName, portNum);
                System.out.println(client);
                String customerName = "";
                PhoneBill bill = new PhoneBill(commandLineArgs.get(5));
                System.out.println(customerName + bill);
                PhoneCall call = new PhoneCall();
                call.setCallerName(commandLineArgs.get(5));
                call.setCallerNumber("111-222-3333");
                call.setCalleeNumber("111-222-3333");
                call.setPhoneCallBeginDate(commandLineArgs.get(6));
                call.setPhoneCallBeginTime(commandLineArgs.get(6), commandLineArgs.get(7), commandLineArgs.get(8));
                call.setPhoneCallEndDate(commandLineArgs.get(9));
                call.setPhoneCallEndTime(commandLineArgs.get(9), commandLineArgs.get(10), commandLineArgs.get(11));
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
}