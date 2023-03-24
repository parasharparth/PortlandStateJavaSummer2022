package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneCallTest {

    /**
     * This method tests getBeginTimeString() method
     */
    @Test
    void getBeginTimeStringTest()  {
        PhoneCall call = new PhoneCall();
        call.setPhoneCallBeginTime("03/23/2023", "11:45", "AM");

        String expectedOutput = "03/23/2023 11:45 AM";
        String actualOutput = call.getBeginTimeString();
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * This method tests getEndTimeString() method
     */
    @Test
    void getEndTimeStringTest()  {
        PhoneCall call = new PhoneCall();
        call.setPhoneCallEndTime("03/23/2023", "12:45", "PM");

        String expectedOutput = "03/23/2023 12:45 PM";
        String actualOutput = call.getEndTimeString();
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * tests getCaller method
     */
    @Test
    void getCallerTest() {
        PhoneCall call = new PhoneCall();
        call.setCallerNumber("123-456-7890");

        String expectedCallerNumber = "123-456-7890";
        String actualCallerNumber = call.getCaller();
        assertEquals(expectedCallerNumber, actualCallerNumber);
    }

    /**
     * tests getCallee method
     */
    @Test
    void getCalleeTest() {
        PhoneCall call = new PhoneCall();
        call.setCalleeNumber("123-456-7890");

        String expectedCalleeNumber = "123-456-7890";
        String actualCalleeNumber = call.getCallee();
        assertEquals(expectedCalleeNumber, actualCalleeNumber);
    }
}