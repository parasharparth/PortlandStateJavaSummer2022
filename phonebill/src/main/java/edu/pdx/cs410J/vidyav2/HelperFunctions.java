package edu.pdx.cs410J.vidyav2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
}
