package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;
import java.io.Reader;
import java.util.*;
import java.io.*;

public class TextParser implements PhoneBillParser<PhoneBill> {
    private final Reader reader;

    public String filename;
    public String billDetails;

    public TextParser(Reader reader) {
        this.reader = reader;
    }

    public TextParser()
    {
        this.reader = null;
    }
    @Override
    public PhoneBill parse() throws ParserException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(this.filename));
        } catch (FileNotFoundException e) {
            System.out.println("Text Dump File with given name does not exist. File created.");
            PrintWriter out = null;
            if (!this.filename.contains("/")) {
                try {
                    out = new PrintWriter(this.filename);
                } catch (FileNotFoundException ex) {
                    System.out.println("File is not present.");
                }
                out.write(this.billDetails);
                out.close();
            } else {
                File f = null;
                File f1 = null;
                String v;
                boolean bool = false;
                f = new File(this.filename);
                f1 = f.getParentFile();
                v = f1.getAbsolutePath();
                bool = f1.exists();
                //check if directory exists or not
                if (bool) {
                    try {
                        out = new PrintWriter(this.filename);
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
        assert sc != null;
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        PhoneBill bill = new PhoneBill(billDetails);
        if (lines.size() == 0) {
            System.err.println("The textfile is empty!");
            System.exit(1);
        }
        bill.setCustomer(lines.get(0));
        try {
            PrintWriter out = new PrintWriter(filename);
            for (int j = 0; j < bill.getPhoneCalls().size(); j++) {
                out.write(bill.get(j));
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
                 return bill;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }
}