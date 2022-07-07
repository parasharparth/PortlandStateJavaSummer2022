package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {
  @Override
  public String getCaller() {
    return "No caller yet";
  }

  @Override
  public String getCallee() {
    return "This method is not implemented yet";
  }

  @Override
  public String getBeginTimeString() {
    return "Begin time";
  }

  @Override
  public String getEndTimeString() {
    return "End time";
  }
}
