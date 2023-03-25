package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Map;

import static groovy.test.GroovyTestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class TextDumperParserTest {

  @Test
  void emptyMapCanBeDumpedAndParsed() throws ParserException {
    Map<String, String> map = Collections.emptyMap();
    Map<String, String> read = dumpAndParse(map);
    assertThat(read, equalTo(map));
  }

  private Map<String, String> dumpAndParse(Map<String, String> map) throws ParserException {
    StringWriter sw = new StringWriter();
    TextDumper dumper = new TextDumper(sw);
    dumper.dump((PhoneBill) map);

    String text = sw.toString();

    TextParser parser = new TextParser(new StringReader(text));
    return (Map<String, String>) parser.parse();
  }

  @Test
  void dumpedTextCanBeParsed() throws ParserException {
    Map<String, String> map = Map.of("one", "1", "two", "2");
    Map<String, String> read = dumpAndParse(map);
    assertThat(read, equalTo(map));
  }

  @Test
  public void testSetFileName() {
    TextDumper dumper = new TextDumper();
    dumper.setFileName("test.txt");
    assertEquals("test.txt", dumper.filename);
  }

  @Test
  public void testFormatDefinition() {
    String word = "test";
    String definition = "this is a test definition";
    long size = TextDumper.formatDefinition(word, definition);
    Assertions.assertEquals(25, size);
  }

  @Test
  public void testDump() {
    PhoneBill bill = new PhoneBill("customer");
    PhoneCall call1 = new PhoneCall();
    PhoneCall call2 = new PhoneCall();
    bill.addPhoneCall(call1);
    bill.addPhoneCall(call2);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    TextDumper dumper = new TextDumper();
    dumper.dump(bill);

    String expectedOutput = "customer\n" + call1 + "\n" + call2 + "\n";
    assertEquals(expectedOutput, outContent.toString());
  }
}
