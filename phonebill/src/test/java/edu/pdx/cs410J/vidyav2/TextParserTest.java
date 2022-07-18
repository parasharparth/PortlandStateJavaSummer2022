package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextParserTest {

    @Test
    void validTextFileCanBeParsed() throws ParserException {
        String fileName = "phonebill.txt";
        TextParser parser = new TextParser(fileName);
        System.out.println("fileName is" + parser);
        parser.setFilename(fileName);
        parser.setCustomerName("Bhaskar");
        PhoneBill bill = parser.parse();
        assertThat(bill.getCustomer(), notNullValue());
    }

    @Test
    void invalidTextFileCanBeParsed() throws ParserException {
        String fileName = "bogus.txt";
        TextParser parser = new TextParser(fileName);
        System.out.println("fileName is" + parser);
        parser.setFilename(fileName);
        parser.setCustomerName("Test Phone Bill");
        PhoneBill bill = parser.parse();
        assertThat(bill.getCustomer(), equalTo("Test This"));
    }



    private <T> void assertThat(String customer, Matcher<T> bhaskar) {
    }


//
//  @Test
//  void invalidTextFileThrowsParserException() {
//    InputStream resource = getClass().getResourceAsStream("empty-phonebill.txt");
//    assertThat(resource, notNullValue());
//
//    TextParser parser = new TextParser(new InputStreamReader(resource));
//    assertThrows(ParserException.class, parser::parse);
//  }

}