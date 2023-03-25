package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;
import java.util.*;
import java.io.*;

public class TextParser implements PhoneBillParser<PhoneBill> {

    private String filename;
    private String customerName;

    public TextParser(String filename, String customerName) {
        this.filename = filename;
        this.customerName = customerName;
    }

    public TextParser(StringReader stringReader) {
    }

    @Override
    public PhoneBill parse() throws ParserException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            if (!scanner.hasNextLine()) {
                throw new ParserException("File is empty");
            }
            String firstLine = scanner.nextLine().trim();
            if (!firstLine.equals(customerName)) {
                throw new ParserException("Customer name in command line and file don't match or there is bogus data.");
            }
            PhoneBill bill = new PhoneBill(customerName);
            bill.setCustomer(firstLine);
            return bill;
        } catch (FileNotFoundException e) {
            try {
                File file = new File(filename);
                file.getParentFile().mkdirs();
                file.createNewFile();
                PrintWriter writer = new PrintWriter(file);
                writer.write(customerName);
                writer.flush();
                writer.close();
                return new PhoneBill(customerName);
            } catch (IOException ex) {
                throw new ParserException("Unable to create file: " + filename);
            }
        }
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
