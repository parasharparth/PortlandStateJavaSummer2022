package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static groovy.test.GroovyTestCase.assertEquals;

public class BaseConditionsTest extends BaseConditions {

    @Test
    public void testBaseCondition5() {
        ArrayList<String> args1 = new ArrayList<>();
        args1.add("-host");
        args1.add("localhost");
        args1.add("-port");
        args1.add("8080");
        Assertions.assertTrue(BaseConditions.baseCondition5(args1));

        ArrayList<String> args2 = new ArrayList<>();
        args2.add("-host");
        args2.add("localhost");
        Assertions.assertFalse(BaseConditions.baseCondition5(args2));
    }

    @Test
    public void testBaseCondition12() {
        ArrayList<String> args1 = new ArrayList<>();
        args1.add("-host");
        args1.add("localhost");
        args1.add("-port");
        args1.add("8080");
        args1.add("-search");
        Assertions.assertTrue(BaseConditions.baseCondition12(args1));

        ArrayList<String> args2 = new ArrayList<>();
        args2.add("-host");
        args2.add("localhost");
        args2.add("-port");
        args2.add("8080");
        Assertions.assertFalse(BaseConditions.baseCondition12(args2));
    }

    @Test
    public void testBaseCondition13Print() {
        ArrayList<String> args = new ArrayList<>();
        args.add("-host");
        args.add("localhost");
        args.add("-port");
        args.add("8080");
        args.add("CustomerName");
        args.add("111-222-3333");
        args.add("444-555-6666");
        args.add("2023/03/24");
        args.add("10:30");
        args.add("AM");
        args.add("2023/03/24");
        args.add("11:00");
        args.add("AM");
        PhoneCall call = BaseConditions.baseCondition13Print(args);
        assertEquals("CustomerName", call.getCaller());
        assertEquals("111-222-3333", call.getCallerNumber());
        assertEquals("444-555-6666", call.getCalleeNumber());
        assertEquals("2023/03/24", call.getPhoneCallBeginDate());
        assertEquals("10:30 AM", call.getPhoneCallBeginTime());
        assertEquals("2023/03/24", call.getPhoneCallEndDate());
        assertEquals("11:00 AM", call.getPhoneCallEndTime());
    }

    @Test
    public void testBaseCondition14Print() {
        ArrayList<String> args = new ArrayList<>();
        args.add("-host");
        args.add("localhost");
        args.add("-port");
        args.add("8080");
        args.add("-print");
        args.add("CustomerName");
        args.add("111-222-3333");
        args.add("444-555-6666");
        args.add("2023/03/24");
        args.add("10:30");
        args.add("AM");
        args.add("2023/03/24");
        args.add("11:00");
        args.add("AM");
        PhoneCall call = BaseConditions.baseCondition14Print(args);
        assertEquals("CustomerName", call.getCaller());
        assertEquals("111-222-3333", call.getCallerNumber());
        assertEquals("444-555-6666", call.getCalleeNumber());
        assertEquals("2023/03/24", call.getPhoneCallBeginDate());
        assertEquals("10:30 AM", call.getPhoneCallBeginTime());
        assertEquals("2023/03/24", call.getPhoneCallEndDate());
        assertEquals("11:00 AM", call.getPhoneCallEndTime());
    }

}

