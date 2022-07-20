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

  public PhoneCall() {

  }

  @Override
  public String getCaller() {
    return callerNumber;
  }


  @Override
  public String getCallee() {
    return calleeNumber;
  }

  @Override
  public String getBeginTimeString() {
    return phoneCallBeginTime;
  }

  @Override
  public String getEndTimeString() {
    //return phoneCallEndTime + " on " + phoneCallEndDate;
    return phoneCallEndTime;
  }


  public void setCallerName(String callerName) {
    this.callerName = callerName;
  }


  public void setCalleeName(String calleeName) {
    this.calleeName = calleeName;
  }


  public void setCallerNumber(String callerNumber) {
    this.callerNumber = callerNumber;
  }


  public void setCalleeNumber(String calleeNumber) {
    this.calleeNumber = calleeNumber;
  }


  public void setPhoneCallBeginDate(String phoneCallBeginDate) {
    this.phoneCallBeginDate = phoneCallBeginDate;
  }


  public void setPhoneCallBeginTime(String phoneCallBeginTime) {
    this.phoneCallBeginTime = phoneCallBeginTime;
  }


  public void setPhoneCallEndDate(String phoneCallEndDate) {
    this.phoneCallEndDate = phoneCallEndDate;
  }


  public void setPhoneCallEndTime(String phoneCallEndTime) {
    this.phoneCallEndTime = phoneCallEndTime;
  }
}


