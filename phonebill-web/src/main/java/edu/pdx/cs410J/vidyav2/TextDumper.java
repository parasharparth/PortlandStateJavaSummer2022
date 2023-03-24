package edu.pdx.cs410J.vidyav2;
import edu.pdx.cs410J.PhoneBillDumper;

import java.io.*;
import java.util.*;

public class TextDumper implements PhoneBillDumper<PhoneBill> {
    public String filename;
    public TextDumper(Writer writer) {
    }

    public TextDumper()
    {
    }

    @Override
    public void dump(PhoneBill bill) {
        ArrayList phoneCallList = (ArrayList) bill.getPhoneCalls();
        String[] calls = new String[phoneCallList.size()];
        try {
            PrintWriter out = new PrintWriter(filename);
            out.write("");
            out.write(bill.getCustomer());

            Collections.sort(phoneCallList);
            for (int i = 0; i < phoneCallList.size(); i++) {
                calls[i] = phoneCallList.get(i).toString();
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