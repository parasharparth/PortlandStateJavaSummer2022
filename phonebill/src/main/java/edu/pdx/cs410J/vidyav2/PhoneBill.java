package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The class for the CS410J phonebill Project
 */
//This is Phonebill
public class  PhoneBill extends AbstractPhoneBill<PhoneCall> {
  private String customer;

  //Arraylist for calls
  private final ArrayList<PhoneCall> calls = new ArrayList<>();


  /*
   *  this is Phonebill method
   */
  public PhoneBill(String customer) {
     this.customer = customer;
  }


  /*
   * Customer will be initiated
   */
  //getCustomer method
  @Override
  public String getCustomer() {
    return this.customer;
  }

  /*
   * Customer will be set here
   */
  //setCustomer method
  public String setCustomer(String customer){
    return this.customer = customer;
    //return customer;
  }

  /*
   * phonecall will be initiated
   */
  //addPhoneCall method
  @Override
  public void addPhoneCall(PhoneCall call) {
    this.calls.add(call);
  }

  //getPhoneCalls collection
  @Override
  public Collection<PhoneCall> getPhoneCalls() {
    return calls;
  }
}
