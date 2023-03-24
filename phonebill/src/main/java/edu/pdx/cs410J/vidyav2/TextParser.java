package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;
import java.io.Reader;
import java.util.*;
import java.io.*;

public class TextParser implements PhoneBillParser<PhoneBill> {
    private final Reader reader;

    public String filename;

    public String customerName;
    public String billDetails;

    public TextParser(String filename, String customerName)
    {
        this.filename = filename;
        this.customerName = customerName;
        this.reader = null;
    }

    public TextParser(FileReader fileReader, Reader reader) {
        this.reader = reader;
    }

    @Override
    public PhoneBill parse() throws ParserException {
        Scanner sc = null;
        try {
            File input = new File(this.filename);
            BufferedReader br = new BufferedReader(new FileReader((input)));
        } catch (Exception e)
        {
            System.out.println("Text Dump File with given name does not exist. New File created.");
            PrintWriter out = null;
            //out = new PrintWriter(this.filename);
            if (!this.filename.contains("/")) {
                try {
                    out = new PrintWriter(this.filename);
                } catch (FileNotFoundException ex) {
                    System.out.println("File is not present.");
                }
               // out.write(this.customerName);   //print customer name here
//                System.out.println("I was here");
                out.write(this.customerName);
                out.flush();
                out.close();
            }
            else {
                File f = null;
                File f1 = null;
                String v;
                boolean bool = false;
                f = new File(this.filename);
                f1 = f.getParentFile();
                v = f1.getAbsolutePath();
                //check if directory exists or not
                if (f1.exists()) {
                    //System.out.println("debug 2");
                    try {
                        out = new PrintWriter(f);
                        //System.out.println("debug 3");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    out.write(this.customerName);
                    out.flush();
                    out.close();
                } else {
                    File folder = new File(v);
                    if (folder.mkdir()) {
                        try {
                            out = new PrintWriter(this.filename);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        out.write(this.customerName);
                        out.flush();
                        //System.out.println("debug1");
                        out.close();
                    } else {
                        System.out.println("Could not create directory");
                        System.exit(1);
                    }
                }
            }
        }
        try {
            sc = new Scanner(new File(this.filename));
        } catch (FileNotFoundException e) {
            System.out.println("File is not present.");
        }

        ArrayList<String> lines = new ArrayList<String>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
            //System.out.println(""+ lines);
        }
        PhoneBill bill = new PhoneBill(this.customerName);
        if(lines.size() == 0)
        {
            System.out.println("File(): - Empty");
            bill.setCustomer(this.customerName);
        }
        else {
            bill.setCustomer(lines.get(0));
            String[] first_name = lines.get(0).split("\n");
            //System.out.println("txt is" + first_name[0] + this.customerName);
            if(!first_name[0].equals(this.customerName))
            {
                System.err.println("Customer name in command line and file don't match or there is bogus data.");
                System.exit(1);
                System.out.println("txt is" + first_name[0]);
            }
        }
        for(int i=1;i<lines.size(); i++) {/*
            //System.out.println("I was here");
            String[] words = lines.get(i).split(" ");
//            if(words.length!=12)
//            {
//                System.err.println("The text File is not in the formatted properly");
//                System.exit(0);
//            }
            PhoneCall call = new PhoneCall();
            call.setCallerName(words[2]);
            call.setCallerNumber(words[3]);
            call.setCalleeNumber(words[5]);
            call.setPhoneCallBeginDate(words[7]);
            call.setPhoneCallBeginTime(words[7],words[8],words[9]);
//            if(!Project2.checkForValidDate(words[5])){
//                System.out.println("This text file cannot be parsed.");
//                System.exit(0);
//            }
            call.setPhoneCallEndDate(words[11]);
            call.setPhoneCallEndTime(words[11],words[12],words[13]);
//            if(!Project2.checkForValidDate(words[8])){
//                System.out.println("This text file cannot be parsed.");
//                System.exit(0);
//            }
            bill.addPhoneCall(call);*/
        }

        return bill;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }
}