package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.web.HttpRequestHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhoneBillRestClientTest {

  @Test
  void getAllDictionaryEntriesPerformsHttpGetWithNoParameters() throws ParserException, IOException {
    PhoneBill dictionary = new PhoneBill("Dave");

    HttpRequestHelper http = mock(HttpRequestHelper.class);
    when(http.get(eq(Map.of()))).thenReturn(dictionaryAsText(dictionary));

    PhoneBillRestClient client = new PhoneBillRestClient(http);

    //Map<String, String> dictionaryEntries = null;
    //assertThat(http.get(dictionaryEntries), equalTo(dictionary));
  }

  private HttpRequestHelper.Response dictionaryAsText(PhoneBill dictionary) throws IOException {
    StringWriter writer = new StringWriter();
    new TextDumper(writer).dump(dictionary);

    return new HttpRequestHelper.Response(writer.toString());
  }
}
