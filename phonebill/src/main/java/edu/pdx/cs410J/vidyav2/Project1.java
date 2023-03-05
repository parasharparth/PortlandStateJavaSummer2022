package edu.pdx.cs410J.vidyav2;

import java.util.ArrayList;

/**
 * The main class for the CS410J Phone Bill Project
 * Add comment for the command-line-arguments
 * Vidya--> Use the in-built functions instead of using the variables (Modify that code)
 * Annie --> Add comments to the code
 */
public class Project1 {

  //The Constructors were modified
  //Removed the testing part
  public static void main(String[] args) {

    // Get the total number of command-line arguments passed in
    int totalCommandLineArgumentsConsidered = args.length;

    // if no arguments were passed in, display the message and return
    if (totalCommandLineArgumentsConsidered == 0) {
      System.out.println("No arguments passed at the command line");
      return;
    }

    // check if the user has specified the 'README' flag in the command-line arguments
    boolean readMeFlag = HelperFunctions.readMeFlagCheck(args);
    if(readMeFlag){
      // If the user has specified the '-README' flag, display the contents of the README file and return
      System.out.println(HelperFunctions.readFromReadMeFileOnly());
      return;
    }

    // Copy the command-line arguments into a new ArrayList for the easy manipulations
    ArrayList<String> commandLineArgs = new ArrayList<>();
    for (String arg : args) {
      commandLineArgs.add(arg);
    }

    // Check if the user has specified the '-print' flag in the command-line arguments
    boolean print = false;
    int countIdxValueForPrint = 0;
    for (String arg : args) {
      if (countIdxValueForPrint > 1) {
        break;
      }
      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 0)) {
        // If the user has specified the '-print' flag, remove it from the ArrayList and set the 'print' variable to true
        print = true;
        commandLineArgs.remove(countIdxValueForPrint);
        break;
      }
      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 1)) {
        // If the user has specified the '-print' flag twice or has entered them in the wrong order, display an error message and return
        System.out.println("Entered values are in wrong order");
        return;
      }
      else {
        countIdxValueForPrint++;
      }
    }

    // Check if the correct number of required command-line arguments have been entered
    int numberOfRequiredCommandLineArguments = 7;
    if(commandLineArgs.size() != numberOfRequiredCommandLineArguments){
      System.out.println("Correct number of values are not entered");
      return;
    }

    // Check the validity of the required command-line arguments
    boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
    if(!allRequiredArgumentsAreValid){
      return;
    }
    // Created a new PhoneCall object using the command-line arguments
    PhoneCall call1 = new PhoneCall(commandLineArgs.get(0), commandLineArgs.get(1), commandLineArgs.get(2),
            commandLineArgs.get(3), commandLineArgs.get(4), commandLineArgs.get(5), commandLineArgs.get(6));
// Created a new PhoneBill object with the customer name
    PhoneBill bill1 = new PhoneBill(commandLineArgs.get(0));
    bill1.addPhoneCall(call1);

    if(print){
      System.out.println(call1);
    }
  }

  /** checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
   *
   * @param commandLineArgs denotes the entries at the command line
   * @return returns the command line input data if it is correct
   * vidya make changes here to remove the command line arguments
   * Parth will modify the function to include proper method calling which can be used in later projects as well.
   */
  static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs) {
    //CustomerName is never passed here because it is unnecessary to validate name
    boolean isCallerNumberValid = HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(1));
    if(!isCallerNumberValid){
      return false;
    }
    boolean isCalleeNumberValid = HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(2));
    if(!isCalleeNumberValid){
      return false;
    }
    boolean isPhoneCallBeginDateValid = HelperFunctions.checkForValidDate(commandLineArgs.get(3));
    if(!isPhoneCallBeginDateValid){
      return false;
    }
    boolean isPhoneCallBeginTimeValid = HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(4));
    if(!isPhoneCallBeginTimeValid){
      return false;
    }
    boolean isPhoneCallEndDateValid = HelperFunctions.checkForValidDate(commandLineArgs.get(5));
    if(!isPhoneCallEndDateValid){
      return false;
    }
    boolean isPhoneCallEndTimeValid = HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(6));
    if(!isPhoneCallEndTimeValid){
      return false;
    }
    return true;
  }
}



