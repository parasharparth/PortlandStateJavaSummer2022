package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;

import java.io.IOException;
import java.util.ArrayList;

public class BaseConditions {

	public static boolean baseCondition5(ArrayList<String> commandLineArgs){
		return (commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port"));
	}

	public static void baseCondition5Print(String fileName,ArrayList<String> commandLineArgs) throws ParserException, IOException {
		TextDumper dumper = new TextDumper();
		TextParser parser = new TextParser(fileName, commandLineArgs.get(commandLineArgs.indexOf("-host") + 2));
		HelperFunctions.dumpIntoFile(fileName,dumper,parser,commandLineArgs);
		PhoneBill bill = parser.parse();
		PhoneCall call = new PhoneCall();
		bill.addPhoneCall();
		dumper.dump(bill);
		PrettyPrinter printer = new PrettyPrinter();
		HelperFunctions.prettyPrintFile(bill,call,commandLineArgs,printer);
	}


	public static boolean baseCondition12(ArrayList<String> commandLineArgs){
		return (commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port") ||
				(commandLineArgs.get(4).equals("-search") || (commandLineArgs.get(0).equals("-search") ||
						commandLineArgs.get(3).contains("-port") || (commandLineArgs.get(1).contains("-host")))));
	}

	public static void baseCondition12Print(PhoneBillRestClient client, ArrayList<String> commandLineArgs){
		System.out.println(client);
		String customerName = "";
		PhoneBill bill = new PhoneBill(commandLineArgs.get(5));
		System.out.println(customerName + bill);
		PhoneCall call = new PhoneCall();
		call.setCallerName(commandLineArgs.get(5));
		call.setCallerNumber("111-222-3333");
		call.setCalleeNumber("111-222-3333");
		call.setPhoneCallBeginDate(commandLineArgs.get(6));
		call.setPhoneCallBeginTime(commandLineArgs.get(6), commandLineArgs.get(7), commandLineArgs.get(8));
		call.setPhoneCallEndDate(commandLineArgs.get(9));
		call.setPhoneCallEndTime(commandLineArgs.get(9), commandLineArgs.get(10), commandLineArgs.get(11));
	}

	public static boolean baseCondition13(ArrayList<String> commandLineArgs){
		return (commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port") );
	}

	public static PhoneCall baseCondition13Print(ArrayList<String> commandLineArgs){
		PhoneBill bill = new PhoneBill(commandLineArgs.get(4));
		System.out.println(bill);
		PhoneCall call = new PhoneCall();
		call.setCallerName(commandLineArgs.get(4));
		call.setCallerNumber(commandLineArgs.get(5));
		call.setCalleeNumber(commandLineArgs.get(6));
		call.setPhoneCallBeginDate(commandLineArgs.get(7));
		call.setPhoneCallBeginTime(commandLineArgs.get(7), commandLineArgs.get(8), commandLineArgs.get(9));
		call.setPhoneCallEndDate(commandLineArgs.get(10));
		call.setPhoneCallEndTime(commandLineArgs.get(10), commandLineArgs.get(11), commandLineArgs.get(12));
		return call;
	}

	public static boolean baseCondition14(ArrayList<String> commandLineArgs){
		return (commandLineArgs.get(0).contains("-host") || commandLineArgs.get(2).contains("-port") ||
				commandLineArgs.get(4).contains("-print") );
	}

	public static PhoneCall baseCondition14Print(ArrayList<String> commandLineArgs) {
		PhoneBill bill = new PhoneBill(commandLineArgs.get(5));
		System.out.println(bill);
		PhoneCall call = new PhoneCall();
		call.setCallerName(commandLineArgs.get(5));
		call.setCallerNumber(commandLineArgs.get(6));
		call.setCalleeNumber(commandLineArgs.get(7));
		call.setPhoneCallBeginDate(commandLineArgs.get(8));
		call.setPhoneCallBeginTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
		call.setPhoneCallEndDate(commandLineArgs.get(11));
		call.setPhoneCallEndTime(commandLineArgs.get(11), commandLineArgs.get(12), commandLineArgs.get(13));
		return call;
	}

	public static void baseCondition14Check(ArrayList<String> commandLineArgs, String[] args) {
		for (String arg : args) {
			if (arg.equals("-print")) {
				System.out.println("This is the Printed text:");
				System.out.println("CallerNumber : " + commandLineArgs.get(6));
				System.out.println("CalleeNumber : " + commandLineArgs.get(7));
				System.out.println("Date of Begin : " + commandLineArgs.get(8));
				System.out.println("Time of Begin : " + commandLineArgs.get(9) + " " + commandLineArgs.get(10));
				System.out.println("Date of End : " + commandLineArgs.get(11));
				System.out.println("Time of End : " + commandLineArgs.get(12) + " " + commandLineArgs.get(13));
			}
		}
	}
}
