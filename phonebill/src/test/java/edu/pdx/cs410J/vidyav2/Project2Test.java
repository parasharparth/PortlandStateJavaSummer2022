package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can capture data)
 * written to {@link System#out} and the like.
 */
class Project2Test extends InvokeMainTestCase {

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

}




