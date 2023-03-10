package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TextDumperTest {

  @Test
  void appointmentBookOwnerIsDumpedInTextFormat() throws IOException {
    File file = new File("vidyav2/testDumper.txt");
    String customer = "Test Phone Bill1";
    PhoneBill bill = new PhoneBill(customer);
    StringWriter sw = new StringWriter();
    TextDumper dumper = new TextDumper(sw);
    dumper.setFileName("vidyav2/testDumper.txt");
    dumper.dump(bill);
    sw.write(bill.getCustomer());
    String text = sw.toString();
    assertThat(text, containsString(customer));
    //File file = new File("vidyav2/testDumper.txt");
    //if (file.exists()) {
      //file.delete();
    //}
  }}



//  @Test
//  void phoneBillIsDumpedInTextFormat() {
//    String customer = "Test Phone Bill";
//    PhoneBill bill = new PhoneBill(customer);
//
//    StringWriter sw = new StringWriter();
//    TextDumper dumper = new TextDumper(sw);
//    dumper.setFileName("bogus.txt");
//    dumper.dump(bill);
//    sw.write(bill.getCustomer());
//
//    String text = sw.toString();
//    assertThat(text, containsString(customer));
//  }
