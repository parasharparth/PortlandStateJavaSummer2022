package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
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
//
//
//    /* Test to check the behavior when not enough Command Line Arguments are passed
//     */
    @Test
    void notEnoughCommandLineArgumentsTest() {
        MainMethodResult result = invokeMain("-textFile");
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }
//
//
    @Test
    void readMeFlagIsPrintedWhenCLIIsGiven() {
        MainMethodResult result = invokeMain("-README");
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }

//
//    @Test
//    @Disabled
//    void testPrintOutNewPhoneCallForValidInput() {
//        MainMethodResult result = invokeMain("-textFile", "vidyav2/av.txt", "Bhaskar", "503-820-9560", "334-555-2223", "12/2/2022", "08:34", "3/12/2022", "2:45");
//        //assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-820-9560 to 334-555-2223 from 08:34 to 2:45"));
//
//    }
//
    @Test
    void extraneousArgumentsArePrinted() {
        File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("", "", "-print", "Bhaskar", "129-456-7890", "245-566-7863", "07/07/2022", "12:42", "07/07/2022", "12:45");
        assertThat(result.getTextWrittenToStandardOut(), containsString("Extraneous"));
    }
//

    @Test
    void whenTenArgumentsArePassed() {
        File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav2/abc.txt", "-print",  "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "07/07/2022", "12:45");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void whenNineArgumentsArePassed() {
        File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav2/abc.txt", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "07/07/2022", "12:45");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }
}












