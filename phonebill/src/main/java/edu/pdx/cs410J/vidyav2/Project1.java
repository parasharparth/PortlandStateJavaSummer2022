//package edu.pdx.cs410J.vidyav2;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.regex.Pattern;
//
///**
// * The main class for the CS410J Phone Bill Project
// */
//public class Project1 {
//  // @VisibleForTesting
//// static boolean isValidPhoneNumber(String phoneNumber) {
//// return true;
//// }
//  public static void main(String[] args) {
//    int totalCommandLineArgumentsConsidered = args.length;
//    if (totalCommandLineArgumentsConsidered == 0) {
//      System.out.println("No arguments passed at the command line");
//      return;
//    }
//
//    boolean readMeFlag = readMeFlagCheck(args);
//    if(readMeFlag ){
//      String FileContentReadMe = readFromReadMeFileOnly();
//      System.out.println(FileContentReadMe);
//      return;
//    }
//    //copying command line arguments to a new arraylist
//    ArrayList<String> commandLineArgs = new ArrayList<>();
//    for (String arg : args) {
//      commandLineArgs.add(arg);
//    }
//
//    boolean print = false;
//    int countIdxValueForPrint = 0;
//    for (String arg : args) {
//      if (countIdxValueForPrint > 1) {
//        break;
//      }
//      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 0)) {
//        print = true;
//
//        commandLineArgs.remove(countIdxValueForPrint);
//        break;
//      }
//      else if (arg.toLowerCase().contains("print") && (countIdxValueForPrint == 1)) {
//
//        System.out.println("Entered values are in wrong order");
//        return;
//      }
//      else {
//        countIdxValueForPrint++;
//      }
//    }
//
//    int numberOfRequiredCommandLineArguments = 7;
//    if(commandLineArgs.size() != numberOfRequiredCommandLineArguments){
//      System.out.println("Correct number of values are not entered");
//      return;
//    }
//
//    //Our Command Line Arguments
//    String custName = commandLineArgs.get(0);
//    String noOfCaller = commandLineArgs.get(1);
//    String noOfCallee = commandLineArgs.get(2);
//    String dateOfPhoneCallBegin = commandLineArgs.get(3);
//    String timeOfPhoneCallBegin = commandLineArgs.get(4);
//    String dateOfPhoneCallEnd = commandLineArgs.get(5);
//    String timeOfPhoneCallEnd = commandLineArgs.get(6);
//
//    boolean allRequiredArgumentsAreValid = checkValidityOfRequiredArgs(commandLineArgs);
//    if(!allRequiredArgumentsAreValid){
//      return;
//    }
//    //Creating and adding phone call for the customer
//    PhoneCall call1 = new PhoneCall(custName, noOfCaller, noOfCallee, dateOfPhoneCallBegin, timeOfPhoneCallBegin, dateOfPhoneCallEnd, timeOfPhoneCallEnd);
//
//    PhoneBill bill1 = new PhoneBill(custName);
//    bill1.addPhoneCall(call1);
//
//    if(print){
//      System.out.println( call1.toString());
//    }
//  }
//
//  /** checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
//   *
//   * @param commandLineArgs denotes the entries at the command line
//   * @return returns the command line input data if it is correct
//   */
//  static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs) {
//    //CustomerName is never passed here because it is unnecessary to validate name
//    String callerName = commandLineArgs.get(0);
//    String noOfCaller = commandLineArgs.get(1);
//    String noOfCallee = commandLineArgs.get(2);
//    String dateOfPhoneCallBegin = commandLineArgs.get(3);
//    String timeOfPhoneCallBegin = commandLineArgs.get(4);
//    String dateOfPhoneCallEnd = commandLineArgs.get(5);
//    String timeOfPhoneCallEnd = commandLineArgs.get(6);
//    boolean isCallerNumberValid = checkForValidPhoneNumber(noOfCaller);
//    if(!isCallerNumberValid){
//      return false;
//    }
//    boolean isCalleeNumberValid = checkForValidPhoneNumber(noOfCallee);
//    if(!isCalleeNumberValid){
//      return false;
//    }
//    boolean isPhoneCallBeginDateValid = checkForValidDate(dateOfPhoneCallBegin);
//    if(!isPhoneCallBeginDateValid){
//      return false;
//    }
//    boolean isPhoneCallBeginTimeValid = checkForValidPhoneCallTime(timeOfPhoneCallBegin);
//    if(!isPhoneCallBeginTimeValid){
//      return false;
//    }
//    boolean isPhoneCallEndDateValid = checkForValidDate(dateOfPhoneCallEnd);
//    if(!isPhoneCallEndDateValid){
//      return false;
//    }
//    boolean isPhoneCallEndTimeValid = checkForValidPhoneCallTime(timeOfPhoneCallEnd);
//    if(!isPhoneCallEndTimeValid){
//      return false;
//    }
//    return true;
//  }
//
//  /** checkForValidPhoneCallTime() method is used to describe the correctness of the Time specified for a
//   * Phone Call created
//   *
//   * @param timeOfPhoneCall parameter tells about the time of the Phone Call start/end
//   * @return the value of the Phone Call time validity
//   */
//  static boolean checkForValidPhoneCallTime(String timeOfPhoneCall) {
//    String regTime = "\\d{1,2}[:]\\d\\d";
//    boolean validTimeOfPhoneCall = Pattern.compile(regTime).matcher(timeOfPhoneCall).matches();
//
//    if(!validTimeOfPhoneCall){
//      String invalidTimeOfPhoneCallMessage = "PhoneCall Argument provided is invalid, please retry by entering the correct one's";
//      System.out.println(invalidTimeOfPhoneCallMessage);
//      return false;
//    }
//    return true;
//  }
//
//
//  /** checkForValidDate() checks the correctness of the entered Date
//   *
//   * @param dateOfPhoneCall describes the date of Phone Call start/end
//   * @return the start or end Date of Phone Call
//   */
//  static boolean checkForValidDate(String dateOfPhoneCall) {
//    String regDate = "\\d{1,2}[/]\\d{1,2}[/]\\d\\d\\d\\d";
//    boolean validDateOfPhoneCall = Pattern.compile(regDate).matcher(dateOfPhoneCall).matches();
//    if(!validDateOfPhoneCall){
//      String invalidDateOfPhoneCallMessage = "Date provided is invalid, please retry by entering the correct one's";
//      System.out.println(invalidDateOfPhoneCallMessage);
//      return false;
//    }
//    return true;
//  }
//
//  /** checkForValidPhoneNumber() checks the correctness of the entered Phone Number in the
//   * correct format
//   *
//   * @param phoneNumber describes the Phone Number of customer who is making efforts to make a Phone Call
//   * @return the Phone Number for the customer
//   */
//  static boolean checkForValidPhoneNumber(String phoneNumber){
//    String regPhoneNumber = "\\d\\d\\d[-]\\d\\d\\d[-]\\d\\d\\d\\d";
//    boolean validNumberOfCaller = Pattern.compile(regPhoneNumber).matcher(phoneNumber).matches();
//    if(!validNumberOfCaller){
//      String invalidPhoneNumberMessage = "Phone Number provided is invalid, please retry by entering the correct one's";
//      System.out.println(invalidPhoneNumberMessage);
//      return false;
//    }
//    return true;
//  }
//
//
//  /**
//   *The readMeFlagCheck() tells whether optional -README flag has been entered at Command Line
//   */
//  static boolean readMeFlagCheck(String[] args) {
//    int countIdxForREADME = 0;
//    for (String arg : args) {
//      if (countIdxForREADME > 1) {
//        break;
//      } else if (arg.toUpperCase().contains("README")) {
//        return true;
//      } else {
//        countIdxForREADME++;
//      }
//    }
//    return false;
//  }
//
//
//  /**
//   * The readFromReadMeFileOnly() method is responsible for reading from the README.txt file
//   *
//   * @return a string of the file contents given
//   */
//  static String readFromReadMeFileOnly() {
//    String line = "";
//    try (
//            InputStream ReadMe = Project1.class.getResourceAsStream("README.txt")
//    ) {
//
//
//      BufferedReader reader = new BufferedReader(new InputStreamReader(ReadMe));
//      line = reader.readLine();
//    } catch (IOException e) {
//      System.out.println("The README.txt file was not able to be located.");
//    }
//    return line;
//  }
//
//}
//
//
//
