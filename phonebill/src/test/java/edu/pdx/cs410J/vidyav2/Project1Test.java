package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can capture data
 * written to {@link System#out} and the like.
 */
class Project1Test {

  @Test
  void readmeCanBeReadAsResource() throws IOException {
    try (
      InputStream readme = Project1.class.getResourceAsStream("README.txt")
    ) {
      assertThat(readme, not(nullValue()));
      BufferedReader reader = new BufferedReader(new InputStreamReader(readme));
      String line = reader.readLine();
      assertThat(line, containsString("Java"));
    }
  }

  @Test
  void testReadmeBooleanFlag(){
    String[] hasNoReadme = {"random", "words"};
    String[] hasReadme = {"-README"};
    boolean displayReadMeNo = Project1.checkReadmeFlag(hasNoReadme);
    boolean displayReadMeYes = Project1.checkReadmeFlag(hasReadme);
    assertThat(displayReadMeNo, equalTo(false));
    assertThat(displayReadMeYes,equalTo(true));
  }


  @Test
  void validationOfPhoneNumber(){
    boolean thisNumberShouldBeValid = Project1.checkValidityOfPhoneNumber("123-456-7890");
    boolean thisNumberShouldBeInvalid = Project1.checkValidityOfPhoneNumber("23-567-8901");
    assertThat(thisNumberShouldBeValid, equalTo(true));
    assertThat(thisNumberShouldBeInvalid, equalTo(false));
  }

  @Test
  void validationOfDate(){
    boolean thisDateShouldBeValid = Project1.checkValidityOfDate("07/07/2022");
    boolean thisDateShouldBeInvalid = Project1.checkValidityOfDate("077/07/2022");
    assertThat(thisDateShouldBeValid, equalTo(true));
    assertThat(thisDateShouldBeInvalid, equalTo(false));
  }

  @Test
  void validationOfTime(){
    boolean thisTimeShouldBeValid = Project1.checkValidityOfPhoneCallTime("7:12");
    boolean thisTimeShouldBeInvalid = Project1.checkValidityOfPhoneCallTime("7777:12");
    assertThat(thisTimeShouldBeValid, equalTo(true));
    assertThat(thisTimeShouldBeInvalid, equalTo(false));
  }

  @Test
  void checkValidityOfAllRequiredArguments(){
    String[] argumentsArray = {"JW", "123-456-7890", "234-567-8901", "07/07/2022", "7:12", "07/07/2022", "7:56"};
    ArrayList<String> arrayListOfArgs = new ArrayList<>();

    for (String s: argumentsArray){
      arrayListOfArgs.add(s);
    }

    boolean theseArgsShouldBeValid = Project1.checkValidityOfAllRequiredArguments(arrayListOfArgs);
    assertThat(theseArgsShouldBeValid, equalTo(true));
  }

  @Test
  //@Disabled
    void checkInvalidityOfAllRequiredArguments(){
    String[] invalidArgumentsArray = {"JW", "12-456-7890", "234-567-8901", "07/07/2022", "7:12", "07/07/2022", "7:56"};
    ArrayList<String> invalidArrayListOfArgs = new ArrayList<>();

    for (String s: invalidArgumentsArray){
      invalidArrayListOfArgs.add(s);
    }

    boolean theseArgsShouldBeInvalid = Project1.checkValidityOfAllRequiredArguments(invalidArrayListOfArgs);
    assertThat(theseArgsShouldBeInvalid, equalTo(false));
  }




}
