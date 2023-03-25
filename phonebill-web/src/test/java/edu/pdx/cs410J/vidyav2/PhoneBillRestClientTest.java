package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.web.HttpRequestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.verification.VerificationMode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class PhoneBillRestClientTest extends PhoneCall {

  private String urlString;

//  @Test
//  void getAllDictionaryEntriesPerformsHttpGetWithNoParameters() throws ParserException, IOException {
//    PhoneBill dictionary = new PhoneBill("Dave");
//
//  }

  @Test
  public void testSendGetRequestSuccess() throws IOException {
    URL url = new URL(urlString);
    String response = PhoneBillRestClient.sendGetRequest(urlString);

    Assertions.assertNotNull(response);
    Assertions.assertTrue(response.contains("url"));
  }

  @Test
  public void testAddCustomer() {
    String customerName = "Dave";
    PhoneCall call = new PhoneCall("111-444-7777");

    PhoneBillRestClient client = new PhoneBillRestClient("localhost", 8080);
    client.addCustomer(customerName, call);

    Assertions.assertEquals("callee Number", call.calleeNumber);
  }

  @Test
  public void testSendGetRequestException() {
    String urlString = "https://invalidurl/";

    assertThrows(IOException.class, () -> {
      PhoneBillRestClient.sendGetRequest(urlString);
    });
  }

  @Test
  public void testGetInfo() throws IOException {
    String servletUrl = "http://localhost:8080/myServlet";
    String expectedResponse = "test response";
    when(PhoneBillRestClient.sendGetRequest(servletUrl)).thenReturn(expectedResponse);

    PhoneBillRestClient.getInfo();
    notifyAll(PhoneBillRestClient.class, times(1));
    PhoneBillRestClient.sendGetRequest(servletUrl);
  }

  @Test
  public void testSendJsonResponse() throws IOException {
    // given
    HttpServletResponse response = mock(HttpServletResponse.class);
    int statusCode = 200;
    PhoneBillRestClient.sendJsonResponse(response, statusCode);
    verify(response, times(1)).setContentType("application/json");
    verify(response, times(1)).setCharacterEncoding("UTF-8");
    verify(response, times(1)).setStatus(statusCode);
    verify(response.getWriter(), times(1));
  }

  private void notifyAll(Class<PhoneBillRestClient> phoneBillRestClientClass, VerificationMode times) {
  }


}
