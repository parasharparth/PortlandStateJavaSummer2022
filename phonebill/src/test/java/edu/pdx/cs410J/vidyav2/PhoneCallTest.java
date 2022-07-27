package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link PhoneCall} class.
 *
 * You'll need to update these unit tests as you build out your program.
 */
public class PhoneCallTest {

    String callerNumber = "123-777-9997";
    String calleeNumber = "888-998-9999";


    Date phoneCallBeginTime = new Date("07/07/2021 08:00PM"), phoneCallEndTime = new Date("08/07/2021");
    String callerName = "Bhaskar";
    String phoneCallBeginDate;
    String phoneCallEndDate;

  PhoneCall call = new PhoneCall(callerName, callerNumber, calleeNumber, phoneCallBeginDate,phoneCallBeginTime, phoneCallEndDate,phoneCallEndTime);

  /**
   * This unit test will need to be modified (likely deleted) as you implement
   * your project.
   */

//  @Test
//  void getCallerIsImplemented() {
//    assertThat(call.getCaller(), equalTo(callerNumber));
//  }
//
//  @Test
//  void getCalleeIsImplemented() {
//    assertThat(call.getCallee(), equalTo(calleeNumber));
//  }
//  @Test
//  void getBeginTimeStringIsImplemented() {
//    assertThat(call.getBeginTimeString(), equalTo(phoneCallBeginTime));
//  }
//
//  @Test
//  void getEndTimeStringIsImplemented() {
//    assertThat(call.getEndTimeString(), equalTo(phoneCallEndTime));
//  }
//
//  @Test
//  void initiallyAllPhoneCallsHaveTheSameCallee() {
//    assertThat(call.getCallee(), equalTo(calleeNumber));
//  }
//
//  @Test
//  void forProject1ItIsOkayIfGetBeginTimeReturnsNull() {
//    assertThat(call.getBeginTime(), is(nullValue()));
//  }
}
