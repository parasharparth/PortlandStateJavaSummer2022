package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can capture data)
 * written to {@link System#out} and the like.
 */
class Project1Test extends InvokeMainTestCase {

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

//  @Test
//  void readMeBooleanFlagTested() {
//    String[] hasNoReadme = {"random", "words"};
//    String[] hasReadme = {"-README"};
//    boolean displayReadMeNo = HelperFunctions.readMeFlagCheck(hasNoReadme);
//    boolean displayReadMeYes = HelperFunctions.readMeFlagCheck(hasReadme);
//    assertThat(displayReadMeNo, equalTo(false));
//    assertThat(displayReadMeYes, equalTo(true));
//  }
//
//  @Test
//  void phoneNumberValidation() {
//    boolean thisNumberShouldBeValid = HelperFunctions.checkForValidPhoneNumber("123-456-7890");
//    boolean thisNumberShouldBeInvalid = HelperFunctions.checkForValidPhoneNumber("23-567-8901");
//    assertThat(thisNumberShouldBeValid, equalTo(true));
//    assertThat(thisNumberShouldBeInvalid, equalTo(false));
//  }
//
//  @Test
//  void validationOfTime() {
//    boolean thisTimeShouldBeValid = HelperFunctions.checkForValidPhoneCallTime("7:12");
//    boolean thisTimeShouldBeInvalid = HelperFunctions.checkForValidPhoneCallTime("7777:12");
//    assertThat(thisTimeShouldBeValid, equalTo(true));
//    assertThat(thisTimeShouldBeInvalid, equalTo(false));
//  }
//
//  @Test
//  void correctDateValidation() {
//    boolean thisDateShouldBeValid = HelperFunctions.checkForValidDate("07/07/2022");
//    boolean thisDateShouldBeInvalid = HelperFunctions.checkForValidDate("077/07/20ZZ");
//    assertThat(thisDateShouldBeValid, equalTo(true));
//    assertThat(thisDateShouldBeInvalid, equalTo(false));
//  }
//
//  @Test
//  void requiredArgumentsValidation() {
//    String[] argumentsArray = {"Bhaskar", "123-456-7890", "245-566-7863", "07/07/2022",
//            "12:43", "AM", "07/07/2022", "12:45", "AM"};
//    ArrayList<String> arrayListOfArgs = new ArrayList<>();
//
//    Collections.addAll(arrayListOfArgs, argumentsArray);
//    boolean theseArgsShouldBeValid = HelperFunctions.checkValidityOfRequiredArgs(arrayListOfArgs);
//    assertThat(theseArgsShouldBeValid, equalTo(true));
//  }
//
//  @Test
//  void requiredArgumentsInvalidation() {
//    String[] argumentsArray = {"Bhaskar", "12-456-7890", "245-566-7863", "07/07/2022", "12:4XX", "AM", "07/07/2022", "12:45", "AM"};
//
//    ArrayList<String> arrayListOfArgs = new ArrayList<>(Arrays.asList(argumentsArray));
//    boolean theseArgsShouldBeInvalid = HelperFunctions.checkValidityOfRequiredArgs(arrayListOfArgs);
//    assertThat(theseArgsShouldBeInvalid, notNullValue());
//  }

//  @Test
//  void fileNotFoundInDirectory() {
//    String[] argumentsArray = {"","abc.txt.txt","Bhaskar", "12-456-7890", "245-566-7863", "07/07/2022", "12:4XX", "AM", "07/07/2022", "12:45", "AM"};
//
//    ArrayList<String> arrayListOfArgs = new ArrayList<>(Arrays.asList(argumentsArray));
//    boolean theseArgsShouldBeInvalid = Project2.checkValidityOfRequiredArgs(arrayListOfArgs);
//    assertThat(theseArgsShouldBeInvalid, notNullValue());
//  }
}




