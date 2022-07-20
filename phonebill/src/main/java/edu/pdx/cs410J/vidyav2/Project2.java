package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project2 {
    public static void main(String[] args) throws Exception {
        int totalCommandLineArgumentsConsidered = args.length;
        if (totalCommandLineArgumentsConsidered == 0) {
            System.out.println("No arguments passed at the command line");
            return;
        }

        boolean readMeFlag = readMeFlagCheck(args);
        if (readMeFlag) {
            String FileContentReadMe = readFromReadMeFileOnly();
            System.out.println(FileContentReadMe);
            return;
        }

        //copying command line arguments to a new arraylist
        ArrayList<String> commandLineArgs = new ArrayList<>();

        boolean print = false;
        for (String commandLineArg : commandLineArgs) {
            if (commandLineArg.contains("-print")) {
                print = true;
            }
        }

//    int countIdxValueForPrint = 0;
//    for (String arg : args) {
//      if (countIdxValueForPrint > 3) {
//        break;
//      }
//      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 0)) {
//        print = true;
//        break;
//      }
//      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 3)) {
//
//        System.out.println("Entered values are in wrong order");
//        return;
//      }
//      else {
//        countIdxValueForPrint++;
//      }
//    }

        if (commandLineArgs.size() == 10) {
            int index = 0;
            for (int i = 0; true; i++) {
                if (commandLineArgs.get(i).contains("-textFile")) {
                    index = i + 1;
                }
                break;
            }
            String fileName = commandLineArgs.get(index);
            TextDumper dumper = new TextDumper();
            TextParser parser = new TextParser(fileName, commandLineArgs.get(3));
            System.out.println("CustomerName: - " + commandLineArgs.get(3));
            parser.setFilename(fileName);
            dumper.setFileName(fileName);
            parser.setCustomerName(commandLineArgs.get(3));
            PhoneBill bill = parser.parse();
            //Add details from command line arguments to bill.calls
            PhoneCall call = new PhoneCall();
            call.setCallerName(commandLineArgs.get(3));
            //call.setCalleeName("commandLineArgs.get(4)");
            call.setCallerNumber(commandLineArgs.get(4));
            call.setCalleeNumber(commandLineArgs.get(5));
            call.setPhoneCallBeginDate(commandLineArgs.get(6));
            call.setPhoneCallBeginTime(commandLineArgs.get(7));
            call.setPhoneCallEndDate(commandLineArgs.get(8));
            call.setPhoneCallEndTime(commandLineArgs.get(9));
            bill.addPhoneCall(call);
            dumper.dump(bill);

            //Creating and adding phone call for the customer
//            PhoneCall call = new PhoneCall(commandLineArgs.get(3), commandLineArgs.get(4), commandLineArgs.get(5), commandLineArgs.get(6)
//                    , commandLineArgs.get(7), commandLineArgs.get(8), commandLineArgs.get(9));
//
//            PhoneBill bill = new PhoneBill(commandLineArgs.get(0));
            //bill.addPhoneCall(call);

            if (print) {
                System.out.println(call);
            }
        }

        else {
          int index = 0;
            for (int i = 0; true; i++) {
                if (commandLineArgs.get(i).contains("-textFile")) {
                    index = i + 1;
                }
                break;
            }
            String fileName = commandLineArgs.get(index);
            TextDumper dumper = new TextDumper();
            TextParser parser = new TextParser(fileName, commandLineArgs.get(1));
            System.out.println("CustomerName: - " + commandLineArgs.get(2));
            parser.setFilename(fileName);
            dumper.setFileName(fileName);
            parser.setCustomerName(commandLineArgs.get(2));
            PhoneBill bill1 = parser.parse();
            //Add details from command line arguments to bill.calls
            PhoneCall call1 = new PhoneCall();
            call1.setCallerName(commandLineArgs.get(2));
            //call.setCalleeName("commandLineArgs.get(4)");
            call1.setCallerNumber(commandLineArgs.get(3));
            call1.setCalleeNumber(commandLineArgs.get(4));
            call1.setPhoneCallBeginDate(commandLineArgs.get(5));
            call1.setPhoneCallBeginTime(commandLineArgs.get(6));
            call1.setPhoneCallEndDate(commandLineArgs.get(7));
            call1.setPhoneCallEndTime(commandLineArgs.get(8));
            bill1.addPhoneCall(call1);
            dumper.dump(bill1);

            //Creating and adding phone call for the customer
//            PhoneCall call1 = new PhoneCall(commandLineArgs.get(2), commandLineArgs.get(2), commandLineArgs.get(3), commandLineArgs.get(4)
//                    , commandLineArgs.get(5), commandLineArgs.get(6), commandLineArgs.get(7));
//
//            PhoneBill bill1 = new PhoneBill(commandLineArgs.get(0));
            bill1.addPhoneCall(call1);
            if (print) {
                System.out.println(call1);
            }
        }

        int numberOfRequiredCommandLineArguments = 10;
        if (commandLineArgs.size() > numberOfRequiredCommandLineArguments ) {
            System.out.println("Correct number of values are not entered");
            return;
        }

        boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
        if (!allRequiredArgumentsAreValid) {
            return;
        }


    }

    /**
     * checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
     *
     * @param commandLineArgs denotes the entries at the command line
     * @return returns the command line input data if it is correct
     */
    static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs) {
        if (commandLineArgs.size() == 9) {
            String callerName = commandLineArgs.get(2);
            String noOfCaller = commandLineArgs.get(3);
            String noOfCallee = commandLineArgs.get(4);
            String dateOfPhoneCallBegin = commandLineArgs.get(5);
            String timeOfPhoneCallBegin = commandLineArgs.get(6);
            String dateOfPhoneCallEnd = commandLineArgs.get(7);
            String timeOfPhoneCallEnd = commandLineArgs.get(8);

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
            boolean isPhoneCallEndDateValid = checkForValidDate(commandLineArgs.get(7));
            if (!isPhoneCallEndDateValid) {
                return false;
            }
            boolean isPhoneCallEndTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(8));
            return isPhoneCallEndTimeValid;
        }
        else if (commandLineArgs.size() == 10) {
            if (commandLineArgs.get(2)!= "-print") {
                System.out.println("there is an extraneous argument on the command line.");
            }
            String callerName = commandLineArgs.get(4);
            String noOfCaller = commandLineArgs.get(5);
            String noOfCallee = commandLineArgs.get(6);
            String dateOfPhoneCallBegin = commandLineArgs.get(7);
            String timeOfPhoneCallBegin = commandLineArgs.get(8);
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
            boolean isPhoneCallEndDateValid = checkForValidDate(commandLineArgs.get(8));
            if (!isPhoneCallEndDateValid) {
                return false;
            }
            boolean isPhoneCallEndTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(9));
            return isPhoneCallEndTimeValid;
        }
        else {
            System.out.println("No args");
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
      String invalidDateOfPhoneCallMessage = "Date provided is invalid, please retry by entering the correct one's";
      System.out.println(invalidDateOfPhoneCallMessage);
      return false;
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

  //Object return method for compute() which will tell us abot the command line argument information.
}



