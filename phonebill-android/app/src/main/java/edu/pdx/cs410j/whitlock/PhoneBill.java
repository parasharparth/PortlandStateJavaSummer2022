package edu.pdx.cs410j.whitlock;

import java.util.ArrayList;

import edu.pdx.cs410J.AbstractPhoneBill;

/**************************************************************
 * This class is represents a <code>PhoneBill</code>.
 * Customer being used to get customer from the main method
 * Arraylist for calls
 **************************************************************/
public class  PhoneBill extends AbstractPhoneBill<PhoneCall> {


    private String customer;


    private final ArrayList<PhoneCall> calls = new ArrayList<>();

    /********************************************************************************************************
     * PhoneBill() this is a customer method used to define the specified customer for the PhoneBill method
     * getCustomer() method is used to retrieve the customer details
     * setCustomer() method is used to set the customer details
     * addPhoneCall() method is used to add phone call to the phone bill
     * getPhoneCalls() collection manipulates the phone call to fetch the phone call details
     ********************************************************************************************************/
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
    } //

}
