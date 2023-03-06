package edu.pdx.cs410J.vidyav2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 *This class was created to get the functions in a single place so that the code looks clean
 */

public class HelperFunctions {

	/**
	 * This function checks if the command line argument contains the string "README"
	 */

	public static boolean readMeFlagCheck(String[] args){
		int countIdxForREADME = 0;
		/**
		 * If we have already found "README" in the argument list, we stop searching
		 */
		for (String arg : args) {
			if (countIdxForREADME > 1) {
				break;
			}
			/**
			 * If the argument contains "README", we return true
			 */
			else if (arg.toUpperCase().contains("README")) {
				return true;
			}
			/**
			 * Otherwise, we increment our counter and keep searching
			 */
			else {
				countIdxForREADME++;
			}
		}
		/**
		 * If we didn't find "README" in the argument list, we return false
		 */
		return false;
	}

	/**
	 *This function reads the first line from a file named "README.txt"
	 */
	public static String readFromReadMeFileOnly(){
		String line = "";
		try (
				InputStream ReadMe = Project1.class.getResourceAsStream("README.txt")
		) {


			BufferedReader reader = new BufferedReader(new InputStreamReader(ReadMe));
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("The README.txt file was not able to be located.");
		}
		return line;
	}

	/**
	 *This function checks if the time string is in the correct format.
	 * @param timeOfPhoneCall parameter tells about the time of the Phone Call start/end
	 * @return the value of the Phone Call time validity
	 */

	static boolean checkForValidPhoneCallTime(String timeOfPhoneCall) {
		String regTime = "\\d{1,2}[:]\\d\\d";
		boolean validTimeOfPhoneCall = Pattern.compile(regTime).matcher(timeOfPhoneCall).matches();

		if(!validTimeOfPhoneCall){
			String invalidTimeOfPhoneCallMessage = "PhoneCall Argument provided is invalid, please retry by entering the correct one's";
			System.out.println(invalidTimeOfPhoneCallMessage);
			return false;
		}

		return true;
	}


	/**
	 * This function checks if the date is in the correct format
	 * @param dateOfPhoneCall describes the date of Phone Call start/end
	 * @return the start or end Date of Phone Call
	 */
	static boolean checkForValidDate(String dateOfPhoneCall) {
		String regDate = "\\d{1,2}[/]\\d{1,2}[/]\\d\\d\\d\\d";
		boolean validDateOfPhoneCall = Pattern.compile(regDate).matcher(dateOfPhoneCall).matches();
		if(!validDateOfPhoneCall){
			String invalidDateOfPhoneCallMessage = "Date provided is invalid, please retry by entering the correct one's";
			System.out.println(invalidDateOfPhoneCallMessage);
			return false;
		}
		return true;
	}

	/**
	 *This function checks if it's the correct phone number
	 * @param phoneNumber describes the Phone Number of customer who is making efforts to make a Phone Call
	 * @return the Phone Number for the customer
	 */
	static boolean checkForValidPhoneNumber(String phoneNumber){
		String regPhoneNumber = "\\d\\d\\d[-]\\d\\d\\d[-]\\d\\d\\d\\d";
		boolean validNumberOfCaller = Pattern.compile(regPhoneNumber).matcher(phoneNumber).matches();
		if(!validNumberOfCaller){
			String invalidPhoneNumberMessage = "Phone Number provided is invalid, please retry by entering the correct one's";
			System.out.println(invalidPhoneNumberMessage);
			return false;
		}
		return true;
	}
}
