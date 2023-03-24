package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/*****************************************************
 * The main class for the CS410J phone bill Project
 *****************************************************/
public class Project2 {



    /********************************************************************************************************************************************
     * Check if the -print flag is present in the command line arguments
     * Convert the command line arguments to an ArrayList for easier manipulation
     * Check if the -README flag is present in the command line arguments
     * @throws Exception
     * commandLineArgs.size() Checks if there are at least 11 command line arguments (excluding the -print and -README flags)
     * Check how many command line arguments were passed where we have used switch case.
     * If no arguments were passed, display a usage message
     * If 11 arguments were passed, check if a text file was specified
     * If 12 arguments were passed, check if a text file and/or a pretty-print file was specified
     * Then check if the user specified a text file and pretty-print file with the -textFile and -pretty flags
     * Parse the phone bill from the specified text file
     * Create a new phone call from the command line arguments and add it to the phone bill
     * textFileChecker() checks if "-textFile" option is present in command line args
     * if "-textFile" option is not present and the second argument contains a hyphen, extract the filename from the "-pretty" option argument
     * create a new phone bill object with the customer name provided in command line args
     * create a new phone call object and set its properties based on command line args
     * check if all required command line args are valid, if not, print a usage message and exit
     * add the phone call to the phone bill object
     * create a pretty printer object and print the phone call details
     * indexSeparator() takes an arraylist of strings as parameter and throws ParserException and IOException
     * Create a TextDumper object to write the phone bill to a text file
     * Create a TextParser object to parse the phone bill from the text file
     * Parse the phone bill from the text file using the TextParser object
     * Create a new phone call object and Set the caller name, caller number, and callee number for the phone call object
     * Set the begin and end date and time for the phone call object
     * Add the phone call to the phone bill and write the phone bill to a text file using the TextDumper object
     * printThisUsageMessage() displays the missing arguments message and then exits.
     **********************************************************************************************************************************************/


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
                BaseConditions.baseCondition12(commandLineArgs);
                break;
            }

            case 13: {
                if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
                        commandLineArgs.get(2).equals("-pretty") && !commandLineArgs.get(3).equals("-"))) {
                    BaseConditions.baseCondition13PrettyFileDump(commandLineArgs);
                    if (!HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs)) {
                        HelperFunctions.printThisUsageMessage();
                    }

                }
                else if (BaseConditions.baseCondition13(commandLineArgs)){
                    BaseConditions.baseCondition13FileDump(commandLineArgs);
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
            BaseConditions.setName(commandLineArgs, bill, call);
            PrettyPrinter printer = new PrettyPrinter();
                System.out.println("\nThis is a pretty file, printing the following Phone details:\n" + printer.getPretty(call, bill.getCustomer()));
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
        BaseConditions.setCaller(commandLineArgs, dumper, bill, call);
        System.out.println("\nA new file called " + fileName + " is created.");
    }



}




