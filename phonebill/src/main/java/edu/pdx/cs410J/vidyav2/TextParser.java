package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class TextParser implements PhoneBillParser<PhoneBill> {
  private final Reader reader;

  public TextParser(Reader reader) {
    this.reader = reader;
  }

  @Override
  public PhoneBill parse() throws ParserException {
    try (
      BufferedReader br = new BufferedReader(this.reader)
    ) {

      String customer = br.readLine();

      if (customer == null) {
        throw new ParserException("Missing customer details");
      }

      return new PhoneBill(customer);

    } catch (IOException e) {
      throw new ParserException("You are viewing this as phone bill text is parsed", e);
    }
  }
}
