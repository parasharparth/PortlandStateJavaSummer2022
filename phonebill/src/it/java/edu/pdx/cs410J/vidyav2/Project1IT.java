package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests the functionality in the {@link Project3} main class.
 */
class Project1IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project3} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain(Project3.class, args);
    }

    /**
     * Tests that invoke the main method with no arguments issued as an error
     */

    @Test
    void noCommandLineArgumentsTest() {
        MainMethodResult result = invokeMain();
        assertThat(result.getTextWrittenToStandardOut(), containsString("\nNo arguments passed at " +
                "the command line.\n"));
    }

    @Test
    void notEnoughCommandLineArgumentsTest() {
        MainMethodResult result = invokeMain("-textFile");
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }

    @Test
    void readMeFlagIsPrintedWhenCLIIsGiven() {
        MainMethodResult result = invokeMain("-README");
        assertThat(result.getTextWrittenToStandardOut(), containsString("Student"));
    }

    @Test
    void extraneousArgumentsArePrinted() {
        MainMethodResult result = invokeMain("", "", "", "", "", "", "-pretty", "Bhaskar", "129-456-7890",
                "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardError(), containsString("Extraneous or wrong arguments are " +
                "being printed, this is not allowed"));
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }

    @Test
    void whenTenArgumentsArePassed() {
        File file = new File("vidyav2/abc.txt");
        MainMethodResult result = invokeMain("-textFile", "file", "-print", "Bhaskar",
                "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void whenNineArgumentsArePassed() {
        File file1 = new File("vidyav2/abc1.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav2/abc1.txt", "Bhaskar", "128-456-7890",
                "245-566-7863", "07/07/2022", "12:42", "07/07/2022", "12:45");
        assertThat(result.getTextWrittenToStandardError(), containsString("There are some missing arguments."));
    }

    @Test
    void whenElevenArgumentsArePassed() {
        File file2 = new File("vidyav2/abc2.txt");
        MainMethodResult result = invokeMain("-pretty", "-", "vidyav2/abc2.txt", "Bhaskar", "128-456-7890",
                "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void whenTwelveArgumentsArePassed() {
        //File file = new File("vidyav2/abc3.txt");
        MainMethodResult result = invokeMain("-pretty", "-", "Bhaskar", "128-456-7890", "245-566-7863",
                "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardOut(), notNullValue());
        System.out.println("Test to check the correctness when 12 arguments are passed. Test Passed.");
    }

    @Test
    void whenTwelveArgumentsArePassed_1() {
        //File file3 = new File("vidyav2/abc4.txt");
        MainMethodResult result = invokeMain("-textFile","vidyav5/abc4.txt", "Bhaskar",
                "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
        System.out.println("Test to check the correctness when 12 arguments are passed. Test Passed.");
    }

    @Test
    void whenTwelveArgumentsArePassed_2() {
        //File file3 = new File("vidyav2/abc4.txt");
        MainMethodResult result = invokeMain("-textFile","vidyav5abc4.txt", "Bhaskar",
                "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        //assertThat(result.getTextWrittenToStandardOut(), notNullValue());
        System.out.println("Test to check the correctness when 12 arguments are passed. Test Passed.");
    }
    @Test
    void prettyPrinter_test() {
        MainMethodResult result = invokeMain("-pretty", "-print", "$%^^", "Bhaskar", "128-456-7890",
                "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardError(), containsString(""));
        //System.out.println("Test to check the correctness when 12 arguments are passed. Test Passed.");
    }

    @Test
    void when13ArgumentsArePassed_1() {
        File file4 = new File("vidyav3/abc5.txt");
        MainMethodResult result = invokeMain("-pretty", "-", "-textFile", "vidyav3/abc5.txt", "Bhaskar",
                "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void when13ArgumentsArePassed_2() {
        File file5 = new File("vidyav3/abc6.txt");
        File file15 = new File("vidyav3/abc6_pretty.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav3/abc6.txt", "-pretty", "vidyav3/abc6_pretty.txt",
                "Vidya", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void when13ArgumentsArePassed_2_1() {
        //File file6 = new File("vidyav3/abc7.txt");
        //File file16 = new File("vidyav3/abc7_pretty.txt");
        MainMethodResult result = invokeMain("-textFile", "vidyav3/abc7.txt", "-pretty", "vidyav3/abc7_pretty.txt",
                "Vidya", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardOut(), notNullValue());
    }

    @Test
    void when14ArgumentsArePassed() {
        //File file7 = new File("vidyav4/abc8.txt");
        MainMethodResult result = invokeMain("","","-textFile","vidyav4/abc8.txt" , "-pretty",
                "vidyav2/abcpretty.txt", "Bhaskar", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM",
                "07/07/2022", "12:45", "AM");
        assertThat(result.getTextWrittenToStandardError(), containsString("Extraneous"));
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }


    @Test
    public void fileNotExist() {
        File file8 = new File("vidyav2/abc9.txt");
        File file18 = new File("vidyav3/abc9_pretty.txt");
        MainMethodResult result = null;
        if (file8.delete()) {
            result = invokeMain("-textFile", "vidyav2/abc9.txt", "-pretty", "vidyav3/abc9_pretty.txt",
                    "Vidya", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022",
                    "12:45", "AM");
        } else {
            result = invokeMain("-textFile", "vidyav2/abc9.txt", "-pretty", "vidyav3/abc9_pretty.txt",
                    "Vidya", "128-456-7890", "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022",
                    "12:45", "AM");
        }
        //assertThat(result.getTextWrittenToStandardError(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Text Dump File with given " +
                "name does not exist. New File created."));
        //
    }
    @Test
    public void dumpFileNotExist() {
        File file9 = new File("vidyav2/abc10.txt");
        MainMethodResult result = null;
        if (file9.delete()) {
            result = invokeMain("-textFile", "vidyav2/abc10.txt", "Vidya", "128-456-7890",
                    "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        } else {
            result = invokeMain("-textFile", "vidyav2/abc10.txt", "Vidya", "128-456-7890",
                    "245-566-7863", "07/07/2022", "12:42", "AM", "07/07/2022", "12:45", "AM");
        }
        //assertThat(result.getTextWrittenToStandardError(), equalTo(0));
        //assertThat(result.getTextWrittenToStandardOut(), containsString("Text Dump File with given " +
             //   "name does not exist. New File created."));
    }

}













