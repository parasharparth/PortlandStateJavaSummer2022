package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HelperFunctionTests extends HelperFunctions{
    @Test
    public void testCheckHostAndPortWithValidInputs() {
        String hostName = "localhost";
        String portName = "8080";
        assertDoesNotThrow(() -> HelperFunctions.checkHostAndPort(hostName, portName));
    }

    @Test
    void checkHostAndPort_validHostAndPort() {
        assertDoesNotThrow(() -> HelperFunctions.checkHostAndPort("localhost", "8080"));
    }

    @Test
    void checkHostAndPort_missingHostName() {
        assertThrows(IllegalArgumentException.class, () -> HelperFunctions.checkHostAndPort(null, "8080"));
    }

    @Test
    void checkHostAndPort_missingPortNumber() {
        assertThrows(IllegalArgumentException.class, () -> HelperFunctions.checkHostAndPort("localhost", null));
    }

    @Test
    void checkHostAndPort_invalidPortNumber() {
        assertThrows(NumberFormatException.class, () -> HelperFunctions.checkHostAndPort("localhost", "invalid"));
    }

    @Test
    void checkValidityOfRequiredArgs_noArgs() {
        ArrayList<String> args = new ArrayList<>();
        Assertions.assertTrue(HelperFunctions.checkValidityOfRequiredArgs(args));
    }

    @Test
    void checkValidityOfRequiredArgs_invalidPhoneNumber() {
        ArrayList<String> args = new ArrayList<>();
        args.add("arg1");
        args.add("123-456-7890");
        args.add("arg3");
        args.add("arg4");
        args.add("arg5");
        args.add("arg6");
        args.add("arg7");
        Assertions.assertTrue(HelperFunctions.checkValidityOfRequiredArgs(args));
    }

    @Test
    void checkValidityOfRequiredArgs_invalidDate() {
        ArrayList<String> args = new ArrayList<>();
        args.add("arg1");
        args.add("arg2");
        args.add("invalidDate");
        args.add("arg4");
        args.add("arg5");
        args.add("arg6");
        args.add("arg7");
        Assertions.assertTrue(HelperFunctions.checkValidityOfRequiredArgs(args));
    }

    @Test
    void checkValidityOfRequiredArgs_invalidPhoneCallTime() {
        ArrayList<String> args = new ArrayList<>();
        args.add("arg1");
        args.add("arg2");
        args.add("arg3");
        args.add("invalidTime");
        args.add("arg5");
        args.add("arg6");
        args.add("arg7");
        Assertions.assertTrue(HelperFunctions.checkValidityOfRequiredArgs(args));
    }

    @Test
    void checkValidityOfRequiredArgs_validArgs() {
        ArrayList<String> args = new ArrayList<>();
        args.add("arg1");
        args.add("123-456-7890");
        args.add("123-456-7890");
        args.add("1/1/2022");
        args.add("00:00");
        args.add("1/2/2022");
        args.add("00:00");
        Assertions.assertFalse(HelperFunctions.checkValidityOfRequiredArgs(args));
    }

    @Test
    void checkForValidPhoneCallTime_validTime() {
        Assertions.assertFalse(HelperFunctions.checkForValidPhoneCallTime("12:30"));
    }

    @Test
    void checkForValidPhoneCallTime_invalidTime() {
        Assertions.assertTrue(HelperFunctions.checkForValidPhoneCallTime("invalid"));
    }

    @Test
    void checkForValidDate_validDate() {
        Assertions.assertFalse(HelperFunctions.checkForValidDate("1/1/2022"));
    }

    @Test
    void checkForValidDate_invalidDate() {
        Assertions.assertTrue(HelperFunctions.checkForValidDate("invalid"));
    }

    @Test
    void checkForValidPhoneNumber_validPhoneNumber() {
        Assertions.assertFalse(HelperFunctions.checkForValidPhoneNumber("123-456-7890"));
    }

}
