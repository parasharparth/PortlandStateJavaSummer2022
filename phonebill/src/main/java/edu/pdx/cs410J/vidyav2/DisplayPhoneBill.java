package edu.pdx.cs410J.vidyav2;

public class DisplayPhoneBill {

	public static void noArguments(){
		System.out.println("\nNo arguments passed at the command line.\n");
		printValues();
	}

	static void printValues() {
		System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args> args are (in this order):");
		System.out.println("customer --> Person whose phone bill we’re modeling");
		System.out.println("callerNumber --> Phone number of caller");
		System.out.println("calleeNumber --> Phone number of person who was called");
		System.out.println("begin --> Date and time (am/pm) call began");
		System.out.println("end --> Date and time (am/pm) call ended");
		System.out.println("Options are (options may appear in any order):");
		System.out.println("-pretty file --> Pretty print the phone bill to a text file or standard out (file -)");
		System.out.println("-textFile file --> Where to read/write the phone bill");
		System.out.println("-print --> Prints a description of the new phone call");
		System.out.println("-README --> Prints a README for this project and exits");
	}
}
