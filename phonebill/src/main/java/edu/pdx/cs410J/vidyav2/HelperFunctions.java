package edu.pdx.cs410J.vidyav2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

//This class was created to get the helper functions in a single place to make the project file look clean
public class HelperFunctions {

	//Sourced from the Project1
	public static boolean readMeFlagCheck(String[] args){
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

	//Sourced from Project1
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

	/** checkForValidPhoneCallTime() method is used to describe the correctness of the Time specified for a
	 * Phone Call created
	 *
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


	/** checkForValidDate() checks the correctness of the entered Date
	 *
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

	/** checkForValidPhoneNumber() checks the correctness of the entered Phone Number in the
	 * correct format
	 *
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
