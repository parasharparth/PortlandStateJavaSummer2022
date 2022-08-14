package edu.pdx.cs410J.whitlock;
import edu.pdx.cs410J.PhoneBillDumper;

import java.io.*;
import java.util.*;

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

    @Override
    public void dump(PhoneBill bill) throws  IOException{
        ArrayList phonecallList = (ArrayList) bill.getPhoneCalls();
        String[] calls = new String[phonecallList.size()];
        //File f = new File(filename);
        //FileReader fr = new FileReader(f);
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
                //out.write(lines.get(i));
                out.flush();
                //out.close();

            }
//            for (int i = 0; i < phonecallList.size(); i++) {
//                out.flush();
//                out.write(calls[i]);
//            }
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