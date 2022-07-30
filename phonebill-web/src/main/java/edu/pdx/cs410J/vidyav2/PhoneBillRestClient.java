package edu.pdx.cs410J.vidyav2;

import com.google.common.annotations.VisibleForTesting;
import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.web.HttpRequestHelper;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

import static edu.pdx.cs410J.web.HttpRequestHelper.Response;
import static edu.pdx.cs410J.web.HttpRequestHelper.RestException;
import static java.net.HttpURLConnection.HTTP_OK;

/**
 * A helper class for accessing the rest client.  Note that this class provides
 * an example of how to make gets and posts to a URL.  You'll need to change it
 * to do something other than just send dictionary entries.
 */
public class PhoneBillRestClient {

    private static final String WEB_APP = "phonebill";
    private static final String SERVLET = "calls";

  private final HttpRequestHelper http;

  private final String url;
  String finalpretty = "";

    /**
     * Creates a client to the Phone Bil REST service running on the given host and port
     * @param hostName The name of the host
     * @param port The port
     */
    public PhoneBillRestClient( String hostName, int port )
    {
      this(new HttpRequestHelper(String.format("http://%s:%d/%s/%s", hostName, port, WEB_APP, SERVLET)));
    }

  @VisibleForTesting
  PhoneBillRestClient(HttpRequestHelper http) {
    this.http = http;
  }

  public void addCustomer(String customerName, PhoneBill bill)
  {
    Response response = postToMyURL(Map.of(
            "callerName",callerName,
            "CallerNumber", callerNumber,
            "CalleeNumber", calleeNumber,
            "phoneCallBeginDate",Date.toString(phoneCallBeginDate),
            "phoneCallEndDate", Date.toString(phoneCallEndDate),
            "phoneCallBeginTime", phoneCallBeginTime,
            "phoneCallEndTime",phoneCallEndTime;

    throwExceptionIfNotOkayHttpStatus(response);
  }

  public String getCustomerDetails(String customerName, PhoneBill bill) throws Exception
  {
      Response response = getFromMyURL(Map.of("customerName",customerName,"phoneBill",bill));
    if(response.getContent().contains("invalid")){
      System.err.println(response.getContent());
      return "Customer Name is invalid";
      //System.exit(1);
    }
    if(response.getContent().contains("does not exist")){
      System.err.println(response.getContent());
      return "Customer Name does not exist";
      //  System.exit(1);
    }
    throwExceptionIfNotOkayHttpStatus(response);
    if (bill.getPhoneBill().size() > 0){
      PrettyPrinter pretty = new PrettyPrinter();
      ArrayList<PhoneBill>  phone = bill.getBillDetails();
      Collections.sort(phone);
      finalpretty = "";
      for (PhoneCall call : phone.getCalls()) {
        finalpretty = finalpretty + pretty.getpretty(call, phone.getCustomerName());
      }
      return finalpretty;
    }
  }
}
