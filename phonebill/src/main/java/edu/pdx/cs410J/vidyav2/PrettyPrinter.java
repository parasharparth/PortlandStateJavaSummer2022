package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.PhoneBillDumper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.*;

/***************************************************************************************************************************************************
 * This class implements the PhoneBillDumper interface to provide a mechanism for pretty printing a PhoneBill object to a file or standard output.
 ***************************************************************************************************************************************************/
public class PrettyPrinter implements PhoneBillDumper<PhoneBill> {
    String fileName;
    String customerName;

    /***********************************************************************************************************************************************
     * setCustomerName() Sets the customer name.
     * setFilename() Sets the name of the file to dump the phone bill to.
     * getPretty() Method to return a pretty string representation of a phone call
     * dump() method in the PrettyPrinter class, which is responsible for writing the phone bill information to a file in a "pretty" format.
     * If fileName is equal to "-", the output is printed to the console using the getPretty() method to format each PhoneCall object in the list.
     * If fileName is not equal to "-", the method attempts to open the specified file for writing using a Scanner object.
     ************************************************************************************************************************************************/

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public void setFilename(String fileName)
    {
        this.fileName = fileName;
    }

    public String getPretty(PhoneCall call, String customer) {
        long callDuration = call.getPhoneCallEndTime().getTime() - call.getPhoneCallBeginTime().getTime();
        return "Customer : " + customer +
                "\nCallerNumber : " + call.getCaller() +
                "\nCalleeNumber : " + call.getCallee() +
                "\nDate of Begin : " + call.getPhoneCallBeginDate() +
                "\nTime of Begin : " + DateFormat.getTimeInstance(DateFormat.SHORT).format(call.getPhoneCallBeginTime()) +
                "\nDate of End : " + call.getPhoneCallEndDate() +
                "\nTime of End : " + DateFormat.getTimeInstance(DateFormat.SHORT).format(call.getPhoneCallEndTime()) +
                "\nDuration (minutes) : " + TimeUnit.MILLISECONDS.toMinutes(callDuration) + "\n\n";
    }

    @Override
    public void dump(PhoneBill bill) {
        ArrayList<PhoneCall> phonecallList = bill.getPhoneCalls();
        sort(phonecallList);
        Scanner sc = null;
        if (fileName.equals("-")) {
            for (PhoneCall phoneCall : phonecallList) {
                System.out.println("\nThis is a pretty file, printing the following Phone details:\n"
                        + getPretty(phoneCall, bill.getCustomer()));//getPretty(call, bill.getCustomer()));

            }
            System.exit(0);
        }
        try {
            sc = new Scanner(new File(this.fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Pretty Print file with given name does not exist. File created.");
            PrintWriter out = null;
            if (!this.fileName.contains("/")) {
                try{
                    out = new PrintWriter(this.fileName);
                } catch (FileNotFoundException ex) {
                    System.out.println("Pretty Print file is not present.");
                }
                assert out != null;
                out.write("");
                for (PhoneCall phoneCall : phonecallList) {
                    String x = getPretty(phoneCall, bill.getCustomer());
                    out.write(x);
                }
                out.close();
            }
            else {
                File f;
                File f1;
                String v;
                boolean bool;
                f = new File(this.fileName);
                f1 = f.getParentFile();
                v = f1.getAbsolutePath();
                bool = f1.exists();
                if (bool) {
                    try {
                        out = new PrintWriter(this.fileName);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    assert out != null;
                    out.write("");
                    for (PhoneCall phoneCall : phonecallList) {
                        String x = getPretty(phoneCall, bill.getCustomer());
                        out.write(x);
                    }
                    out.close();
                } else {
                    File folder = new File(v);
                    if (folder.mkdir()) {
                        try {
                            out = new PrintWriter(this.fileName);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        assert out != null;
                        out.write("");
                        for (PhoneCall phoneCall : phonecallList) {
                            String x = getPretty(phoneCall, bill.getCustomer());
                            out.write(x);
                        }
                        out.close();
                    } else {
                        System.out.println("Could not create directory");
                        System.exit(1);
                    }
                }
            }

        }
        {
            PrintWriter out = null;
            if (!this.fileName.contains("/")) {
                try {
                    out = new PrintWriter(this.fileName);
                } catch (FileNotFoundException ex) {
                    System.err.println("Pretty Print file is not present.");
                }
                assert out != null;
                out.write("");
                for (PhoneCall phoneCall : phonecallList) {
                    String x = getPretty(phoneCall, bill.getCustomer());
                    out.write(x);
                }
                out.close();
            } else {
                File f ;
                File f1 ;
                String v;
                boolean bool;
                f = new File(this.fileName);
                f1 = f.getParentFile();
                v = f1.getAbsolutePath();
                bool = f1.exists();
                //check if directory exists or not
                if (bool) {
                    try {
                        out = new PrintWriter(this.fileName);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    assert out != null;
                    out.write("");
                    for (PhoneCall o : phonecallList) {
                        String x = getPretty(o, bill.getCustomer());
                        out.write(x);
                    }
                    out.close();
                }
            }
        }
    }
}


