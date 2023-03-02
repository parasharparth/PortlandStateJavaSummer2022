package edu.pdx.cs410J.vidyav2;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1 {

  //The Constructors were modified
  //Removed the testing part
  public static void main(String[] args) {
    int totalCommandLineArgumentsConsidered = args.length;
    if (totalCommandLineArgumentsConsidered == 0) {
      System.out.println("No arguments passed at the command line");
      return;
    }

    //Change here for directly printing the readMeFile
    boolean readMeFlag = HelperFunctions.readMeFlagCheck(args);
    if(readMeFlag){
      System.out.println(HelperFunctions.readFromReadMeFileOnly());
      //System.out.println(FileContentReadMe);
      return;
    }

    //copying command line arguments to a new arraylist
    ArrayList<String> commandLineArgs = new ArrayList<>();
    for (String arg : args) {
      commandLineArgs.add(arg);
    }

    boolean print = false;
    int countIdxValueForPrint = 0;
    for (String arg : args) {
      if (countIdxValueForPrint > 1) {
        break;
      }
      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 0)) {
        print = true;

        commandLineArgs.remove(countIdxValueForPrint);
        break;
      }
      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 1)) {

        System.out.println("Entered values are in wrong order");
        return;
      }
      else {
        countIdxValueForPrint++;
      }
    }

    int numberOfRequiredCommandLineArguments = 7;
    if(commandLineArgs.size() != numberOfRequiredCommandLineArguments){
      System.out.println("Correct number of values are not entered");
      return;
    }

    //Our Command Line Arguments
    String custName = commandLineArgs.get(0);
    String noOfCaller = commandLineArgs.get(1);
    String noOfCallee = commandLineArgs.get(2);
    String dateOfPhoneCallBegin = commandLineArgs.get(3);
    String timeOfPhoneCallBegin = commandLineArgs.get(4);
    String dateOfPhoneCallEnd = commandLineArgs.get(5);
    String timeOfPhoneCallEnd = commandLineArgs.get(6);

    boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
    if(!allRequiredArgumentsAreValid){
      return;
    }
    //Creating and adding phone call for the customer
    PhoneCall call1 = new PhoneCall(custName, noOfCaller, noOfCallee, dateOfPhoneCallBegin, timeOfPhoneCallBegin, dateOfPhoneCallEnd, timeOfPhoneCallEnd);

    PhoneBill bill1 = new PhoneBill(custName);
    bill1.addPhoneCall(call1);

    if(print){
      System.out.println( call1.toString());
    }
  }

  /** checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
   *
   * @param commandLineArgs denotes the entries at the command line
   * @return returns the command line input data if it is correct
   */
  static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs) {
    //CustomerName is never passed here because it is unnecessary to validate name
    String callerName = commandLineArgs.get(0);
    String noOfCaller = commandLineArgs.get(1);
    String noOfCallee = commandLineArgs.get(2);
    String dateOfPhoneCallBegin = commandLineArgs.get(3);
    String timeOfPhoneCallBegin = commandLineArgs.get(4);
    String dateOfPhoneCallEnd = commandLineArgs.get(5);
    String timeOfPhoneCallEnd = commandLineArgs.get(6);
    boolean isCallerNumberValid = HelperFunctions.checkForValidPhoneNumber(noOfCaller);
    if(!isCallerNumberValid){
      return false;
    }
    boolean isCalleeNumberValid = HelperFunctions.checkForValidPhoneNumber(noOfCallee);
    if(!isCalleeNumberValid){
      return false;
    }
    boolean isPhoneCallBeginDateValid = HelperFunctions.checkForValidDate(dateOfPhoneCallBegin);
    if(!isPhoneCallBeginDateValid){
      return false;
    }
    boolean isPhoneCallBeginTimeValid = HelperFunctions.checkForValidPhoneCallTime(timeOfPhoneCallBegin);
    if(!isPhoneCallBeginTimeValid){
      return false;
    }
    boolean isPhoneCallEndDateValid = HelperFunctions.checkForValidDate(dateOfPhoneCallEnd);
    if(!isPhoneCallEndDateValid){
      return false;
    }
    boolean isPhoneCallEndTimeValid = HelperFunctions.checkForValidPhoneCallTime(timeOfPhoneCallEnd);
    if(!isPhoneCallEndTimeValid){
      return false;
    }
    return true;
  }


}



