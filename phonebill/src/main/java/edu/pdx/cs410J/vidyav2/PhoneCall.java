package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneCall;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhoneCall extends AbstractPhoneCall implements Comparable<PhoneCall> {
//implements Comparable<PhoneCall>
  String callerNumber;
  String calleeNumber;
  String phoneCallBeginDate;
  String phoneCallEndDate;
  String callerName;
  Date phoneCallBeginTime;
  Date phoneCallEndTime ;

    public PhoneCall() {}
  //SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");

  PhoneCall(String callerName, String callerNumber, String calleeNumber, String phoneCallBeginDate,
                   Date phoneCallBeginTime, String phoneCallEndDate, Date phoneCallEndTime) {
    this.callerName = callerName;
    this.callerNumber = callerNumber;
    this.calleeNumber = calleeNumber;
    this.phoneCallBeginDate = phoneCallBeginDate;
    this.phoneCallBeginTime = phoneCallBeginTime;
    this.phoneCallEndDate = phoneCallEndDate;
    this.phoneCallEndTime = phoneCallEndTime;
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
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
    SimpleDateFormat dater = new SimpleDateFormat("MM/dd/yyyy");

    String timestring = formatter.getTimeInstance(DateFormat.SHORT).format(phoneCallBeginTime);
    return phoneCallBeginDate + " " + timestring;
    //return dater.format(this.phoneCallBeginTime);
  }

  @Override
  public String getEndTimeString() {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
    SimpleDateFormat dater = new SimpleDateFormat("MM/dd/yyyy");
//    String datestring = dater.format(this.phoneCallEndDate);
   String timestring = formatter.getTimeInstance(DateFormat.SHORT).format(this.phoneCallEndTime);
  return phoneCallEndDate + " " + timestring;
    //return phoneCallEndDate;
  }

  public void setCallerName(String callerName) {
    this.callerName = callerName;
  }


  public void setCallerNumber(String callerNumber) {
    this.callerNumber = callerNumber; }

  public void setCalleeNumber(String calleeNumber) { this.calleeNumber = calleeNumber;}


  public void setPhoneCallBeginTime(String phoneCallBeginDate, String phoneCallBeginTime, String AMPM) {
    String finaldatetime = phoneCallBeginDate + " " + phoneCallBeginTime + " " + AMPM;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
    try{
      //this.phoneCallBeginTime = String.valueOf(formatter.parse(finaldatetime));
     this.phoneCallBeginTime = formatter.parse(finaldatetime);
    }
    catch (Exception e){
      System.err.println("Please verify the format for date and time.");
      System.exit(1);
    }
  }


  public void setPhoneCallBeginDate(String phoneCallBeginDate) {
    this.phoneCallBeginDate = phoneCallBeginDate;
  }


  public void setPhoneCallEndTime(String phoneCallEndDate, String phoneCallEndTime, String AMPM) {
    String finaldatetime1 = phoneCallEndDate + " " + phoneCallEndTime + " " + AMPM;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
    try{
      //this.phoneCallEndTime = String.valueOf(formatter.parse(finaldatetime1));
      this.phoneCallEndTime = formatter.parse(finaldatetime1);
    }
    catch (Exception e){
      System.err.println("Please verify the format for date and time.");
      System.exit(1);
    }
  }

  //This method ensures that call begin time is before call end time
//  public boolean checkBeginTimeBeforeEndTime(){
//    return this.phoneCallBeginTime.compareTo(this.phoneCallEndTime) <= 0;
//  }

  public void setPhoneCallEndDate(String phoneCallEndDate) {
    this.phoneCallEndDate = phoneCallEndDate;
  }

  public String getCallerName() {
    return callerName;
  }

  public String getCallerNumber() {
    return callerNumber;
  }

  public String getCalleeNumber() {
    return calleeNumber;
  }

  public String getPhoneCallBeginDate() {
    return phoneCallBeginDate;
  }

  public Date getPhoneCallBeginTime() {
    return this.phoneCallBeginTime;
  }

  public String getPhoneCallEndDate() {
    return phoneCallEndDate;
  }

  public Date getPhoneCallEndTime() {
    return this.phoneCallEndTime;
  }

  /**
   * @param o the object to be compared.
   * @return
   */
  public int compareTo(PhoneCall o) {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
    //if(this.getCallee().compareToIgnoreCase(o.getCallee()) == 0){
      try {
        Date d1 = formatter.parse(this.getBeginTimeString());
        Date d2 = formatter.parse(o.getBeginTimeString());
        return d1.compareTo(d2);
      } catch (ParseException e) {
        e.printStackTrace();
        System.exit(1);
      }
    return this.getCallee().compareToIgnoreCase(o.getCallee());
  }}



