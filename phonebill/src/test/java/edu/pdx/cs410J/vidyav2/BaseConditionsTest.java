package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class BaseConditionsTest extends PhoneCall {
    @Test
    public void testBaseCondition13WithValidArgs() {
        ArrayList<String> commandLineArgs = new ArrayList<>();
        commandLineArgs.add("-textFile");
        commandLineArgs.add("test.txt");
        commandLineArgs.add("-pretty");
        commandLineArgs.add("output.txt");
        Assertions.assertTrue(BaseConditions.baseCondition13(commandLineArgs));
    }

    @Test
    public void testBaseCondition13WithInvalidArgs() {
        ArrayList<String> commandLineArgs = new ArrayList<>();
        commandLineArgs.add("-textFile");
        commandLineArgs.add("test.pdf");
        commandLineArgs.add("-pretty");
        commandLineArgs.add("output.pdf");
        Assertions.assertFalse(BaseConditions.baseCondition13(commandLineArgs));
    }

    @Test
    public void testBaseCondition13DumpWithValidArgs() {
        ArrayList<String> commandLineArgs = new ArrayList<>();
        commandLineArgs.add("-textFile");
        commandLineArgs.add("test.txt");
        commandLineArgs.add("-pretty");
        commandLineArgs.add("-");
        Assertions.assertTrue(BaseConditions.baseCondition13Dump(commandLineArgs));
    }

    @Test
    public void testBaseCondition13DumpWithInvalidArgs() {
        ArrayList<String> commandLineArgs = new ArrayList<>();
        commandLineArgs.add("-textFile");
        commandLineArgs.add("test.pdf");
        commandLineArgs.add("-pretty");
        commandLineArgs.add("output.txt");
        Assertions.assertFalse(BaseConditions.baseCondition13Dump(commandLineArgs));
    }

    @Test
    public void testSettingCallDetailsForParsing() {
        ArrayList<String> commandLineArgs = new ArrayList<>();
        commandLineArgs.add("-textFile");
        commandLineArgs.add("test.txt");
        commandLineArgs.add("-pretty");
        commandLineArgs.add("output.txt");
        commandLineArgs.add("callerName");
        commandLineArgs.add("callerNumber");
        commandLineArgs.add("calleeNumber");
        commandLineArgs.add("2023/03/24");
        commandLineArgs.add("10");
        commandLineArgs.add("30");
        commandLineArgs.add("2023/03/24");
        commandLineArgs.add("11");
        commandLineArgs.add("00");
        PhoneCall call = new PhoneCall();
        BaseConditions.settingCallDetailsForParsing(commandLineArgs, call);
        Assertions.assertEquals("callerName", call.getCaller());
        Assertions.assertEquals("callerNumber", call.getCallee());
        Assertions.assertEquals("calleeNumber", call.getCallee());
        Assertions.assertEquals("2023/03/24", call.getPhoneCallBeginDate());
        Assertions.assertEquals("10", call.getBeginTimeString());
        Assertions.assertEquals("30", call.getBeginTimeString());
        Assertions.assertEquals("2023/03/24", call.getPhoneCallEndDate());
        Assertions.assertEquals("11", call.getEndTimeString());
        Assertions.assertEquals("00", call.getEndTimeString());
    }
}
