package edu.pdx.cs410j.whitlock;

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {
    @Override
    public String getCaller() {
        return "123-555-9887";
    }

    @Override
    public String getCallee() {
        return "323-626-7675";
    }

    @Override
    public String getBeginTimeString() {
        return "1/1/2022 10:00 AM";
    }

    @Override
    public String getEndTimeString() {
        return "1/1/2022 11:00 AM";
    }
}
