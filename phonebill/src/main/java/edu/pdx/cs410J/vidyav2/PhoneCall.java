package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {

  String callerName;
  String calleeName = "callee";
  String callerNumber;
  String calleeNumber;
  String phoneCallBeginDate;
  String phoneCallBeginTime;
  String phoneCallEndDate;
  String phoneCallEndTime;

  PhoneCall(String callerName, String callerNumber, String calleeNumber, String phoneCallBeginDate, String phoneCallBeginTime, String phoneCallEndDate, String phoneCallEndTime){
    this.callerName = callerName;
    this.calleeName = calleeName;
    this.callerNumber = callerNumber;
    this.calleeNumber = calleeNumber;
    this.phoneCallBeginDate = phoneCallBeginDate;
    this.phoneCallBeginTime = phoneCallBeginTime;
    this.phoneCallEndDate = phoneCallEndDate;
    this.phoneCallEndTime = phoneCallEndTime;
  }

  //public PhoneCall(String customerName, String numberOfCaller, String numberOfCallee, String dateOfPhoneCallStart, String timeOfPhoneCallStart, String dateOfPhoneCallEnd, String timeOfPhoneCallEnd) {
  //}


  @Override
  public String getCaller() {
    return callerName;
  }

  @Override
  public String getCallee() {
    return calleeName;
  }

  @Override
  public String getBeginTimeString() {
    return phoneCallBeginTime;
  }

  @Override
  public String getEndTimeString() {
    return phoneCallEndTime;
  }
}
