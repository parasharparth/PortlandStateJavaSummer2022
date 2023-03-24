package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextParserTest {

    /*************************************************************************************************************************
     * validTextFileCanBeParsed() Test to ensure that a valid phone bill text file can be parsed
     * Create a new TextParser instance with the resource file and Parse the phone bill from the file
     * invalidTextFileThrowsParserException() Test to ensure that an invalid phone bill text file throws a ParserException
     * Create a new TextParser instance with the resource file
     * Assert that parsing the phone bill throws a ParserException
     *************************************************************************************************************************/
    @Test
  void validTextFileCanBeParsed() {
    InputStream resource = getClass().getResourceAsStream("valid-phonebill.txt");
    assertThat(resource, notNullValue());

    TextParser parser = new TextParser((FileReader) new InputStreamReader(resource));
    PhoneBill bill = parser.parse();
    assertThat(bill.getCustomer(), equalTo(""));
  }

    @Test
    void invalidTextFileThrowsParserException() {
        InputStream resource = getClass().getResourceAsStream("empty-phonebill.txt");
        assertThat(resource, notNullValue());

        TextParser parser = new TextParser((FileReader) new InputStreamReader(resource));
        assertThrows(ParserException.class, parser::parse);
    }
}




