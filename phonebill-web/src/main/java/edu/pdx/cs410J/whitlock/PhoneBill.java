package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractPhoneBill;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
    private PhoneCall call;

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

    @Override
    public void addPhoneCall(PhoneCall phoneCall) {
        
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
     *********************/
    public void addPhoneCall() {
        this.calls.add(call);
    }

    /********************
     * getPhoneCalls() collection manipulates the phone call to fetch the phone call details
     *********************/
    @Override
    public Collection<PhoneCall> getPhoneCalls() {
        Collections.sort(calls);
        return calls;
    }
}