package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.CoreMatchers.*;


public class PhoneBillTest {
    private String callerName1 = "JW";
    private String calleeName1 = "callee";
    private String callerNumber1 = "123-456-7890";
    private String calleeNumber1 = "234-567-8901";
    private String phoneCallBeginDate1 = "07/07/202";
    private String phoneCallBeginTime1 = "7:12";
    private String phoneCallEndDate1 = "07/07/202";
    private String phoneCallEndTime1 = "7:56";

    PhoneCall call = new PhoneCall(callerName1, callerNumber1, calleeNumber1, phoneCallBeginDate1,phoneCallBeginTime1, phoneCallEndDate1,phoneCallEndTime1);

    PhoneBill bill = new PhoneBill(call.getCaller());

    @Test
    void getCustomerIsImplemented(){
        assertThat(bill.getCustomer(), equalTo(callerName1));
    }

    @Test
    void getPhoneCallIsImplemented(){
        bill.addPhoneCall(call);
        assertThat(bill.getPhoneCalls().toString(), containsString(calleeName1));
    }



}
