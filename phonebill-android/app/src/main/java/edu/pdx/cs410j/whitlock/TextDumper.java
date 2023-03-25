package edu.pdx.cs410j.whitlock;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import edu.pdx.cs410J.PhoneBillDumper;

/***************************************************
 * Name of the file to dump the phone bill data to
 * Directory to save the dumped file
 ***************************************************/
public class TextDumper implements PhoneBillDumper<PhoneBill> {

    String filename;
    File dir;

    /*******************************************************************************************************
     * Constructor that initializes the directory and filename
     * Retrieve the list of phone calls from the PhoneBill object
     * Create an array of strings to store the string representation of each phone call
     * Create a PrintWriter to write the phone bill data to the output file
     * Write the name of the customer to the output file
     * Iterate through the list of phone calls and add the string representation of each call to the array
     * Close the PrintWriter
     *******************************************************************************************************/

    public TextDumper(File directory, String nameoffile) {
        this.dir = directory;
        this.filename = nameoffile;
    }

    @Override
    public void dump(PhoneBill bill) throws IOException {
        ArrayList<PhoneCall> phonecallList = bill.getPhoneCalls();
        String[] calls = new String[phonecallList.size()];
        PrintWriter out = new PrintWriter(new File(dir, filename));
        out.write("");
        out.write(bill.getCustomer());
        Collections.sort(phonecallList);
        for (int i = 0; i < phonecallList.size(); i++) {
            calls[i] = phonecallList.get(i).toString();
            out.write("\n");
            out.write(calls[i]);
        }
        out.close();
    }
}


