package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextParserTest {

    // @Test
// void validTextFileCanBeParsed() throws ParserException {
// InputStream resource = getClass().getResourceAsStream("valid-phonebill.txt");
// assertThat(resource, notNullValue());
//
// TextParser parser = new TextParser(new InputStreamReader(resource));
// PhoneBill bill = parser.parse();
// assertThat(bill.getCustomer(), equalTo("Test Phone Bill"));
//
// }
//
// @Test
// void invalidTextFileThrowsParserException() {
// InputStream resource = getClass().getResourceAsStream("empty-phonebill.txt");
// assertThat(resource, notNullValue());
//
// TextParser parser = new TextParser(new InputStreamReader(resource));
// assertThrows(ParserException.class, parser::parse);
// }
}



