package edu.pdx.cs410J.vidyav2;
import edu.pdx.cs410J.PhoneBillDumper;
import java.io.*;
import java.util.*;

/*******************************************************
 * TextDumper class implements PhoneBillDumper
 * a writer object for writing to a file
 * TextDumper() constructor that takes a writer object
 *******************************************************/
public class TextDumper implements PhoneBillDumper<PhoneBill> {
    private final Writer writer;
    public String filename;
    public TextDumper(Writer writer) {
        this.writer = writer;
    }

    public TextDumper()
    {
        this.writer = null;
    }

    /*****************************************************************************************
     * implementation of the PhoneBillDumper interface
     * catch(Exception e) print the stack trace and error message if an exception is thrown
     * setFileName() setter method for the filename variable
     *****************************************************************************************/
    @Override
    public void dump(PhoneBill bill) {
        ArrayList<PhoneCall> phonecallList = bill.getPhoneCalls();
        String[] calls = new String[phonecallList.size()];
        new File(filename);
        try {
            PrintWriter out = new PrintWriter(filename);
            out.write("");
            out.write(bill.getCustomer());

            Collections.sort(phonecallList);
            ArrayList<String> lines = new ArrayList<String>();
            for (int i = 0; i < phonecallList.size(); i++) {
                calls[i] = phonecallList.get(i).toString();
                out.write("\n");
                out.write(calls[i]);
                out.flush();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void setFileName(String filename)
    {
        this.filename = filename;
    }

}