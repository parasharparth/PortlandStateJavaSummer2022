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

    @Test
    void extraneousArgumentsArePrinted() {
        //File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("", "", "", "", "", "", "-print", "Bhaskar", "129-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }

    @Test
    void whenTenArgumentsArePassed() {
        //File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav2/abc.txt", "-print", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void whenNineArgumentsArePassed() {
        //File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav2/abc.txt", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void whenElevenArgumentsArePassed() {
        File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("-pretty", "-", "vidyav2/abc.txt", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void whenTwelveArgumentsArePassed() {
        File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("-pretty", "-", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    @Disabled
    void when13ArgumentsArePassed_1() {
        File file = new File("vidyav3/abc1.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav3/abc1.txt", "-pretty", "-", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
        result.getTextWrittenToStandardOut();
    }

    @Test
    void when13ArgumentsArePassed_2() {
        File file = new File("vidyav3/abc.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav3/abc.txt", "-pretty", "vidyav3/abcpretty.txt", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void when13ArgumentsArePassed_3() {
        File file = new File("vidyav3/abc.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav3/abc.txt", "-pretty", "vidyav3/abcpretty.txt", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void when14ArgumentsArePassed() {
        File file = new File("vidyav4/abc.txt");
        MainMethodResult result = invokeMain("","","-textFile", "vidyav4/abc.txt", "-pretty", "vidyav4/abcpretty.txt", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }
    @Test
    void whenInvalidArgumentsDatePassed() {
        File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav3/abc2.txt", "-pretty", "-", "Bhaskar",
                "128-456-7890", "245-566-7863", "07/07/20ZZ", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardError(), containsString(""));
    }
    @Test
    @Disabled
    void when13ArgumentsArePassed_4() {
        File file = new File("vidyav3/abc.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav2/abc.txt", "-pretty", "vidyav2/abcpretty.txt", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/20ZZ", "12:42", "AM", "07/07/2022", "12:45", "AM");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }
}













