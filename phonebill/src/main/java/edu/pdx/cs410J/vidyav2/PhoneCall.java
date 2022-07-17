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

  /*public String getBeginDateString() {
    return phoneCallBeginDate;
  }

  public String getEndDateString() {
    return phoneCallEndDate;
  }*/

  public String getCallerName() {
    return callerName;
  }

  public void setCallerName(String callerName) {
    this.callerName = callerName;
  }

  public String getCalleeName() {
    return calleeName;
  }

  public void setCalleeName(String calleeName) {
    this.calleeName = calleeName;
  }

  public String getCallerNumber() {
    return callerNumber;
  }

  public void setCallerNumber(String callerNumber) {
    this.callerNumber = callerNumber;
  }

  public String getCalleeNumber() {
    return calleeNumber;
  }

  public void setCalleeNumber(String calleeNumber) {
    this.calleeNumber = calleeNumber;
  }

  public String getPhoneCallBeginDate() {
    return phoneCallBeginDate;
  }

  public void setPhoneCallBeginDate(String phoneCallBeginDate) {
    this.phoneCallBeginDate = phoneCallBeginDate;
  }

  public String getPhoneCallBeginTime() {
    return phoneCallBeginTime;
  }

  public void setPhoneCallBeginTime(String phoneCallBeginTime) {
    this.phoneCallBeginTime = phoneCallBeginTime;
  }

  public String getPhoneCallEndDate() {
    return phoneCallEndDate;
  }

  public void setPhoneCallEndDate(String phoneCallEndDate) {
    this.phoneCallEndDate = phoneCallEndDate;
  }

  public String getPhoneCallEndTime() {
    return phoneCallEndTime;
  }

  public void setPhoneCallEndTime(String phoneCallEndTime) {
    this.phoneCallEndTime = phoneCallEndTime;
  }
}


