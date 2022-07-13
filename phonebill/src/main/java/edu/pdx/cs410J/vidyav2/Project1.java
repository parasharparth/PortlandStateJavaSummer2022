package edu.pdx.cs410J.vidyav2;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1 {
  // @VisibleForTesting
// static boolean isValidPhoneNumber(String phoneNumber) {
// return true;
// }
  public static void main(String[] args) {
    int numberOfOriginalCommandLineArguments = args.length;
    if (numberOfOriginalCommandLineArguments == 0) {
      System.out.println("No arguments are given at the command line");
      return;
    }
    /**
     * The checkReadmeFlag(args) method checks whether there exists a -README flag in the array of
     command line arguments
     */
    boolean readmeFlag = checkReadmeFlag(args);
    if(readmeFlag){
      String readmeFileContent = readFromReadmeFile();
      System.out.println( "------------------------------------------------------\n" +
              readmeFileContent);
      return;
    }
    //copy over command line arguments to a new arraylist for flexibility
    ArrayList<String> commandLineArguments = new ArrayList<>();
    for (String arg : args) {
      commandLineArguments.add(arg);
    }
    // check if optional -print flag is given at the command line within the first two arguments
    boolean print = false;
    int countIndexForOptionalPrint = 0;
    for (String arg : args) {
      if (countIndexForOptionalPrint > 1) {
        break;
      }
      else if (arg.toLowerCase().contains("print") && (countIndexForOptionalPrint == 0)) {
        print = true;
        //remove print from arrayList for command line arguments
        commandLineArguments.remove(countIndexForOptionalPrint);
        break;
      }
      else if (arg.toLowerCase().contains("print") && (countIndexForOptionalPrint == 1)) {
        //if there is a non -README argument before -print
        System.out.println("***You entered the values in the wrong order, optional arguments must be placed at the beginning before the required arguments!\n\n");
        return;
      }
      else {
        countIndexForOptionalPrint++;
      }
    }
    //array after removing print if present in first two args
    //here are the required command line arguments
    //delete this after, no need to print this
// System.out.println(commandLineArguments);
    //this is after removing the optional arguments of course
    int numberOfRequiredCommandLineArguments = 7;
    if(commandLineArguments.size() != numberOfRequiredCommandLineArguments){
      System.out.println("You did not enter correct number of values");
      return;
    }
    //declaration of what each of the arguments are
    //No need to validate customer Name since ( 3 Customer names can contain any character including numbers.)
    String customerName = commandLineArguments.get(0);
    String numberOfCaller = commandLineArguments.get(1);
    String numberOfCallee = commandLineArguments.get(2);
    String dateOfPhoneCallStart = commandLineArguments.get(3);
    String timeOfPhoneCallStart = commandLineArguments.get(4);
    String dateOfPhoneCallEnd = commandLineArguments.get(5);
    String timeOfPhoneCallEnd = commandLineArguments.get(6);
    //Validation of all required arguments except customer, if any argument is invalid then tell the user and return from main
    boolean allRequiredArgumentsAreValid = checkValidityOfAllRequiredArguments(commandLineArguments);
    if(allRequiredArgumentsAreValid == false){
      return;
    }
    //create a phone call for the customer
    PhoneCall call1 = new PhoneCall(customerName, numberOfCaller, numberOfCallee, dateOfPhoneCallStart, timeOfPhoneCallStart, dateOfPhoneCallEnd, timeOfPhoneCallEnd);
    //add the phone call to phonebill, we do nothing with phonebill object for project1 though
    PhoneBill bill1 = new PhoneBill(customerName);
    bill1.addPhoneCall(call1);

    if(print){
      System.out.println( call1.toString());
    }
  }
  /**
   * This method checks the validity of all the command line arguments, except the optional flags
   * @param commandLineArguments the required arguments passed at the command line
   * @return A boolean value denoting whether or not all the values entered at the command line are
  valid
   */
  static boolean checkValidityOfAllRequiredArguments(ArrayList<String> commandLineArguments) {
    //CustomerName is never passed here because it is unnecessary to validate name
    String callerName = commandLineArguments.get(0);
    String numberOfCaller = commandLineArguments.get(1);
    String numberOfCallee = commandLineArguments.get(2);
    String dateOfPhoneCallStart = commandLineArguments.get(3);
    String timeOfPhoneCallStart = commandLineArguments.get(4);
    String dateOfPhoneCallEnd = commandLineArguments.get(5);
    String timeOfPhoneCallEnd = commandLineArguments.get(6);
    boolean isCallerNumberValid = checkValidityOfPhoneNumber(numberOfCaller);
    if(isCallerNumberValid == false){
      return false;
    }
    boolean isCalleeNumberValid = checkValidityOfPhoneNumber(numberOfCallee);
    if(isCalleeNumberValid == false){
      return false;
    }
    boolean isPhoneCallBeginDateValid = checkValidityOfDate(dateOfPhoneCallStart);
    if(isPhoneCallBeginDateValid == false){
      return false;
    }
    boolean isPhoneCallBeginTimeValid = checkValidityOfPhoneCallTime(timeOfPhoneCallStart);
    if(isPhoneCallBeginTimeValid==false){
      return false;
    }
    boolean isPhoneCallEndDateValid = checkValidityOfDate(dateOfPhoneCallEnd);
    if(isPhoneCallEndDateValid == false){
      return false;
    }
    boolean isPhoneCallEndTimeValid = checkValidityOfPhoneCallTime(timeOfPhoneCallEnd);
    if(isPhoneCallEndTimeValid==false){
      return false;
    }
    return true;
  }
  /**
   * The checkValidityOfPhoneCallTime method checks whether or not an entered string denoting time is
   a valid time
   *
   * @param timeOfPhoneCall time that the phone call started or ended
   * @return validity of the value entered at the command line - boolean
   */
  static boolean checkValidityOfPhoneCallTime(String timeOfPhoneCall) {
    String regexTime = "\\d{1,2}[:]\\d\\d";
    boolean validTimeOfPhoneCall = Pattern.compile(regexTime).matcher(timeOfPhoneCall).matches();

    if(validTimeOfPhoneCall == false){
      String invalidTimeOfPhoneCallMessage = "Sorry some of the arguments you provided are invalid!\n\n" +
              "For example, the time that you entered: " + timeOfPhoneCall + " is invalid!\n" +
              "All dates should be in the format: hh:mm and be numeric\n" +
              "Additionally, please remember that values at the command line should follow the order below:\n" +
      "customer callerNumber calleeNumber beginDate beginTime endDate endTime";
      System.out.println(invalidTimeOfPhoneCallMessage);
      return false;
    }
    return true;
  }
  /**
   * The checkValidityOfDate()c checks whether a date is valid or not
   *
   * @param dateOfPhoneCall the date of which the phone call either started or ended
   * @return if the string value is also a valid date
   */
  static boolean checkValidityOfDate(String dateOfPhoneCall) {
    String regexDate = "\\d{1,2}[/]\\d{1,2}[/]\\d\\d\\d\\d";
    boolean validDateOfPhoneCall = Pattern.compile(regexDate).matcher(dateOfPhoneCall).matches();
    if(validDateOfPhoneCall== false){
      String invalidDateOfPhoneCallMessage = "Sorry some of the arguments you provided are invalid!\n\n" +
              "For example, the date that you entered: " + dateOfPhoneCall + " is invalid!\n" +
              "All dates should be in the format: mm-dd-yyyy and be numeric\n" +
              "Additionally, please remember that values at the command line should follow the order below:\n" +
      "customer callerNumber calleeNumber beginDate beginTime endDate endTime";
      System.out.println(invalidDateOfPhoneCallMessage);
      return false;
    }
    return true;
  }
  /**
   * The checkValidityOfPhoneNumber method checks whether a String is also a valid phone number
   *
   * @param phoneNumber A phone number value entered at the command line
   * @return validity of the phone number entered
   */
  static boolean checkValidityOfPhoneNumber(String phoneNumber){
    String regexPhoneNumber = "\\d\\d\\d[-]\\d\\d\\d[-]\\d\\d\\d\\d";
    boolean validNumberOfCaller = Pattern.compile(regexPhoneNumber).matcher(phoneNumber).matches();
    if(validNumberOfCaller == false){
      String invalidPhoneNumberMessage = "Sorry some of the arguments you provided are invalid!\n\n" +
              "For example, the phone number that you entered: " + phoneNumber + " is invalid!\n" +
              "All phone numbers should be in the format: nnn-nnn-nnnn where n is a number 0-9\n" +
              "Additionally, please remember that values at the command line should follow the order below:\n" + "customer callerNumber calleeNumber beginDate beginTime endDate endTime\n";
      System.out.println(invalidPhoneNumberMessage);
      return false;
    }
    return true;
  }
  /**
   *
   * The checkReadMeFlag() is responsible for telling whether the optional -README flag has been
   given at the command line or not
   *
   * The optional -README flag is only valid is it is in a valid spot, which is the first two
   arguments
   *
   * @param args the original arguments passed at the command line are given to this function
   * @return a boolean value denoting whether or not the option -README flag was given at the command
  line
   */
  static boolean checkReadmeFlag(String[] args) {
    //check if optional -README flag is given at command line within the first two arguments
    int countIndexForOptionalREADME = 0;
    for (String arg : args) {
      if (countIndexForOptionalREADME > 1) {
        break;
      } else if (arg.toUpperCase().contains("README")) {
        //readFromReadmeFile();
        return true;
      } else {
        countIndexForOptionalREADME++;
      }
    }
    return false;
  }

  /**
   * The readFromFile() method is responsible for reading from the README.txt file
   *
   * @return a string of the file contents
   */
  static String readFromReadmeFile() {
    String line = "";
    try (
            InputStream readme = Project1.class.getResourceAsStream("README.txt")
    ) {


      BufferedReader reader = new BufferedReader(new InputStreamReader(readme));
      line = reader.readLine();
    } catch (IOException e) {
      System.out.println("The README.txt file was not able to be located. Sorry for the inconvenience.");
    }
    return line;
  }

}



