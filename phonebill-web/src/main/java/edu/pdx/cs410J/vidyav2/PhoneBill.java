package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.AbstractPhoneBill;
import java.util.ArrayList;
import java.util.Collection;

/************************************************
 * @project PortlandStateJavaSummer2022
 * @class PhoneBill
 ************************************************/
public class  PhoneBill extends AbstractPhoneBill<PhoneCall> {

  /**********************************************************
   * Customer being used to get customer from the main method
   **********************************************************/
  private String customer;

  /*************************
   *Arraylist for calls
   *************************/

  private final ArrayList<PhoneCall> calls = new ArrayList<>();

  /********************
   * @param customer
   ********************/
  public PhoneBill(String customer) {
     this.customer = customer;
  }

  /********************
   * getCustomer() method is used to retrieve the customer details
  *********************/

  @Override
  public String getCustomer() {
    return this.customer;
  }

  /********************
   * setCustomer() method is used to set the customer details
   * @param customer
   *********************/
  public String setCustomer(String customer){
    return this.customer = customer;
    //return customer;
  }

  /********************
   * addPhoneCall() method is used to add phone call to the phone bill
   * @param call
   *********************/
  @Override
  public void addPhoneCall(PhoneCall call) {
    this.calls.add(call);
  }

  /********************
   * getPhoneCalls() collection manipulates the phone call to fetch the phone call details
   *********************/
  @Override
  public Collection<PhoneCall> getPhoneCalls() {
    return calls;
  }
}
