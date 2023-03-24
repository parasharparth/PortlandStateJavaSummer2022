package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.PhoneBillParser;
import java.util.*;
import java.io.*;

/**************************************************************************************************************
 * TextParser class that implements PhoneBillParser interface
 * This class is responsible for parsing the text files containing phone call information and populating a PhoneBill object with the parsed data.
 * It implements the PhoneBillParser interface for parsing phone bills.
 * Filename to read/write phone bill data
 * Customer name associated with the phone bill data
 **************************************************************************************************************/
public class TextParser implements PhoneBillParser<PhoneBill> {

    public String filename;

    public String customerName;

    /****************************************************************************************************************
     * TextParser Constructor to set filename and customer name
     * PhoneBill parse()  Method to read phone bill data from text file and parse it to create a PhoneBill object
     * Try to read from the given file, or create a new file if it doesn't exist
     * If filename doesn't contain a directory path, create a new file with given filename
     * If filename contains a directory path, create the directory if it doesn't exist and create the file
     * Create a PhoneBill object and set its customer name
     * If the file is empty, set the customer name of the PhoneBill object to the given customer name
     * If the file is not empty, set the customer name of the PhoneBill object to the first line of the file
     * setFilename() This method sets the filename of the phone bill text file to be parsed.
     * setCustomerName() This method sets the customer name for the phone bill to be parsed.
     *****************************************************************************************************************/

    public TextParser(String filename, String customerName)
    {
        this.filename = filename;
        this.customerName = customerName;
    }

    public TextParser(FileReader fileReader) {
    }

    @Override
    public PhoneBill parse() {
        Scanner sc = null;
        try {
            File input = new File(this.filename);
            new BufferedReader(new FileReader((input)));
        } catch (Exception e)
        {
            System.out.println("Text Dump File with given name does not exist. New File created.");
            PrintWriter out = null;
            if (!this.filename.contains("/")) {
                try {
                    out = new PrintWriter(this.filename);
                } catch (FileNotFoundException ex) {
                    System.out.println("File is not present.");
                }
                assert out != null;
                out.write(this.customerName);
                out.flush();
                out.close();
            }
            else {
                File f;
                File f1;
                String v;
                f = new File(this.filename);
                f1 = f.getParentFile();
                v = f1.getAbsolutePath();
                if (f1.exists()) {
                    try {
                        out = new PrintWriter(f);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    assert out != null;
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
                        assert out != null;
                        out.write(this.customerName);
                        out.flush();
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

        while (true) {
            assert sc != null;
            if (!sc.hasNextLine()) break;
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
            String[] first_name = lines.get(0).split("\n");
            if(!first_name[0].equals(this.customerName))
            {
                System.err.println("Customer name in command line and file don't match or there is bogus data.");
                System.exit(1);
                System.out.println("txt is" + first_name[0]);
            }
        }
        for(int i=1;i<lines.size(); i++) {
            String[] words = lines.get(i).split(" ");
            PhoneCall call = new PhoneCall();
            call.setCallerName(words[2]);
            call.setCallerNumber(words[3]);
            call.setCalleeNumber(words[5]);
            call.setPhoneCallBeginDate(words[7]);
            call.setPhoneCallBeginTime(words[7],words[8],words[9]);
            call.setPhoneCallEndDate(words[11]);
            call.setPhoneCallEndTime(words[11],words[12],words[13]);
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