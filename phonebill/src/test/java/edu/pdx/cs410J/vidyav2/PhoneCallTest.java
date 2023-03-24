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
}