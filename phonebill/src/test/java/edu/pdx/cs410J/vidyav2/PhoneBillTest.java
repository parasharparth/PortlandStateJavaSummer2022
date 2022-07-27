package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * PhoneBillTest class defines the tests written explicitly to understand the working of Phone Bill
 */
public class PhoneBillTest {
    String callerNumber = "123-777-9997";
    String calleeNumber = "888-998-9999";

    String phoneCallBeginDate = "07/07/2021";
    String phoneCallEndDate = "08/07/2021";
    String callerName = "Bhaskar";
    Date phoneCallBeginTime= new Date("07/07/2021 08:00PM");
    Date phoneCallEndTime= new Date("07/07/2021 09:00PM");

    PhoneCall call = new PhoneCall(callerName, callerNumber, calleeNumber, phoneCallBeginDate,phoneCallBeginTime, phoneCallEndDate,phoneCallEndTime);

    PhoneBill bill = new PhoneBill(call.getCaller());


    /**
     * getCustomerIsImplemented() defines the implementation of getCustomer
     */
//    @Test
//    void getCustomerIsImplemented(){
//        assertThat(bill.getCustomer(), callerName);
//    }
//
//    /**
//     * getPhoneCallIsImplemented() defines the implementation of getPhoneCall
//     */
//    @Test
//    void getPhoneCallIsImplemented(){
//        bill.addPhoneCall(call);
//        assertThat(bill.getPhoneCalls().toString(), callerNumber);
//    }
//
//    public void assertThat(String toString, String callerNumber) {}

}
