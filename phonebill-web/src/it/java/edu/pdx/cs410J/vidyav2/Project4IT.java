package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.InvokeMainTestCase;
import edu.pdx.cs410J.whitlock.Project4;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Tests the {@link Project4} class by invoking its main method with various arguments
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Project4IT extends InvokeMainTestCase {
    private static final String HOSTNAME = "localhost";
    private static final String PORT = System.getProperty("http.port", "8080");

//    @Test
//    void test0RemoveAllMappings() throws IOException {
//      PhoneBillRestClient client = new PhoneBillRestClient(HOSTNAME, Integer.parseInt(PORT));
//      client.removeAllDictionaryEntries();
//    }

    @Test
    void test1NoCommandLineArguments() {
        MainMethodResult result = invokeMain( Project4.class );
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }


    @Test
    void test4notEnoughCommandLineArguments() {
        MainMethodResult result = invokeMain(Project4.class);
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }


    @Test
    public void test4extraneousArgumentsArePrinted() {
        MainMethodResult result = invokeMain( Project4.class, "-host", HOSTNAME, "-port", PORT, "Dave",
                "222-333-4444", "222-555-8888", "07/19/2020", "1:02", "pm", "07/19/2020", "6:22", "pm", "Vidya", "abc", "yes");
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }

     @Test
    public void test4AddPhonecall() {
        MainMethodResult result = invokeMain( Project4.class, "-host", HOSTNAME, "-port", PORT,
                "Dave", "222-333-4444", "222-555-8888", "07/19/2020", "1:02", "pm", "07/19/2020", "6:22", "pm" );
        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
    }

    @Test
    void readMetest() {
        MainMethodResult result = invokeMain( Project4.class, "-README");
        assertThat(result.getTextWrittenToStandardOut(), containsString("README"));
    }
//    @Test
//    public void test4searchPhonecall() {
//        MainMethodResult result = invokeMain( Project4.class, "-host", HOSTNAME, "-port", PORT,
//                "Dave");
//        assertThat(result.getTextWrittenToStandardOut(), containsString(""));
//    }


}