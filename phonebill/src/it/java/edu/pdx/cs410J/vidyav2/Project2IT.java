package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Project2IT extends InvokeMainTestCase {
    /**
     * Invokes the main method of {@link Project2IT} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain(Project1.class, args);
    }

    @Test
    void readMeAssertionTest(){
        MainMethodResult result = invokeMain("-ReadMe");
        assertThat(result.getTextWrittenToStandardOut(), containsString("ReadMe"));
    }

    @Test
    void validCallTimeAssertion(){
        MainMethodResult result = invokeMain("-textFile", "src/test/resources/edu/pdx/cs410J/vidyav2/Project2TextFile.txt",
                "Nick Jonas", "425-555-5555", "206-555-5555", "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
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
        MainMethodResult result = invokeMain("-textFile", "src/test/resources/edu/pdx/cs410J/vidyav2/Project2TextFile.txt",
                "Nick Jonas", "425-555-5555", "206-555-5555", "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
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
        MainMethodResult result = invokeMain("-textFile", "src/test/resources/edu/pdx/cs410J/vidyav2/Project2TextFile.txt",
                "Nick Jonas", "425-555-5555", "206-555-5555", "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertAll(
                () -> assertThat(result.getTextWrittenToStandardOut(), containsString("09/24/2022")),
                () -> {
                    boolean helperResult = HelperFunctions.checkForValidPhoneNumber("09/24/2022");
                    assertThat(helperResult, equalTo(true));
                }
        );
    }

    @Test
    void NoOptionArgument() {
        MainMethodResult result = invokeMain("Nick Jonas", "425-555-5555", "206-555-5555",
                "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertThat(result.getTextWrittenToStandardOut(),
                containsString(""));
    }

    @Test
    void UnknownOptionGiven() {
        MainMethodResult result = invokeMain("-IDontKnowThisOption", "Nick Jonas", "425-555-5555", "206-555-5555",
                "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertThat(result.getTextWrittenToStandardError(),
                containsString("Unknown option is provided"));
    }

    @Test
    void TooManyArguments() {
        MainMethodResult result = invokeMain("-textFile", "Nick Jonas", "425-555-5555", "206-555-5555",
                "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm", "too", "many", "arguments", "given");
        assertThat(result.getTextWrittenToStandardError(),
                containsString("Extraneous arguments"));
    }

    @Test
    void NotEnoughArguments() {
        MainMethodResult result = invokeMain("-textFile", "Nick Jonas", "425-555-5555", "206-555-5555",
                "09/24/2022", "12:50", "pm", "09/24/2022");
        assertThat(result.getTextWrittenToStandardError(),
                containsString("Missing phone call information"));
    }

    @Test
    void CorrectFileTypeCheckTest(){
        MainMethodResult result = invokeMain("-textFile", "src/test/resources/edu/pdx/cs410J/vidyav2/Project2TextFile.txt",
                "Nick Jonas", "425-555-5555", "206-555-5555", "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertThat(result.getTextWrittenToStandardOut(),
                containsString(".txt"));
    }
    @Test
    void WrongFileTypeTest(){
        MainMethodResult result = invokeMain("-textFile", "src/test/resources/edu/pdx/cs410J/vidyav2/WrongFileType.abc",
                "Nick Jonas", "425-555-5555", "206-555-5555", "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertThat(result.getTextWrittenToStandardError(),
                containsString(".abc"));
    }

    @Test
    void TextFileExistsTest(){
        MainMethodResult result = invokeMain("-textFile", "src/test/resources/edu/pdx/cs410J/vidyav2/valid-phonebill.txt",
                "Nick Jonas", "425-555-5555", "206-555-5555", "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertThat(result.getTextWrittenToStandardOut(),
                containsString("valid-phonebill.txt"));
    }

    @Test
    void TextFileExistsOtherThanResourceFolder(){
        MainMethodResult result = invokeMain("-textFile", "WrongFilePathTest.txt",
                "Nick Jonas", "425-555-5555", "206-555-5555", "09/24/2022", "12:50", "pm", "09/24/2022", "1:00", "pm");
        assertThat(result.getTextWrittenToStandardError(),
                containsString("WrongFilePathTest.txt"));
    }
}

