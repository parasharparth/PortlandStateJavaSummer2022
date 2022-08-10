package edu.pdx.cs410j.whitlock;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import edu.pdx.cs410J.PhoneBillDumper;

public class TextDumper implements PhoneBillDumper<PhoneBill> {

    String filename;
    File dir;

    public TextDumper(File directory, String nameoffile) {
        this.dir = directory;
        this.filename = nameoffile;
    }

    @Override
    public void dump(PhoneBill bill) throws IOException {
        ArrayList phonecallList = (ArrayList) bill.getPhoneCalls();
        String[] calls = new String[phonecallList.size()];
        PrintWriter out = new PrintWriter(filename);
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


