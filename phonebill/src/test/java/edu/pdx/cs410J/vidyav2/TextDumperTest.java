package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *  declares a public class named TextDumperTest
 */
public class TextDumperTest {


  /********************************************************************************************************************************
   * appointmentBookOwnerIsDumpedInTextFormat() This test checks if the owner of a phone bill is properly dumped in text format.
   * testDump() This test checks if the dump method of TextDumper correctly writes phone bill information to a file.
   * Prepare test data and Set up test environment
   *  Call the method under test and Verify the results
   * ParseTextWrittenByTextDumper() This test checks if a phone bill written to a text file by a TextDumper can be correctly parsed by a TextParser.
   *********************************************************************************************************************************/
  @Test
  void appointmentBookOwnerIsDumpedInTextFormat() {
    new File("vidyav2/testDumper.txt");
    String customer = "Test Phone Bill1";
    PhoneBill bill = new PhoneBill(customer);
    StringWriter sw = new StringWriter();
    TextDumper dumper = new TextDumper(sw);
    dumper.setFileName("vidyav2/testDumper.txt");
    dumper.dump(bill);
    sw.write(bill.getCustomer());
    String text = sw.toString();
    assertThat(text, containsString(customer));
  }

  @Test
  public void testDump() {

    PhoneBill bill = new PhoneBill("Test Customer");
    PhoneCall call1 = new PhoneCall();
    PhoneCall call2 = new PhoneCall();
    bill.addPhoneCall(call1);
    bill.addPhoneCall(call2);


    String filename = "testDump.txt";
    File file = new File(filename);
    if (file.exists()) {
      file.delete();
    }


    StringWriter sw = new StringWriter();
    TextDumper dumper = new TextDumper(sw);
    dumper.setFileName("vidyav2/testDumper.txt");
    dumper.dump(bill);


    assertTrue(file.exists());

    String text = sw.toString();
    assertThat(text, containsString(String.valueOf(call1.getBeginTime())));
  }
  @Test
  void ParseTextWrittenByTextDumper(@TempDir File tempDir) throws IOException, ParserException {
    String customer = "Test Phone Bill";
    PhoneBill bill = new PhoneBill(customer);

    File textFile = new File(tempDir, "apptbook.txt");
    TextDumper dumper = new TextDumper(new FileWriter(textFile));
    dumper.dump(bill);

    Reader reader = null;
    TextParser parser = new TextParser(new FileReader(textFile));
    PhoneBill read = parser.parse();
    assertThat(read.getCustomer(), equalTo(customer));
  }
}

