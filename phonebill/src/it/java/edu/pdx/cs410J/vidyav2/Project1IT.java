package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests the functionality in the {@link Project1} main class.
 */
class Project1IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project1} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain(Project1.class, args);
    }

    /**
     * Tests that invoke the main method with no arguments issued as an error
     */
    @Test
     void testNoCommandLineArguments() {
        MainMethodResult result = invokeMain();
        assertThat(result.getTextWrittenToStandardOut(), containsString("No arguments were given at command line!"));
    }

    @Test
    //@Disabled
    void testNoEnoughCommandLineArguments() {
        MainMethodResult result = invokeMain("JW");
        assertThat(result.getTextWrittenToStandardOut(), containsString("You did not enter correct number of values"));
    }

    @Test
    //@Disabled
    public void testPrintOptionsPrintsOnlyNewlyCreatedPhoneCall() {
        MainMethodResult result = invokeMain("-print", "JW", "123-456-7890", "234-567-8901", "07/07/2022", "7:12", "07/07/2022", "7:56");
        assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from JW to callee from 7:12 to 7:56\n"));
    }
}



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
    /*@Test
    public void validCommandLineWithNoPrintOptionPrintsNothingToStandardOut() {
        String caller = "123-456-7890";
        String callee = "234-567-8901";
        String beginDate = "07/07/2022";
        String beginTime = "7:12";
        String endDate = "07/07/2022";
        String endTime = "7:56";

        MainMethodResult result =
                invokeMain("Customer Name", caller, callee, beginDate, beginTime, endDate, endTime);

        //assertThat(result.getTextWrittenToStandardOut(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), equalTo(""));
        assertThat(result.getTextWrittenToStandardError(), equalTo(""));

    }*/

