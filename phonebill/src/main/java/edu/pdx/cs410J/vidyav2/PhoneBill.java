package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.util.ArrayList;
import java.util.Collection;

public class  PhoneBill extends AbstractPhoneBill<PhoneCall> {
  private String customer;

  private final ArrayList<PhoneCall> calls = new ArrayList();

  public PhoneBill(String customer) {
    this.customer = customer;
  }

//  public PhoneBill() {
//
//  }

  @Override
  public String getCustomer() {
    return this.customer;
  }

  public String setCustomer(String phoneBill){
    return this.customer = phoneBill;
  }

  @Override
  public void addPhoneCall(PhoneCall call) {
    this.calls.add(call);
  }

  @Override
  public Collection<PhoneCall> getPhoneCalls() {
    return calls;
  }

  public Object getBytes() {
    return null;
  }

  public PhoneBill get(int i) {
    return null;
  }
}
