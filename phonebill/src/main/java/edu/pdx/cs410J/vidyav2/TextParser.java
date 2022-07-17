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

    public TextParser(Reader reader) {
        this.reader = reader;
    }

    public TextParser(String filename, String customerName)
    {
        this.filename = filename;
        this.customerName = customerName;
        this.reader = null;
    }
    public TextParser()
    {
        this.reader = null;
    }

    @Override
    public PhoneBill parse() throws ParserException {
        Scanner sc = null;
        try {
            File input = new File(this.filename);
            BufferedReader br = new BufferedReader(new FileReader((input)));
        } catch (Exception e) {
            System.out.println("Text Dump File with given name does not exist. New File created.");
            PrintWriter out = null;
            if (!this.filename.contains("/")) {
                try {
                    out = new PrintWriter(this.filename);
                } catch (FileNotFoundException ex) {
                    System.out.println("File is not present.");
                }
                out.write(this.customerName);   //print customer name here
                out.close();
            } else {
                File f = null;
                File f1 = null;
                String v;
                boolean bool = false;
                f = new File(this.filename);
                f1 = f.getParentFile();
                v = f1.getAbsolutePath();
                //check if directory exists or not
                if (f1.exists()) {
                    try {
                        out = new PrintWriter(f);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    out.write(this.billDetails);
                    out.close();
                } else {
                    File folder = new File(v);
                    if (folder.mkdir()) {
                        try {
                            out = new PrintWriter(this.filename);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        out.write(this.billDetails);
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
        }
        PhoneBill bill = new PhoneBill(this.customerName);
        if(lines.size() == 0)
        {
            System.out.println("File(): - Empty");
            bill.setCustomer(this.customerName);
        }
        else {
            bill.setCustomer(lines.get(0));
        }

        for(int i=1;i<lines.size(); i++)
        {
            String[] words = lines.get(i).split(" ");
            if(words.length!=10)
            {
                System.err.println("The text File is not in the formatted properly");
                System.exit(0);
            }
            PhoneCall call = new PhoneCall();
            call.setCallerName(words[1]);
            call.setCalleeName(words[2]);
            call.setCallerNumber(words[3]);
            call.setCalleeNumber(words[4]);
            call.setPhoneCallBeginDate(words[5]);
            call.setPhoneCallBeginTime(words[6]);
            call.setPhoneCallEndDate(words[7]);
            call.setPhoneCallEndTime(words[8]);
            bill.addPhoneCall(call);
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