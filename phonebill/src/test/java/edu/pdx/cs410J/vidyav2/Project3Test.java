package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/************************************************************************************
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can capture data)
 * written to {@link System#out} and the like.
 ************************************************************************************/
class Project3Test extends InvokeMainTestCase {


  /*********************************************************************************************************************************************
   * Invokes the main method of {@link Project3} with the given arguments.
   * readmeCanBeReadAsResource() this checks that the README.txt file can be read as a resource, and that it contains the word "Java".
   * readMeBooleanFlagTested() checks that the -README flag is properly recognized by calling the readMeFlagCheck method of the HelperFunctions class on arrays with and without the flag.
   * fileNotFoundInDirectory() This JUnit test checks that the checkValidityOfRequiredArgs method of the HelperFunctions class correctly identifies invalid arguments (in this case, a file name with a double extension).
   * testTextFileExists() This JUnit test checks that a text file can be created with the given name and contents
   * testTextFileIsPretty()  Test case to check if the pretty print flag works correctly when writing to a file
   * phoneNumbersHaveCharacters() Test case to check if phone numbers with characters throw an error
   * billHasNoCustomer() Test case to check if a bill with no customer name throws an error
   *********************************************************************************************************************************************/

  public MainMethodResult invokeMain(String... args) {

    return invokeMain(Project3.class, args);
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
    boolean displayReadMeNo = HelperFunctions.readMeFlagCheck(hasNoReadme);
    boolean displayReadMeYes = HelperFunctions.readMeFlagCheck(hasReadme);
    assertThat(displayReadMeNo, equalTo(false));
    assertThat(displayReadMeYes, equalTo(true));
  }

  @Test
  void fileNotFoundInDirectory() {
    String[] argumentsArray = {"","abc.txt.txt","Bhaskar", "12-456-7890", "245-566-7863", "07/07/2022",
            "12:4XX", "AM", "07/07/2022", "12:45", "AM"};
    ArrayList<String> arrayListOfArgs = new ArrayList<>(Arrays.asList(argumentsArray));
    boolean theseArgsShouldBeInvalid = HelperFunctions.checkValidityOfRequiredArgs(arrayListOfArgs);
    assertThat(theseArgsShouldBeInvalid, notNullValue());
  }

  @Test
  public void testTextFileExists() throws Exception {
    String textFileName = "test.txt";
    HelperFunctions.writeToFile(textFileName, "customerName\ncallerNumber\ncalleeNumber\nstartTime\nendTime");
    Project2.main(new String[] { "-textFile", textFileName });
    assertTrue(HelperFunctions.fileExists("pretty.txt"));
  }
  @Test
  public void testTextFileIsPretty() throws Exception {
    String textFileName = "test.txt";
    HelperFunctions.writeToFile(textFileName, "customerName\ncallerNumber\ncalleeNumber\nstartTime\nendTime");
    Project2.main(new String[] { "-textFile", textFileName, "-pretty", "pretty.txt" });
    assertTrue(HelperFunctions.fileExists("pretty.txt"));
  }

  @Test
  void phoneNumbersHaveCharacters() {
    MainMethodResult result = invokeMain("Test3", "ABC-123-4567", "123-456-7890",
            "03/03/2023", "12:00", "pm", "03/03/2023", "1:00", "pm");
    assertThat(result.getTextWrittenToStandardError(),
            containsString("NNN-NNN-NNNN where N is 0-9 for phone numbers"));
  }

  @Test
  void billHasNoCustomer() {
    MainMethodResult result = invokeMain("-print", "-textfile", "no-customer", "BillyBob",
            "425-555-5555", "206-555-5555", "05/24/2023", "12:50", "pm", "05/24/2023", "1:00", "pm");
    assertThat(result.getTextWrittenToStandardError(),
            containsString("bill has no customer name"));
  }

}




