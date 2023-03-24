package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneCall;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/************************************************************************************
 * This is a PhoneCall class extended by AbstractPhoneCall and implements Comparable
 * Defines the details and date specified in a call
 ************************************************************************************/
public class PhoneCall extends AbstractPhoneCall implements Comparable<PhoneCall> {

  String callerNumber, calleeNumber, phoneCallBeginDate, phoneCallEndDate, callerName;
  Date phoneCallBeginTime, phoneCallEndTime;

  /**************************************************************************************
   * PhoneCall method to specify the phone call
   * PhoneCall constructor to specify the phone call
   * calleeNumber--callee number is called
   * callerName--caller name id called
   * callerNumber--caller number id called
   * phoneCallBeginDate--call begin date
   * phoneCallBeginTime--call begin time
   * phoneCallEndDate--call end date
   * phoneCallEndTime--call end time
   * getCaller() method is used to retrieve the caller details
   * getCallee() method is used to retrieve the caller details
   * getBeginTimeString() method is used to retrieve the caller details
   * getEndTimeString() method is used to retrieve the caller details
   * setCallerName() method is used to set phone call to the phone bill
   * callerName defines the caller name
   * setCallerNumber() method is used to set phone call to the phone bill
   * callerNumber--defines the caller number
   * calleeNumber() method is used to set phone call to the phone bill
   * calleeNumber--defines the caller number
   * setPhoneCallBeginTime() method is used to set phone call to the phone bill
   * phoneCallBeginDate--defines call begin date
   * phoneCallBeginTime--defines call begin time
   * AMPM--defines am, pm
   * setPhoneCallBeginDate() self defined
   * phoneCallBeginDate--self defined
   * setPhoneCallEndTime() method is used to set phone call to the phone bill
   * phoneCallEndDate--defines call end date
   * phoneCallEndTime--defines call end time
   * setPhoneCallEndDate() method is self defined
   * phoneCallEndDate--defines call end date
   * getPhoneCallBeginDate() method is self defined
   * getPhoneCallBeginTime() method is self defined
   * getPhoneCallEndDate() method is self defined
   * getPhoneCallEndTime() method is self defined
   * compareTo()--Defines the comparable for PhoneCall
   * o the object to be compared.
   *****************************************************************************************/

  public PhoneCall() {}

  PhoneCall(String callerName, String callerNumber, String calleeNumber, String phoneCallBeginDate,
                  Date phoneCallBeginTime, String phoneCallEndDate, Date phoneCallEndTime){
    this.callerName = callerName;
    this.callerNumber = callerNumber;
    this.calleeNumber = calleeNumber;
    this.phoneCallBeginDate = phoneCallBeginDate;
    this.phoneCallBeginTime = phoneCallBeginTime;
    this.phoneCallEndDate = phoneCallEndDate;
    this.phoneCallEndTime = phoneCallEndTime;
  }

  public PhoneCall(String custName, String noOfCaller, String noOfCallee, String dateOfPhoneCallBegin, String timeOfPhoneCallBegin, String dateOfPhoneCallEnd, String timeOfPhoneCallEnd) {
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
    new SimpleDateFormat("MM/dd/yyyy hh:mm aa", Locale.US);

    String timestring = DateFormat.getTimeInstance(DateFormat.SHORT).format(phoneCallBeginTime);
    return phoneCallBeginDate + " " + timestring;
  }


  @Override
  public String getEndTimeString() {
    new SimpleDateFormat("MM/dd/yyyy hh:mm aa", Locale.US);
   String timestring = DateFormat.getTimeInstance(DateFormat.SHORT).format(this.phoneCallEndTime);
  return phoneCallEndDate + " " + timestring;
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
      this.phoneCallEndTime = formatter.parse(finaldatetime1);
    }
    catch (Exception e){
      System.err.println("Please verify the format for date and time.");
      System.exit(1);
    }
  }


  public void setPhoneCallEndDate(String phoneCallEndDate) {
    this.phoneCallEndDate = phoneCallEndDate;
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


  public int compareTo(PhoneCall o) {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
      try {
        Date d1 = formatter.parse(this.getBeginTimeString());
        Date d2 = formatter.parse(o.getBeginTimeString());
        return d1.compareTo(d2);
      } catch (ParseException e) {
        e.printStackTrace();
        System.exit(1);
      }
    return this.getCallee().compareToIgnoreCase(o.getCallee());
  }
}



