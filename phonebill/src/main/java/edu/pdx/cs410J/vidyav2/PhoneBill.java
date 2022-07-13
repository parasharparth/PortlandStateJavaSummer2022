package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.ArrayList;
import java.util.Collection;

public class  PhoneBill extends AbstractPhoneBill<PhoneCall> {
  private final String customer;

  private final ArrayList<PhoneCall> calls = new ArrayList();

  public PhoneBill(String customer) {
    this.customer = customer;
  }

    @Override
  public String getCustomer() {
      return this.customer;
  }

  @Override
  public void addPhoneCall(PhoneCall call) {
    this.calls.add(call);
  }

  @Override
  public Collection<PhoneCall> getPhoneCalls() {
    return calls;
  }
}
