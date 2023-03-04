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
    int totalCommandLineArgumentsConsidered = args.length;  //vidya use this as it is as it provides cleaner code and loads faster.
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

    //Understand the logic behind this and then act.
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
    boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
    if(!allRequiredArgumentsAreValid){
      return;
    }
    //Creating and adding phone call for the customer
    PhoneCall call1 = new PhoneCall(commandLineArgs.get(0), commandLineArgs.get(1), commandLineArgs.get(2),
            commandLineArgs.get(3), commandLineArgs.get(4), commandLineArgs.get(5), commandLineArgs.get(6));

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



