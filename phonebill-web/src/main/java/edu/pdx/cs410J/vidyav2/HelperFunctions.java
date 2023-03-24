package edu.pdx.cs410J.vidyav2;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class HelperFunctions {

	public static void checkHostAndPort(String hostName, String portName) {
		if (hostName == null) {
			System.err.println("Missing hostname!");
			System.exit(1);

		} else if ( portName == null) {
			System.err.println("Missing port number!");
			System.exit(1);
		}
		int portNum;
		try {
			portNum = Integer.parseInt( portName );
			System.out.println(portNum);
		} catch (NumberFormatException ex) {
			System.err.println("Port Number must be an integer!");
			System.exit(1);
		}
	}

	/**
	 * checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
	 *
	 * @param commandLineArgs denotes the entries at the command line
	 * @return returns the command line input data if it is correct
	 */
	public static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs)
	{
		if (commandLineArgs.size() == 12) {

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
		else if (commandLineArgs.size() == 14) {

			boolean isCallerNumberValid = checkForValidPhoneNumber(commandLineArgs.get(6));
			if (!isCallerNumberValid) {
				return false;
			}
			boolean isCalleeNumberValid = checkForValidPhoneNumber(commandLineArgs.get(7));
			if (!isCalleeNumberValid) {
				return false;
			}
			boolean isPhoneCallBeginDateValid = checkForValidDate(commandLineArgs.get(8));
			if (!isPhoneCallBeginDateValid) {
				return false;
			}
			boolean isPhoneCallBeginTimeValid = checkForValidPhoneCallTime(commandLineArgs.get(9));
			if (!isPhoneCallBeginTimeValid) {
				return false;
			}
			boolean isPhoneCallEndDateValid = checkForValidDate(commandLineArgs.get(11));
			if (!isPhoneCallEndDateValid) {
				return false;
			}
			return checkForValidPhoneCallTime(commandLineArgs.get(12));
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
	static boolean checkForValidPhoneCallTime (String timeOfPhoneCall){
		String regTime = "\\d{1,2}:\\d\\d";
		boolean validTimeOfPhoneCall = Pattern.compile(regTime).matcher(timeOfPhoneCall).matches();

		if (!validTimeOfPhoneCall) {
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
	static boolean checkForValidDate (String dateOfPhoneCall){
		String regDate = "\\d{1,2}/\\d{1,2}/\\d\\d\\d\\d";
		return Pattern.compile(regDate).matcher(dateOfPhoneCall).matches();
	}

	/** checkForValidPhoneNumber() checks the correctness of the entered Phone Number in the
	 * correct format
	 *
	 * @param phoneNumber describes the Phone Number of customer who is making efforts to make a Phone Call
	 * @return the Phone Number for the customer
	 */
	static boolean checkForValidPhoneNumber (String phoneNumber){
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
	 * This method prints out the README information for this project and exits
	 */
	public static void readMeInfo(){
		System.out.println("README for Project 4\nName: Group");
		System.out.println("Project 4 : A REST-ful Phone Bill Web Service");
		System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project4 [options] <args> args are (in this order):");
		System.out.println("customer --> Person whose phone bill we’re modeling");
		System.out.println("callerNumber --> Phone number of caller");
		System.out.println("calleeNumber --> Phone number of person who was called");
		System.out.println("begin --> Date and time (am/pm) call began");
		System.out.println("end --> Date and time (am/pm) call ended");
		System.out.println("\nOptions are (options may appear in any order):");
		System.out.println("-host hostname --> Host computer on which the server runs");
		System.out.println("-port port --> Port on which the server is listening");
		System.out.println("-search --> Phone calls should be searched for");
		System.out.println("-print --> Prints a description of the new phone call");
		System.out.println("-README --> Prints a README for this project and exits");
	}
}
