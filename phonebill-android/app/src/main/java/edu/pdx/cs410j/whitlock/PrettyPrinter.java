package edu.pdx.cs410j.whitlock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import edu.pdx.cs410J.PhoneBillDumper;

/*************************************************************************************************************
 * Defines a class named PrettyPrinter that implements the PhoneBillDumper interface for the PhoneBill class.
 *************************************************************************************************************/
public class PrettyPrinter implements PhoneBillDumper<PhoneBill> {

    /*******************************************************************************************************************
     * This method formats the phone-bill in a pretty way
     * Compute the duration of the phone call in milliseconds
     * Construct a string with the formatted phone call information
     * Return the string containing the formatted phone call information
     * dump() This method does nothing since there is no requirement to dump an entire phone bill in a pretty way
     *******************************************************************************************************************/
    public String getpretty(PhoneCall call, String customer) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        long callDuration = call.getPhoneCallEndTime().getTime() - call.getPhoneCallBeginTime().getTime();
        String prettytext = "Customer : " + customer +
                "\nCallerNumber : " + call.getCallerNumber() +
                "\nCalleeNumber : " + call.getCalleeNumber() +
                "\nDate of Begin : " + call.getPhoneCallBeginDate() +
                "\nTime of Begin : " + formatter.getTimeInstance(DateFormat.SHORT).format(call.getPhoneCallBeginTime()) +
                "\nDate of End : " + call.getPhoneCallEndDate() +
                "\nTime of End : " + formatter.getTimeInstance(DateFormat.SHORT).format(call.getPhoneCallEndTime()) +
                "\nDuration (minutes) : " + TimeUnit.MILLISECONDS.toMinutes(callDuration) + "\n\n";
        return prettytext;
    }

    @Override
    public void dump(PhoneBill bill) {
    }
}