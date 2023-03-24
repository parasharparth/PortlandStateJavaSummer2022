package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneBill;
import java.util.ArrayList;

/*************************************************
 * This is a PhoneBill class
 * Customer being used to get customer from the main method
 * Arraylist for calls
 ************************************************/
public class  PhoneBill extends AbstractPhoneBill<PhoneCall> {

  private String customer;

  private final ArrayList<PhoneCall> calls = new ArrayList<>();

  /***********************************************************************************************
   * PhoneBill()--is a customer method used to define the specified customer
   * getCustomer() method is used to retrieve the customer details
   * setCustomer() method is used to set the customer details
   * addPhoneCall() method is used to add phone call to the phone bill
   * getPhoneCalls() collection manipulates the phone call to fetch the phone call details
   ***********************************************************************************************/


  public PhoneBill(String customer) {
     this.customer = customer;
  }

  @Override
  public String getCustomer() {
    return this.customer;
  }


  public String setCustomer(String customer){
    //return customer;
    return this.customer = customer;
  }

  @Override
  public void addPhoneCall(PhoneCall call) {
    this.calls.add(call);
  }


  @Override
  public ArrayList<PhoneCall> getPhoneCalls() {
    return calls;
  }
}
