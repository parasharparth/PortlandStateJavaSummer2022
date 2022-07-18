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
  void readMeBooleanFlagTested() {
    String[] hasNoReadme = {"random", "words"};
    String[] hasReadme = {"-README"};
    boolean displayReadMeNo = Project2.readMeFlagCheck(hasNoReadme);
    boolean displayReadMeYes = Project2.readMeFlagCheck(hasReadme);
    assertThat(displayReadMeNo, equalTo(false));
    assertThat(displayReadMeYes, equalTo(true));
  }


  @Test
  void phoneNumberValidation() {
    boolean thisNumberShouldBeValid = Project2.checkForValidPhoneNumber("123-456-7890");
    boolean thisNumberShouldBeInvalid = Project2.checkForValidPhoneNumber("23-567-8901");
    assertThat(thisNumberShouldBeValid, equalTo(true));
    assertThat(thisNumberShouldBeInvalid, equalTo(false));
  }

  @Test
  void validationOfTime() {
    boolean thisTimeShouldBeValid = Project2.checkForValidPhoneCallTime("7:12");
    boolean thisTimeShouldBeInvalid = Project2.checkForValidPhoneCallTime("7777:12");
    assertThat(thisTimeShouldBeValid, equalTo(true));
    assertThat(thisTimeShouldBeInvalid, equalTo(false));
  }

  @Test
  void correctDateValidation() {
    boolean thisDateShouldBeValid = Project2.checkForValidDate("07/07/2022");
    boolean thisDateShouldBeInvalid = Project2.checkForValidDate("077/07/2022");
    assertThat(thisDateShouldBeValid, equalTo(true));
    assertThat(thisDateShouldBeInvalid, equalTo(false));
  }

  @Test
  void requiredArgumentsValidation() {
    String[] argumentsArray = {"-textFile", "phonebill.txt", "-print", "Bhaskar", "123-456-7890", "245-566-7863", "07/07/2022", "12:43", "07/07/2022", "12:45"};
    ArrayList<String> arrayListOfArgs = new ArrayList<>();

    for (String s : argumentsArray) {
      arrayListOfArgs.add(s);
    }
    boolean theseArgsShouldBeValid = Project2.checkValidityOfRequiredArgs(arrayListOfArgs);
    assertThat(theseArgsShouldBeValid, equalTo(true));
  }

  @Test
    //@Disabled
  void requiredArgumentsInvalidation() {
    String[] invalidArgumentsArray = {"-textFile", "phonebill.txt", "-print", "Bhaskar", "13-456-7890", "245-566-7863", "07/07/2022", "12:43", "07/07/2022", "12:45"};
    ArrayList<String> invalidArrayListOfArgs = new ArrayList<>();

    for (String s : invalidArgumentsArray) {
      invalidArrayListOfArgs.add(s);
    }

    boolean theseArgsShouldBeInvalid = Project2.checkValidityOfRequiredArgs(invalidArrayListOfArgs);
    assertThat(theseArgsShouldBeInvalid, equalTo(false));
  }


  @Test
  void testToPrintToTextFileWithValidArguments() {
    String[] argumentsArray = {"-textFile", "phonebill.txt", "-print", "Bhaskar", "123-456-7890", "245-566-7863", "07/07/2022", "12:43", "07/07/2022", "12:45"};
    ArrayList<String> arrayListOfArgs = new ArrayList<>();

    for (String s : argumentsArray) {
      arrayListOfArgs.add(s);
    }
    boolean theseArgsShouldBeValid = Project2.checkValidityOfRequiredArgs(arrayListOfArgs);
    assertThat(theseArgsShouldBeValid, equalTo(true));
  }

  @Test
  void fileNotExists() {
    String[] argumentsArray = {"-textFile", "bogus.txt", "-print", "Bhaskar", "123-456-7890", "245-566-7863", "07/07/2022", "12:43", "07/07/2022", "12:45"};
    ArrayList<String> arrayListOfArgs = new ArrayList<>();

    for (String s : argumentsArray) {
      arrayListOfArgs.add(s);
    }
    boolean theseArgsShouldBeInvalid = Project2.checkValidityOfRequiredArgs(arrayListOfArgs);
    assertThat(theseArgsShouldBeInvalid, notNullValue());

  }

  @Test
  void fileThatHasInvalidDateFormat() {
    String[] invalidArgumentsArray = {"-textFile", "phonebill.txt", "-print", "Bhaskar", "131-456-7890", "245-566-7863", "077/07/2022", "12:43", "07/07/2022", "12:45"};
    ArrayList<String> invalidArrayListOfArgs = new ArrayList<>();

    for (String s : invalidArgumentsArray) {
      invalidArrayListOfArgs.add(s);
    }

    boolean theseArgsShouldBeInvalid = Project2.checkForValidDate("077/07/2022");
    assertThat(theseArgsShouldBeInvalid, equalTo(false));
  }


  @Test
  void fileThatHasInvalidTimeFormat() {
    String[] invalidArgumentsArray = {"-textFile", "phonebill.txt", "-print", "Bhaskar", "131-456-7890", "245-566-7863", "07/07/2022", "454:43", "07/07/2022", "12:45"};
    ArrayList<String> invalidArrayListOfArgs = new ArrayList<>();

    for (String s : invalidArgumentsArray) {
      invalidArrayListOfArgs.add(s);
    }

    boolean theseArgsShouldBeInvalid = Project2.checkForValidPhoneCallTime("454:43");
    assertThat(theseArgsShouldBeInvalid, equalTo(false));
  }

  @Test
  void fileThatHasInvalidPhoneNumberFormat() {
    String[] invalidArgumentsArray = {"-textFile", "phonebill.txt", "-print", "Bhaskar", "1312-456-7890", "245-566-7863", "07/07/2022", "04:43", "07/07/2022", "12:45"};
    ArrayList<String> invalidArrayListOfArgs = new ArrayList<>();

    for (String s : invalidArgumentsArray) {
      invalidArrayListOfArgs.add(s);
    }

    boolean theseArgsShouldBeInvalid = Project2.checkForValidPhoneNumber("1312-456-7890");
    assertThat(theseArgsShouldBeInvalid, equalTo(false));
  }


}

