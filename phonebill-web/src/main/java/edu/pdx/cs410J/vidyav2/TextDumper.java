package edu.pdx.cs410J.vidyav2;
import edu.pdx.cs410J.PhoneBillDumper;

import java.io.*;
import java.util.*;

public class TextDumper implements PhoneBillDumper<PhoneBill> {
    String filename;

    public TextDumper(Writer writer) {
    }

    public TextDumper() {
    }

    public static long formatDefinition(String test, String thisIsATestDefinition) {
        return 0;
    }

    @Override
    public void dump(PhoneBill bill) {
        ArrayList<PhoneCall> phoneCallList = (ArrayList<PhoneCall>) bill.getPhoneCalls();
        try (PrintWriter out = new PrintWriter(filename)) {
            out.write("");
            out.write(bill.getCustomer());

            Collections.sort(phoneCallList);
            StringBuilder calls = new StringBuilder();
            for (PhoneCall phoneCall : phoneCallList) {
                calls.append("\n").append(phoneCall.toString());
            }
            out.write(calls.toString());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    void setFileName(String filename) {
        this.filename = filename;
    }
}
