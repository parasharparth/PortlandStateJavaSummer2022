package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests the functionality in the {@link Project2} main class.
 */
class Project1IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project2} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain(Project2.class, args);
    }

    /**
     * Tests that invoke the main method with no arguments issued as an error
     */

    /* Test to check the behavior when no Command Line Arguments are passed
     */
    @Test
    void noCommandLineArgumentsTest() {
        MainMethodResult result = invokeMain();
        assertThat(result.getTextWrittenToStandardOut(), containsString("No arguments passed at the command line"));
    }


    /* Test to check the behavior when not enough Command Line Arguments are passed
     */
    @Test
    void notEnoughCommandLineArgumentsTest() {
        MainMethodResult result = invokeMain("Bhaskar");
        assertThat(result.getTextWrittenToStandardOut(), containsString("Correct number of values are not entered"));
    }



    @Test
    public void printOptionPrintsOnlyNewlyCreatedPhoneCallTest() {
        MainMethodResult result = invokeMain("-textFile", "newPhonebill.txt", "-print", "Bhaskar", "123-456-7890", "245-566-7863", "07/07/2022", "12:43", "07/07/2022", "12:45" );
        assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from "));
    }
}






//
   /*@Test
    public void readmeOptionPrintsOnlyReadmeFile() {
        MainMethodResult result = invokeMain("-README");
        //assertThat(result.getTextWrittenToStandardOut(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), equalTo(Project1.README + "\n"));
        assertThat(result.getTextWrittenToStandardError(), equalTo(""));
    }
    */

    /*@Test
    public void printOptionsPrintsOnlyNewlyCreatedPhoneCall() {
        String caller = "123-456-7890";
        String callee = "234-567-8901";
        String beginDate = "07/07/2022";
        String beginTime = "7:12";
        String endDate = "07/07/2022";
        String endTime = "7:56";

        MainMethodResult result =
                invokeMain("-print", "Customer Name", caller, callee, beginDate, beginTime, endDate, endTime);

        //assertThat(result.getTextWrittenToStandardOut(), equalTo(0));
        String phoneCallToStringPhonecall = String.format("Registered phone call from %s to %s from %s %s to %s %s",
                caller, callee, beginDate, beginTime, endDate, endTime);
        assertThat(result.getTextWrittenToStandardOut(), equalTo(phoneCallToStringPhonecall + "\n"));
    }
*/

