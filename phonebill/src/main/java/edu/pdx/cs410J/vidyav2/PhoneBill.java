package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractPhoneBill;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/************************************************
 * This is a PhoneBill class
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
   * @param customer this is a customer method used to define the specified customer
   * for the PhoneBill method
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
   * @param customer this is a customer method used to define the specified customer
   * for the PhoneBill method
   * @return return the customer data
   *********************/
  public String setCustomer(String customer){
    //return customer;
    return this.customer = customer;
  }

  /********************
   * addPhoneCall() method is used to add phone call to the phone bill
   * @param call this is a call method used to define the calls printed in a PhoneBill
   *********************/
  @Override
  public void addPhoneCall(PhoneCall call) {
    this.calls.add(call);
  }

  /********************
   * getPhoneCalls() collection manipulates the phone call to fetch the phone call details
   *********************/
  @Override
  public ArrayList<PhoneCall> getPhoneCalls() {
    return calls;
  }

}
