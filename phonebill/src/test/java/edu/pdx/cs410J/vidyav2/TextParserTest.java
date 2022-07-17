package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import org.junit.jupiter.api.Test;

import java.io.Reader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextParserTest {}

//  @Test
//  public void malformedFileTest () throws ParserException {
//    TextParser parser = new TextParser("phonebill.txt");
//    PhoneBill bill = (AppointmentBook)parser.parse();
//    ArrayList<Appointment> appts;
//    appts = (ArrayList<Appointment>) apptbook.getAppointments();
//    for( Appointment appt: appts)
//    {
//      System.out.println(appt.toString());
//    }
//  }

//  @Test
//  public void aFileThatDoesntExistTest() throws ParserException {
//    Reader reader = null;
//    TextParser parser = new TextParser("some random file");
//    PhoneBill bill = parser.parse(resource);
//    assertThat(bill.getCustomer(),equalTo(null));
//    assertThat(parser.billDetails, equalTo(null));
//  }
//}

//  @Test
//  void validTextFileCanBeParsed() throws ParserException {
//    InputStream resource = getClass().getResourceAsStream("valid-phonebill.txt");
//    assertThat(resource, notNullValue());
//
//    TextParser parser = new TextParser(new InputStreamReader(resource));
//    PhoneBill bill = parser.parse(resource);
//    assertThat(bill.getCustomer(), equalTo("Test Phone Bill"));
//  }
//
//  @Test
//  void invalidTextFileThrowsParserException() {
//    InputStream resource = getClass().getResourceAsStream("empty-phonebill.txt");
//    assertThat(resource, notNullValue());
//
//    TextParser parser = new TextParser(new InputStreamReader(resource));
//    assertThrows(ParserException.class, parser::parse);
//  }
