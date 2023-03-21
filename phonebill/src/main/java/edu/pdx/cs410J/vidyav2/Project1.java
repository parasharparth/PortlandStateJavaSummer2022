package edu.pdx.cs410J.vidyav2;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The main class for the CS410J Phone Bill Project
 * The objective of the first project is to learn about handling the command-line arguments
 * The command line arguments for this project are in the following order
 * argument 0 -- customer
 * argument 1 -- caller number
 * argument 2 -- callee number
 * argument 3 -- begin date (formatted in mm/dd/yyyy hh:mm)
 * argument 4 -- end date (formatted in mm/dd/yyyy hh:mm)
 * argument 5 -- print
 * argument 6 -- read me
 * Here, one phone-bill will have customer name and the details of the calls the person has attended
 * The Constructors were modified
 * Removed the testing part for including it in the testing classes
 */
public class Project1 {

  /**
   * @function (main) This is the main function from where the execution of the first project will start
   * @param args
   * Multiple conditional statements will check the validity of the command line arguments
   * The validity of command-line arguments is checked using Helper Functions
   */
  public static void main(String[] args) {

    /**
     *  if no arguments were passed in, display the message and return
      */

    if (args.length == 0) {
      System.out.println("No arguments passed at the command line");
      return;
    }

    /**
     *  check if the user has specified the 'README' flag in the command-line arguments
     */

    boolean readMeFlag = HelperFunctions.readMeFlagCheck(args);
    if(readMeFlag){
      /**
       *  If the user has specified the '-README' flag, display the contents of the README file and return
       */

      System.out.println(HelperFunctions.readFromReadMeFileOnly());
      return;
    }

    /**
     * Copy the command-line arguments into a new ArrayList for the easy manipulations
     */

    ArrayList<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));

    /**
     * Check if the user has specified the '-print' flag in the command-line arguments
      */

    boolean print = false;
    int countIdxValueForPrint = 0;
    for (String arg : args) {
      if (countIdxValueForPrint > 1) {
        break;
      }
      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 0)) {
        /**
         *  If the user has specified the '-print' flag, remove it from the ArrayList and set the 'print' variable to true
         */

        print = true;
        commandLineArgs.remove(countIdxValueForPrint);
        break;
      }
      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 1)) {
        /**
         * If the user has specified the '-print' flag twice or has entered them in the wrong order, display an error message and return
          */

        System.out.println("Entered values are in wrong order");
        return;
      }
      else {
        countIdxValueForPrint++;
      }
    }

    /**
     * Check if the correct number of required command-line arguments have been entered
     */

    int numberOfRequiredCommandLineArguments = 7;
    if(commandLineArgs.size() != numberOfRequiredCommandLineArguments){
      System.out.println("Correct number of values are not entered");
      return;
    }

    /**
     *    Check the validity of the required command-line arguments
     */

    boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
    if(!allRequiredArgumentsAreValid){
      return;
    }
    /**
     * Created a new PhoneCall object using the command-line arguments
      */

    PhoneCall call1 = new PhoneCall(commandLineArgs.get(0), commandLineArgs.get(1), commandLineArgs.get(2),
            commandLineArgs.get(3), commandLineArgs.get(4), commandLineArgs.get(5), commandLineArgs.get(6));
/**
 *  Created a new PhoneBill object with the customer name
  */

    PhoneBill bill1 = new PhoneBill(commandLineArgs.get(0));
    bill1.addPhoneCall(call1);

    if(print){
      System.out.println(call1);
    }
  }

  /** checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
   * @param commandLineArgs denotes the entries at the command line
   * @return returns the command line input data if it is correct
   * @function checkValidityOfRequiredArgs
   * Here the Helper Functions are called generically to check the command - line arguments to eliminate redundancy of code
   * CustomerName is never passed here because it is unnecessary to validate name
   * The following arguments are checked :
   * Valid Phone Number -- Argument 1 (The caller number)
   * Valid Phone Number -- Argument 2 (The callee number)
   * Valid Date -- Argument 3 (The date when the call began)
   * Valid Time -- Argument 4 (The time when the call began)
   * Valid Date -- Argument 5 (The date when the call ends)
   * Valid Time -- Argument 6 (The time when the call ends)
   */
  static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs) {

    if(!HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(1))){
      return false;
    }

    if(!HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(2))){
      return false;
    }

    if(!HelperFunctions.checkForValidDate(commandLineArgs.get(3))){
      return false;
    }

    if(!HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(4))){
      return false;
    }

    if(!HelperFunctions.checkForValidDate(commandLineArgs.get(5))){
      return false;
    }

    if(!HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(6))){
      return false;
    }
    return true;
  }
}



