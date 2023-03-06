package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Tests the functionality in the {@link Project1} main class.
 */
class Project1IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project1IT} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain(Project1.class, args);
    }

    /**
     * Tests that invoke the main method with no arguments issued as an error
     */

    @Test
    void noCommandLineArgumentsTest() {
        MainMethodResult result = invokeMain();
        assertThat(result.getTextWrittenToStandardOut(), containsString("No arguments passed at " +
                "the command line"));
    }

    @Test
    void readMeAssertionTest(){
        MainMethodResult result = invokeMain("-ReadMe");
        assertThat(result.getTextWrittenToStandardOut(), containsString("ReadMe"));
    }

    @Test
    void validCallTimeAssertion(){
        MainMethodResult result = invokeMain("-print", "Nick Jonas", "425-555-5555", "206-555-5555",
                "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertAll(
                () -> assertThat(result.getTextWrittenToStandardOut(), containsString("12:50")),
                //() -> assertThat(new File("").exists(), equalTo(true)),
                () -> {
                    boolean helperResult = HelperFunctions.checkForValidPhoneCallTime("12:50");
                    assertThat(helperResult, equalTo(true));
                }
        );
    }

    @Test
    void validPhoneNumberAssertion(){
        MainMethodResult result = invokeMain("-print", "Nick Jonas", "425-555-5555", "206-555-5555",
                "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertAll(
                () -> assertThat(result.getTextWrittenToStandardOut(), containsString("425-555-5555")),
                () -> {
                    boolean helperResult = HelperFunctions.checkForValidPhoneNumber("425-555-5555");
                    assertThat(helperResult, equalTo(true));
                }
        );
    }

    @Test
    void validDateAssertion(){
        MainMethodResult result = invokeMain("-print", "Nick Jonas", "425-555-5555", "206-555-5555",
                "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertAll(
                () -> assertThat(result.getTextWrittenToStandardOut(), containsString("09/24/2022")),
                () -> {
                    boolean helperResult = HelperFunctions.checkForValidPhoneNumber("09/24/2022");
                    assertThat(helperResult, equalTo(true));
                }
        );
    }
}













