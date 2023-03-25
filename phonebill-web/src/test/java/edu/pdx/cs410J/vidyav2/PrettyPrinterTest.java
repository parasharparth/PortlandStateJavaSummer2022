package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PrettyPrinterTest {
    @Test
    public void testPretty() throws IOException {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        PhoneCall call = new PhoneCall();
        PhoneBill bill = new PhoneBill(prettyPrinter.customerName);
        bill.addPhoneCall(call);
        call.setCallerName("Dave");
        call.setCallerNumber("222-222-6666");
        call.setCalleeNumber("666-777-8888");
        bill.addPhoneCall(call);

        call = new PhoneCall();
        call.setCallerName("Dave");
        call.setCallerNumber("222-222-6666");
        call.setCalleeNumber("666-777-8888");
        bill.addPhoneCall(call);
        prettyPrinter.dump(bill);
    }
}
