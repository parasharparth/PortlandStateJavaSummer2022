package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link PhoneCall} class.
 *
 * You'll need to update these unit tests as you build out your program.
 */
public class PhoneCallTest {

  private String callerName1 = "JW";
  private String calleeName1 = "callee";
  private String callerNumber1 = "123-456-7890";
  private String calleeNumber1 = "234-567-8901";
  private String phoneCallBeginDate1 = "07/07/202";
  private String phoneCallBeginTime1 = "7:12";
  private String phoneCallEndDate1 = "07/07/202";
  private String phoneCallEndTime1 = "7:56";

  PhoneCall call = new PhoneCall(callerName1, callerNumber1, calleeNumber1, phoneCallBeginDate1,phoneCallBeginTime1, phoneCallEndDate1,phoneCallEndTime1);

  /**
   * This unit test will need to be modified (likely deleted) as you implement
   * your project.
   */

  @Test
  void getCallerIsImplemented() {
    assertThat(call.getCaller(), equalTo(callerName1));
  }

  @Test
  void getCalleeIsImplemented() {
    assertThat(call.getCallee(), equalTo(calleeName1));
  }
  @Test
  void getBeginTimeStringIsImplemented() {
    assertThat(call.getBeginTimeString(), equalTo(phoneCallBeginTime1));
  }

  @Test
  void getEndTimeStringIsImplemented() {
    assertThat(call.getEndTimeString(), equalTo(phoneCallEndTime1));
  }

  @Test
  void initiallyAllPhoneCallsHaveTheSameCallee() {
    assertThat(call.getCallee(), containsString(calleeName1));
  }

  @Test
  void forProject1ItIsOkayIfGetBeginTimeReturnsNull() {
    assertThat(call.getBeginTime(), is(nullValue()));
  }
  
}
