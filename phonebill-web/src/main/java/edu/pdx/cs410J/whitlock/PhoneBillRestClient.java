package edu.pdx.cs410J.whitlock;

import com.google.common.annotations.VisibleForTesting;
import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.whitlock.PhoneBill;
import edu.pdx.cs410J.whitlock.PhoneCall;
import edu.pdx.cs410J.whitlock.PrettyPrinter;
import edu.pdx.cs410J.web.HttpRequestHelper;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import static java.net.HttpURLConnection.HTTP_OK;
import static edu.pdx.cs410J.web.HttpRequestHelper.Response;

/**
 * A helper class for accessing the rest client.  Note that this class provides
 * an example of how to make gets and posts to a URL.  You'll need to change it
 * to do something other than just send dictionary entries.
 */
public class PhoneBillRestClient {

  private static final String WEB_APP = "phonebill";
  private static final String SERVLET = "calls";
  private final HttpRequestHelper http;

  String finalpretty = "";

  /**
   * Creates a client to the Phone Bil REST service running on the given host and port
   *
   * @param hostName The name of the host
   * @param port     The port
   */
  public PhoneBillRestClient(String hostName, int port)
  {
    this(new HttpRequestHelper(String.format("http://%s:%d/%s/%s", hostName, port, WEB_APP, SERVLET)));
  }

  @VisibleForTesting
  PhoneBillRestClient(HttpRequestHelper http) {
    this.http = http;
  }

  public void addCustomer(String customerName, PhoneCall call)
  {
    Response response = postToMyURL(Map.of(
            "customerName",customerName,
            "callerName",call.getCaller(),
            "calleeName",call.getCallee(),
            "callerNumber", call.getCallerNumber(),
            "calleeNumber", call.getCalleeNumber(),
            "phoneCallBeginDate", call.getPhoneCallBeginDate(),
            "phoneCallEndDate", call.getPhoneCallEndDate(),
            "phoneCallBeginTime", call.getBeginTimeString(),
            "phoneCallEndTime",call.getEndTimeString()
                    ));
    throwExceptionIfNotOkayHttpStatus(response);
  }

  public String getCustomerDetails(String customerName, PhoneBill bill) throws Exception
  {
    Response response = getFromMyURL(Map.of("customerName",customerName));
    if(response.getContent().contains("invalid")){
      System.err.println(response.getContent());
      return "Customer Name is invalid";
    }
    if(response.getContent().contains("does not exist")){
      System.err.println(response.getContent());
      return "Customer Name does not exist";
    }
    throwExceptionIfNotOkayHttpStatus(response);
    if (bill.getPhoneCalls().size() > 0){
      PrettyPrinter pretty = new PrettyPrinter();
      ArrayList<PhoneCall> phone = (ArrayList<PhoneCall>) bill.getPhoneCalls();
      Collections.sort(phone);
      finalpretty = "";
      for (PhoneCall call : phone) {
        finalpretty = finalpretty + pretty.getpretty(call, call.getCaller());
      }
    }
    return finalpretty;
  }

  /**
   * This method issues a GET request to the servlet
   * @param dictionaryEntries The arguments for the get request
   * @return The response from the servlet
   */
  Response getFromMyURL(Map<String, String> dictionaryEntries) throws IOException {
    return http.get(dictionaryEntries);
  }

  /**
   * This method is used to issue a POST request to the servlet
   * @param dictionaryEntries the arguments for the POST request
   * @return The response from the servlet
   */
  @VisibleForTesting
  Response postToMyURL(Map<String, String> dictionaryEntries) {
    try{
      return http.post(dictionaryEntries);
    }
    catch (Exception e){
      System.err.println("Please check the connection parameters for the client");
    }
    return null;
  }



  /**
   * Returns all dictionary entries from the server
   */
//  public Map<String, String> getAllDictionaryEntries() throws IOException, ParserException {
//    Response response = http.get(Map.of());
//    throwExceptionIfNotOkayHttpStatus(response);
//
//    TextParser parser = new TextParser(new StringReader(response.getContent()));
//    return parser.parse();
//  }

  /**
   * Returns the definition for the given word
   */
//  public String getDefinition(String word) throws IOException, ParserException {
//    Response response = http.get(Map.of("word", word));
//    throwExceptionIfNotOkayHttpStatus(response);
//    String content = response.getContent();
//
//    TextParser parser = new TextParser(new StringReader(content));
//    return parser.parse().get(word);
//  }


//  public void addDictionaryEntry(String word, String definition) throws IOException {
//    Response response = http.post(Map.of("word", word, "definition", definition));
//    throwExceptionIfNotOkayHttpStatus(response);
//  }
//
//  public void removeAllDictionaryEntries() throws IOException {
//    Response response = http.delete(Map.of());
//    throwExceptionIfNotOkayHttpStatus(response);
//  }

  /**
   * This method handles the response if there is an HTTP error
   * @param response the HTTP error response
   * @return The Response object of the error response
   */
  private Response throwExceptionIfNotOkayHttpStatus(Response response) {
    int code = response.getHttpStatusCode();
    if (code != HTTP_OK) {
      String message = response.getContent();
      throw new HttpRequestHelper.RestException(code, message);
    }
    return response;
  }


}
