package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.PhoneBillDumper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PrettyPrinter implements PhoneBillDumper<PhoneBill> {
    /**
     * This method formats the phonebill in a pretty way
     * @param This is the pretty print
     * @throws IOException handles the IO exception
     * @result this prints the pretty file
     */

    String fileName;
    String customerName;

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public void setFilename(String fileName)
    {
        this.fileName = fileName; //.concat("pretty");
        //System.out.println(this.fileName);
    }

    public String getpretty(PhoneCall call, String customer) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        long callDuration = call.getPhoneCallEndTime().getTime() - call.getPhoneCallBeginTime().getTime();
        String prettytext = "Customer : " + customer +
                "\nCallerNumber : " + call.getCallerNumber() +
                "\nCalleeNumber : " + call.getCalleeNumber() +
                "\nDate of Begin : " + call.getPhoneCallBeginDate() +
                "\nTime of Begin : " + formatter.getTimeInstance(DateFormat.SHORT).format(call.getPhoneCallBeginTime()) +
                "\nDate of End : " + call.getPhoneCallEndDate() +
                "\nTime of End : " + formatter.getTimeInstance(DateFormat.SHORT).format(call.getPhoneCallEndTime()) +
                "\nDuration (minutes) : " + TimeUnit.MILLISECONDS.toMinutes(callDuration) + "\n\n";

        //Return pretty print
        return prettytext;
    }

    @Override
    public void dump(PhoneBill bill) throws IOException {
        ArrayList phonecallList = (ArrayList) bill.getPhoneCalls();
        String[] calls = new String[phonecallList.size()];
        Collections.sort(phonecallList);
        Scanner sc = null;
        if (fileName.equals("-")) {
            for (int i = 0; i < phonecallList.size(); i++) {
                System.out.println("\nThis is a pretty file, printing the following Phone details:\n"
                        + getpretty((PhoneCall) phonecallList.get(i), bill.getCustomer()));//getpretty(call, bill.getCustomer()));

                }
            System.exit(0);
        }
        //else if (filename contains - and .txt) then do a pretty print
        // Case when pretty file is not present
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
                out.write("");
                for (int i = 0; i < phonecallList.size(); i++) {
                    String x = getpretty((PhoneCall) phonecallList.get(i), bill.getCustomer());
                    out.write(x);
                }
                out.close();
            }
            else {
                File f;
                File f1;
                String v;
                boolean bool = false;
                f = new File(this.fileName);
                f1 = f.getParentFile();
                v = f1.getAbsolutePath();
                bool = f1.exists();
                //check if directory exists or not
                if (bool) {
                    //System.out.println("debug 2");
                    try {
                        out = new PrintWriter(this.fileName);
                        //System.out.println("debug 3");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    //**************************
                    out.write("");
                    for (int i = 0; i < phonecallList.size(); i++) {
                        String x = getpretty((PhoneCall) phonecallList.get(i), bill.getCustomer());
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
                        out.write("");
                        for (int i = 0; i < phonecallList.size(); i++) {
                            String x = getpretty((PhoneCall) phonecallList.get(i), bill.getCustomer());
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
                    System.out.println("Pretty Print file is not present.");
                }
                out.write("");
                for (int i = 0; i < phonecallList.size(); i++) {
                    String x = getpretty((PhoneCall) phonecallList.get(i), bill.getCustomer());
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
                    for (Object o : phonecallList) {
                    //for (int i = 0; i < phonecallList.size(); i++) {
                        String x = getpretty((PhoneCall) o, bill.getCustomer());
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
                        try {
                            assert out != null;
                            out.write("");
                        }
                        catch(NullPointerException e)
                        {
                            System.out.println(e.getMessage());
                        }
                        for (Object o : phonecallList) {
                            String x = getpretty((PhoneCall) o, bill.getCustomer());
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

    }
}


