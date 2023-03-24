package edu.pdx.cs410J.vidyav2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/*******************************************************************************************
 *This class was created to get the functions in a single place so that the code looks clean
 *******************************************************************************************/

public class HelperFunctions {

	/*****************************************************************************************************************
	 * readMeFlagCheck() function checks if the command line argument contains the string "README"
	 * If we have already found "README" in the argument list, we stop searching
	 * If the argument contains "README", we return true
	 * Otherwise, we increment our counter and keep searching
	 * If we didn't find "README" in the argument list, we return false
	 * readFromReadMeFileOnly() function reads the first line from a file named "README.txt"
	 * checkForValidPhoneCallTime() function checks if the time string is in the correct format.
	 * timeOfPhoneCall parameter tells about the time of the Phone Call start/end and return value of the Phone Call time validity
	 * checkForValidDate() function checks if the date is in the correct format
	 * dateOfPhoneCall parameter describes the date of Phone Call start/end and return the start or end Date of Phone Call
	 * checkForValidPhoneNumber() function checks if it's the correct phone number
	 * phoneNumber parameter describes the Phone Number of customer who is making efforts to make a Phone Call and return the Phone Number for the customer
	 * checkValidityOfRequiredArgs() method is used validate the Required arguments in the program
	 * commandLineArgs denotes the entries at the command line and return the command line input data if it is correct
	 *****************************************************************************************************************/


	public static boolean readMeFlagCheck(String[] args){
		int countIdxForREADME = 0;

		for (String arg : args) {
			if (countIdxForREADME > 1) {
				break;
			}

			else if (arg.toUpperCase().contains("README")) {
				return true;
			}

			else {
				countIdxForREADME++;
			}
		}

		return false;
	}


	public static String readFromReadMeFileOnly(){
		String line = "";
		try (
				InputStream ReadMe = Project1.class.getResourceAsStream("README.txt")
		) {


			assert ReadMe != null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(ReadMe));
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("The README.txt file was not able to be located.");
		}
		return line;
	}



	static boolean checkForValidPhoneCallTime(String timeOfPhoneCall) {
		String regTime = "\\d{1,2} : \\d\\d";
		boolean validTimeOfPhoneCall = Pattern.compile(regTime).matcher(timeOfPhoneCall).matches();

		if(!validTimeOfPhoneCall){
			String invalidTimeOfPhoneCallMessage = "PhoneCall Argument provided is invalid, please retry by entering the correct one's";
			System.out.println(invalidTimeOfPhoneCallMessage);
			return false;
		}

		return true;
	}



	static boolean checkForValidDate(String dateOfPhoneCall) {
		String regDate = "\\d{1,2}/\\d{1,2}/\\d\\d\\d\\d";
		boolean validDateOfPhoneCall = Pattern.compile(regDate).matcher(dateOfPhoneCall).matches();
		if(!validDateOfPhoneCall){
			String invalidDateOfPhoneCallMessage = "Date provided is invalid, please retry by entering the correct one's";
			System.out.println(invalidDateOfPhoneCallMessage);
			return true;
		}
		return false;
	}


	static boolean checkForValidPhoneNumber(String phoneNumber){
		String regPhoneNumber = "\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d";
		boolean validNumberOfCaller = Pattern.compile(regPhoneNumber).matcher(phoneNumber).matches();
		if(!validNumberOfCaller){
			String invalidPhoneNumberMessage = "Phone Number provided is invalid, please retry by entering the correct one's";
			System.out.println(invalidPhoneNumberMessage);
			return false;
		}
		return true;
	}


	static boolean checkValidityOfRequiredArgs(ArrayList<String> commandLineArgs) {
		switch (commandLineArgs.size()) {
			case 0:  System.err.println("No args. Go check back.");
					 return false;
			case 7:  if (!HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(1)) ||
						 !HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(2)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(3)) ||
						 !HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(4)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(5)) ||
						 !HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(6))) return false;
					 break;
			case 11: if (!HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(3)) ||
						 !HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(4)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(5)) ||
						 !HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(6)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(8)) ||
						 !HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(9))) return false;
					 break;
			case 12: if (!HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(4)) ||
						 !HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(5)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(6)) ||
						 !HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(7)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(9)) ||
						 !HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(10))) return false;
					 break;
			case 13: if (!HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(5)) ||
						 !HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(6)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(7)) ||
						 !HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(8)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(10)) ||
						 !HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(11))) return false;
				     break;
		}
		return true;
	}

	/**
	 * The readFromReadMeFileOnly() method is responsible for reading from the README.txt file
	 *
	 * @return a string of the file contents given
	 */
	static String readFromReadMeFileOnlyProject3() {
		String line = "";
		try (
				InputStream ReadMe = Project3.class.getResourceAsStream("README.txt")
		) {
			assert ReadMe != null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(ReadMe));
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("The README.txt file was not able to be located.");
		}
		return line;
	}

	 static void printGenericMessage() {
		System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project3 [options] <args> args are (in this order):" +
				"customer --> Person whose phone bill we’re modeling" +
				"callerNumber --> Phone number of caller" +
				"calleeNumber --> Phone number of person who was called" +
				"begin --> Date and time (am/pm) call began" +
				"end --> Date and time (am/pm) call ended" +
				"Options are (options may appear in any order):" +
				"-pretty file --> Pretty print the phone bill to a text file or standard out (file -)" +
				"-textFile file --> Where to read/write the phone bill" +
				"-print --> Prints a description of the new phone call" +
				"-README --> Prints a README for this project and exits");
	}

	public static void printThisUsageMessage()
	{
		System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project-2 [options] <args> args are (in this order):");
		DisplayPhoneBill.printValues();
		System.exit(1);
	}
}
