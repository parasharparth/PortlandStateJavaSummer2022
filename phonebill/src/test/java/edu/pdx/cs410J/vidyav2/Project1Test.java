package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can capture data
 * written to {@link System#out} and the like.
 */
class Project1Test extends InvokeMainTestCase {

  private MainMethodResult invokeMain(String... args) {
    return invokeMain(Project2.class, args);
  }

  @Test
  void readmeCanBeReadAsResource() throws IOException {
    try (
      InputStream readme = Project2.class.getResourceAsStream("README.txt")
    ) {
      assertThat(readme, not(nullValue()));
      BufferedReader reader = new BufferedReader(new InputStreamReader(readme));
      String line = reader.readLine();
      assertThat(line, containsString("Java"));
    }
  }

  @Test
  void readMeBooleanFlagTested(){
    String[] hasNoReadme = {"random", "words"};
    String[] hasReadme = {"-README"};
    boolean displayReadMeNo = Project2.readMeFlagCheck(hasNoReadme);
    boolean displayReadMeYes = Project2.readMeFlagCheck(hasReadme);
    assertThat(displayReadMeNo, equalTo(false));
    assertThat(displayReadMeYes,equalTo(true));
  }


  @Test
  void phoneNumberValidation(){
    boolean thisNumberShouldBeValid = Project2.checkForValidPhoneNumber("123-456-7890");
    boolean thisNumberShouldBeInvalid = Project2.checkForValidPhoneNumber("23-567-8901");
    assertThat(thisNumberShouldBeValid, equalTo(true));
    assertThat(thisNumberShouldBeInvalid, equalTo(false));
  }

  @Test
  void validationOfTime(){
    boolean thisTimeShouldBeValid = Project2.checkForValidPhoneCallTime("7:12");
    boolean thisTimeShouldBeInvalid = Project2.checkForValidPhoneCallTime("7777:12");
    assertThat(thisTimeShouldBeValid, equalTo(true));
    assertThat(thisTimeShouldBeInvalid, equalTo(false));
  }

  @Test
  void correctDateValidation(){
    boolean thisDateShouldBeValid = Project2.checkForValidDate("07/07/2022");
    boolean thisDateShouldBeInvalid = Project2.checkForValidDate("077/07/2022");
    assertThat(thisDateShouldBeValid, equalTo(true));
    assertThat(thisDateShouldBeInvalid, equalTo(false));
  }

  @Test
  void requiredArgumentsValidation(){
    String[] argumentsArray = {"Bhaskar", "123-456-7890", "234-567-8901", "07/07/2022", "7:12", "07/07/2022", "7:56"};
    ArrayList<String> arrayListOfArgs = new ArrayList<>();

    for (String s: argumentsArray){
      arrayListOfArgs.add(s);
    }
    boolean theseArgsShouldBeValid = Project2.checkValidityOfRequiredArgs(arrayListOfArgs);
    assertThat(theseArgsShouldBeValid, equalTo(true));
  }

  @Test
  //@Disabled
    void requiredArgumentsInvalidation(){
    String[] invalidArgumentsArray = {"Bhaskar", "12-456-7890", "234-567-8901", "07/07/2022", "7:12", "07/07/2022", "7:56"};
    ArrayList<String> invalidArrayListOfArgs = new ArrayList<>();

    for (String s: invalidArgumentsArray){
      invalidArrayListOfArgs.add(s);
    }

    boolean theseArgsShouldBeInvalid = Project2.checkValidityOfRequiredArgs(invalidArrayListOfArgs);
    assertThat(theseArgsShouldBeInvalid, equalTo(false));
  }





//  @Test
//  void testToPrintToTextfile() throws Exception {
//    String[] argumentsArray = {"-print", "Bhaskar", "12-456-7890", "234-567-8901", "07/07/2022", "7:12", "07/07/2022", "7:56"};
//    String arrayListOfArgs;
//
//    boolean theseArgsShouldBeInvalid = Project2.checkTextFileToPrint(argumentsArray);
//    assertThat(argumentsArray, equalTo(true));
//  }

  @Test
  void testToPrintToTextFile(){
    MainMethodResult result = invokeMain("-print", "Bhaskar", "12-456-7890", "234-567-8901", "07/07/2022", "7:12", "07/07/2022", "7:56");
    //assertThat(result.getExitCode(), equalTo(0) );
    assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call details"));
    
  }

  @Test
  void fileNotExists(){
    File f = new File("TestPhoneBill.txt");
    MainMethodResult result = null;
    if (f.delete()){
      invokeMain("-textFile", "phonebill.txt", "-print", "Bhaskar", "12-456-7890", "234-567-8901", "07/07/2022", "7:12", "07/07/2022", "7:56");
    } else {
      invokeMain("-textFile", "phonebill.txt", "-print", "Bhaskar", "12-456-7890", "234-567-8901", "07/07/2022", "7:12", "07/07/2022", "7:56");
    }
    //assertThat(result.getExitCode(), equalTo(0));
    assert true;
    assertThat(result.getTextWrittenToStandardOut(), containsString("File with the given name does not exist. New file has been created"));
  }

//  @Test
//  void testNewlyAddedPhoneCallInPrint(){
//    File f = new File("TestPhoneBill.txt");
//
//  }








}
