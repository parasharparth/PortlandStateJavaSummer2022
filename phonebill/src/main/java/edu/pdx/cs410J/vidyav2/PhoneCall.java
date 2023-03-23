package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneCall;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/************************************************
 * This is a PhoneCall class extended by AbstractPhoneCall
 * and implements Comparable
 ************************************************/
public class PhoneCall extends AbstractPhoneCall implements Comparable<PhoneCall> {
  /************************************************
   * Defines the details specified in a call
   ************************************************/
  String callerNumber, calleeNumber, phoneCallBeginDate, phoneCallEndDate, callerName;
  /************************************************
   * Defines the date specified in a call
   ************************************************/
  Date phoneCallBeginTime, phoneCallEndTime;

  /***********************************************
  * PhoneCall method to specify the phone call
   * *********************************************/
  public PhoneCall() {}

  /*******
   * PhoneCall constructor to specify the phone call
   * @param calleeNumber  callee number is called
   * @param callerName caller name id called
   * @param callerNumber caller number id called
   * @param phoneCallBeginDate call begin date
   * @param phoneCallBeginTime call begin time
   * @param phoneCallEndDate call end date
   * @param phoneCallEndTime call end time
   * *******/
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

  /** getCaller() method is used to retrieve the caller details **/
  @Override
  public String getCaller() {
    return callerNumber;
  }

  /** getCallee() method is used to retrieve the caller details **/
  @Override
  public String getCallee() {
    return calleeNumber;
  }

  /** getBeginTimeString() method is used to retrieve the caller details **/
  @Override
  public String getBeginTimeString() {
    new SimpleDateFormat("MM/dd/yyyy hh:mm aa", Locale.US);

    String timestring = DateFormat.getTimeInstance(DateFormat.SHORT).format(phoneCallBeginTime);
    return phoneCallBeginDate + " " + timestring;
  }

  /** getEndTimeString() method is used to retrieve the caller details **/
  @Override
  public String getEndTimeString() {
    new SimpleDateFormat("MM/dd/yyyy hh:mm aa", Locale.US);
   String timestring = DateFormat.getTimeInstance(DateFormat.SHORT).format(this.phoneCallEndTime);
  return phoneCallEndDate + " " + timestring;
  }

  /********************
   * setCallerName() method is used to set phone call to the phone bill
   * @param callerName defines the caller name
   *********************/
  public void setCallerName(String callerName) {
    this.callerName = callerName;
  }

  /********************
   * setCallerNumber() method is used to set phone call to the phone bill
   * @param callerNumber defines the caller number
   *********************/
  public void setCallerNumber(String callerNumber) {
    this.callerNumber = callerNumber; }

  /********************
   * calleeNumber() method is used to set phone call to the phone bill
   * @param calleeNumber defines the caller number
   *********************/
  public void setCalleeNumber(String calleeNumber) { this.calleeNumber = calleeNumber;}

  /********************
   * setPhoneCallBeginTime() method is used to set phone call to the phone bill
   * @param phoneCallBeginDate defines call begin date
   * @param phoneCallBeginTime defines call begin time
   * @param AMPM defines am, pm
   *********************/
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

  /********************
   * setPhoneCallBeginDate() self defined
   * @param phoneCallBeginDate self defined
   *********************/
  public void setPhoneCallBeginDate(String phoneCallBeginDate) {
    this.phoneCallBeginDate = phoneCallBeginDate;
  }

  /********************
   * setPhoneCallEndTime() method is used to set phone call to the phone bill
   * @param phoneCallEndDate defines call end date
   * @param phoneCallEndTime defines call end time
   * @param AMPM defines am, pm
   *********************/
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

  /********************
   * setPhoneCallEndDate() method is self defined
   * @param phoneCallEndDate defines call end date
   *********************/
  public void setPhoneCallEndDate(String phoneCallEndDate) {
    this.phoneCallEndDate = phoneCallEndDate;
  }

  /********************
   * getPhoneCallBeginDate() method is self defined
   * @return phoneCallBeginDate
   *********************/
  public String getPhoneCallBeginDate() {
    return phoneCallBeginDate;
  }

  /********************
   * getPhoneCallBeginTime() method is self defined
   * @return phoneCallBeginTime
   *********************/
  public Date getPhoneCallBeginTime() {
    return this.phoneCallBeginTime;
  }

  /********************
   * getPhoneCallEndDate() method is self defined
   * @return phoneCallEndDate
   *********************/
  public String getPhoneCallEndDate() {
    return phoneCallEndDate;
  }

  /********************
   * getPhoneCallEndTime() method is self defined
   * @return phoneCallEndTime
   *********************/
  public Date getPhoneCallEndTime() {
    return this.phoneCallEndTime;
  }

  /** Defines the comparable for Phonecall
   * @param o the object to be compared.
   */
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



