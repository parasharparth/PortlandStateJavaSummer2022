package edu.pdx.cs410j.whitlock;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.pdx.cs410J.AbstractPhoneCall;

/******************************************************
 * This class is represents a <code>PhoneCall</code>.
 * Defines the details specified in a call
 * Defines the date specified in a call
 ******************************************************/
public class PhoneCall extends AbstractPhoneCall implements Comparable<PhoneCall> {

    String callerNumber, calleeNumber, phoneCallBeginDate, phoneCallEndDate, callerName;

    Date phoneCallBeginTime, phoneCallEndTime;

    /**********************************************************************************
     * PhoneCall method to specify the phone call
     * PhoneCall constructor to specify the phone call
     * getCaller() method is used to retrieve the caller details
     * getCallee() method is used to retrieve the caller details
     * getBeginTimeString() method is used to retrieve the caller details
     * getEndTimeString() method is used to retrieve the caller details
     * setCallerName() method is used to set phone call to the phone bill
     * setCallerNumber() method is used to set phone call to the phone bill
     * calleeNumber() method is used to set phone call to the phone bill
     * setPhoneCallBeginTime() method is used to set phone call to the phone bill
     * setPhoneCallBeginDate() self defined
     * setPhoneCallEndTime() method is used to set phone call to the phone bill
     * setPhoneCallEndDate() method is self defined
     * getCallerNumber() method is self defined
     * getCalleeNumber() method is self defined
     * getPhoneCallBeginDate() method is self defined
     * getPhoneCallBeginTime() method is self defined
     * getPhoneCallEndDate() method is self defined
     * getPhoneCallEndTime() method is self defined
     * compareTo() Defines the comparable for Phonecall
     * chkEndAfterStart() Verifies end time is greater than start time
     * ******************************************************************************/
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

        String timestring = formatter.getTimeInstance(DateFormat.SHORT).format(phoneCallBeginTime);
        return phoneCallBeginDate + " " + timestring;
    }


    @Override
    public String getEndTimeString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
        String timestring = formatter.getTimeInstance(DateFormat.SHORT).format(this.phoneCallEndTime);
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

//  public String getCallerName() {
//    return callerName;
//  }


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
    }


    public boolean chkEndAfterStart(){
        return getBeginTime().before(getEndTime());
    }

}



