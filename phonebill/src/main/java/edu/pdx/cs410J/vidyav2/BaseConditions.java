package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;

import java.io.IOException;
import java.util.ArrayList;

public class BaseConditions {

	//This is the condition when both textFile and Pretty Printer file are present
	public static boolean baseCondition13(ArrayList<String> commandLineArgs){

		return (commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
				(commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).contains("-")) ||
				(commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains(".txt") &&
						commandLineArgs.get(2).equals("-pretty") && commandLineArgs.get(3).equals(".txt")));
	}

	public static void baseCondition13PrettyFileDump(ArrayList<String> commandLineArgs) throws ParserException, IOException {
		String fileName = commandLineArgs.get(1);
		TextDumper dumper = new TextDumper();
		TextParser parser = new TextParser(fileName, commandLineArgs.get(2));
		parser.setFilename(fileName);
		dumper.setFileName(fileName);
		PhoneBill bill = parser.parse();
		PhoneCall call = new PhoneCall();
		parser.setCustomerName(commandLineArgs.get(4));
		settingCallDetailsForParsing(commandLineArgs, call);
		addingPhoneBillAfterParsing(commandLineArgs, dumper, bill, call);
	}

	public static void settingCallDetailsForParsing(ArrayList<String> commandLineArgs, PhoneCall call) {
		call.setCallerName(commandLineArgs.get(4));
		call.setCallerNumber(commandLineArgs.get(5));
		call.setCalleeNumber(commandLineArgs.get(6));
		call.setPhoneCallBeginDate(commandLineArgs.get(7));
		call.setPhoneCallBeginTime(commandLineArgs.get(7), commandLineArgs.get(8), commandLineArgs.get(9));
		call.setPhoneCallEndDate(commandLineArgs.get(10));
		call.setPhoneCallEndTime(commandLineArgs.get(10), commandLineArgs.get(11), commandLineArgs.get(12));
	}

	public static void addingPhoneBillAfterParsing(ArrayList<String> commandLineArgs, TextDumper dumper, PhoneBill bill, PhoneCall call) throws IOException {
		bill.addPhoneCall(call);
		dumper.dump(bill);

		PrettyPrinter printer = new PrettyPrinter();
		printer.setFilename(commandLineArgs.get(3));
		printer.setCustomerName(commandLineArgs.get(4));
		printer.getPretty(call, commandLineArgs.get(5));
		printer.dump(bill);
	}

	public static void baseCondition13FileDump(ArrayList<String> commandLineArgs) throws ParserException, IOException {
		String fileName = commandLineArgs.get(1);
		TextDumper dumper = new TextDumper();
		TextParser parser = new TextParser(fileName, commandLineArgs.get(4));
		parser.setFilename(fileName);
		dumper.setFileName(fileName);
		parser.setCustomerName(commandLineArgs.get(4));
		PhoneBill bill = parser.parse();
		PhoneCall call = new PhoneCall();
		settingCallDetailsForParsing(commandLineArgs, call);
		boolean allRequiredArgumentsAreValid = HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs);
		if (!allRequiredArgumentsAreValid) {return;}
		addingPhoneBillAfterParsing(commandLineArgs, dumper, bill, call);
	}

	static void baseCondition12(ArrayList<String> commandLineArgs) throws ParserException, IOException {
		if ((commandLineArgs.get(0).contains("-textFile") && commandLineArgs.get(1).contains("-pretty") ||
				(commandLineArgs.get(0).equals("-pretty") && commandLineArgs.get(1).equals("-textFile") &&
						commandLineArgs.get(2).contains(".txt")) || commandLineArgs.get(0).contains("-print") &&
				commandLineArgs.get(1).equals("-pretty") && commandLineArgs.get(2).contains(".txt"))) {

			String fileName = commandLineArgs.get(2);
			TextDumper dumper = new TextDumper();
			TextParser parser = new TextParser(fileName, commandLineArgs.get(commandLineArgs.indexOf("-pretty")));
			parser.setFilename(fileName);
			dumper.setFileName(fileName);
			parser.setCustomerName(commandLineArgs.get(3));
			PhoneBill bill = parser.parse();
			PhoneCall call = new PhoneCall();
			call.setCallerName(commandLineArgs.get(3));
			call.setCallerNumber(commandLineArgs.get(4));
			call.setCalleeNumber(commandLineArgs.get(5));
			call.setPhoneCallBeginDate(commandLineArgs.get(6));
			call.setPhoneCallBeginTime(commandLineArgs.get(6), commandLineArgs.get(7), commandLineArgs.get(8));
			call.setPhoneCallEndDate(commandLineArgs.get(9));
			call.setPhoneCallEndTime(commandLineArgs.get(9), commandLineArgs.get(10), commandLineArgs.get(11));
			boolean allRequiredArgumentsAreValid = HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs);
			if (!allRequiredArgumentsAreValid) {
				return;
			}
			bill.addPhoneCall(call);
			dumper.dump(bill);
			PrettyPrinter printer = new PrettyPrinter();
			printer.setFilename(commandLineArgs.get(2));
			printer.setCustomerName(commandLineArgs.get(3));
			printer.getPretty(call, commandLineArgs.get(4));
			printer.dump(bill);
		}
		else if ((commandLineArgs.get(0).contains("-pretty") && commandLineArgs.get(1).contains(".txt"))) {
			String fileName = commandLineArgs.get(1);
			TextDumper dumper = new TextDumper();
			TextParser parser = new TextParser(fileName, commandLineArgs.get(2));
			parser.setFilename(fileName);
			dumper.setFileName(fileName);
			parser.setCustomerName(commandLineArgs.get(2));
			PhoneBill bill = parser.parse();
			PhoneCall call = new PhoneCall();
			baseCondition12Dump(commandLineArgs, dumper, bill, call);
			PrettyPrinter printer = new PrettyPrinter();
			printer.setFilename(commandLineArgs.get(1));
			printer.setCustomerName(commandLineArgs.get(2));
			printer.getPretty(call, commandLineArgs.get(2));
			printer.dump(bill);
		}
	}

	public static void baseCondition12Dump(ArrayList<String> commandLineArgs, TextDumper dumper, PhoneBill bill, PhoneCall call) throws IOException {
		setCaller(commandLineArgs, dumper, bill, call);
	}

	public static void setCaller(ArrayList<String> commandLineArgs, TextDumper dumper, PhoneBill bill, PhoneCall call) throws IOException {
		setName(commandLineArgs, bill, call);
		dumper.dump(bill);
	}

	public static void setName(ArrayList<String> commandLineArgs, PhoneBill bill, PhoneCall call) {
		Caller(commandLineArgs, call);
		boolean allRequiredArgumentsAreValid = false;
		if (!allRequiredArgumentsAreValid) {
			HelperFunctions.printThisUsageMessage();
		}
		bill.addPhoneCall(call);
	}

	public static void Caller(ArrayList<String> commandLineArgs, PhoneCall call) {
		call.setCallerName(commandLineArgs.get(2));
		call.setCallerNumber(commandLineArgs.get(3));
		call.setCalleeNumber(commandLineArgs.get(4));
		call.setPhoneCallBeginDate(commandLineArgs.get(5));
		call.setPhoneCallBeginTime(commandLineArgs.get(5), commandLineArgs.get(6), commandLineArgs.get(7));
		call.setPhoneCallEndDate(commandLineArgs.get(8));
		call.setPhoneCallEndTime(commandLineArgs.get(8), commandLineArgs.get(9), commandLineArgs.get(10));
		HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs);
	}
}
