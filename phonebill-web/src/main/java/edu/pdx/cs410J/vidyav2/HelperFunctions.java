package edu.pdx.cs410J.vidyav2;

import java.io.IOException;
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
		switch (commandLineArgs.size()) {
			case 0:  System.err.println("No args. Go check back.");
				return true;
			case 7:  if (HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(1)) ||
					HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(2)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(3)) ||
					HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(4)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(5)) ||
					HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(6))) return true;
				break;
			case 11: if (HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(3)) ||
					HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(4)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(5)) ||
					HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(6)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(8)) ||
					HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(9))) return true;
				break;
			case 12: if (HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(4)) ||
					HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(5)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(6)) ||
					HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(7)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(9)) ||
					HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(10))) return true;
				break;
			case 13: if (HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(5)) ||
					HelperFunctions.checkForValidPhoneNumber(commandLineArgs.get(6)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(7)) ||
					HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(8)) ||
					HelperFunctions.checkForValidDate(commandLineArgs.get(10)) ||
					HelperFunctions.checkForValidPhoneCallTime(commandLineArgs.get(11))) return true;
				break;
		}
		return false;
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
			return true;
		}
		return false;
	}


	/** checkForValidDate() checks the correctness of the entered Date
	 *
	 * @param dateOfPhoneCall describes the date of Phone Call start/end
	 * @return the start or end Date of Phone Call
	 */
	static boolean checkForValidDate (String dateOfPhoneCall){
		String regDate = "\\d{1,2}/\\d{1,2}/\\d\\d\\d\\d";
		return !Pattern.compile(regDate).matcher(dateOfPhoneCall).matches();
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
			return true;
		}
		return false;
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

	 static void dumpIntoFile(String fileName,TextDumper dumper, TextParser parser, ArrayList<String> commandLineArgs) {
		System.out.println("CustomerName: - " + commandLineArgs.get(4));
		parser.setFilename(fileName);
		dumper.setFileName(fileName);
		parser.setCustomerName(commandLineArgs.get(4));
	}

	 static void prettyPrintFile(PhoneBill bill, PhoneCall call, ArrayList<String> commandLineArgs,PrettyPrinter printer) throws IOException {
		System.out.println("This is the pretty text:");
		System.out.println("CallerNumber : " + call.getCallerNumber());
		System.out.println("CalleeNumber : " + call.getCalleeNumber());
		System.out.println("Date of Begin : " + call.getPhoneCallBeginDate());
		System.out.println("Time of Begin : " + call.getPhoneCallBeginTime());
		System.out.println("Date of End : " + call.getPhoneCallEndDate());
		System.out.println("Time of End : " + call.getPhoneCallEndTime());
		printer.setFilename("Project4_PrettyFile");
		printer.setCustomerName(commandLineArgs.get(4));
		printer.getpretty(call, commandLineArgs.get(4));

		printer.dump(bill);
	}

	public static PhoneBillRestClient hostCalling(String[] args) {
		String hostName = "";
		String portName = "";
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-host")) {
				hostName = args[i + 1];
			}
			if (args[i].equals("-port")) {
				portName = args[i + 1];
			}
		}
		HelperFunctions.checkHostAndPort(hostName, portName);
		int portNum = Integer.parseInt(portName);
		return new PhoneBillRestClient(hostName, portNum);
	}
}
