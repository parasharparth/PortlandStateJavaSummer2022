package edu.pdx.cs410j.whitlock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import edu.pdx.cs410J.PhoneBillDumper;

public class PrettyPrinter implements PhoneBillDumper<PhoneBill> {
    /**
     * This method formats the phone-bill in a pretty way
     */
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

        //Return pretty print
        return prettytext;
    }

    @Override
    public void dump(PhoneBill bill) {
    }
}