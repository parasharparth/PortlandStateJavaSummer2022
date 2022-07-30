package edu.pdx.cs410J.vidyav2;

import com.google.common.annotations.VisibleForTesting;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * This servlet ultimately provides a REST API for working with an
 * <code>PhoneBill</code>.  However, in its current state, it is an example
 * of how to use HTTP and Java servlets to store simple dictionary of words
 * and their definitions.
 */

public class PhoneBillServlet extends HttpServlet
{
    static final String WORD_PARAMETER = "word";
    static final String DEFINITION_PARAMETER = "definition";

    private final Map<String, String> phoneBillArrayList = new HashMap<>();

    /**
     * Handles an HTTP GET request from a client by writing the definition of the
     * word specified in the "word" HTTP parameter to the HTTP response.  If the
     * "word" parameter is not specified, all of the entries in the dictionary
     * are written to the HTTP response.
     */
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException
    {
        private ArrayList<PhoneBill> phoneBillArrayList = new ArrayList<PhoneBill>();
        Map names = phoneBillArrayList.getCustomer();

        /**
         * Handles an HTTP GET request from a client by writing the airlines from
         * specified source to destination in XML format. If just the
         * "name" parameter is specified, all of the flights in the airline
         * are written to the HTTP response.
         */
        @Override
        protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException
        {
            response.setContentType( "text/plain" );

            String callerName = getParameter( "callerName", request );
            if (callerName == null) {
                missingRequiredParameter(response, "callerName");
                return;
            }

            String callerNumber = getParameter( "callerNumber", request );
            if (callerNumber == null) {
                missingRequiredParameter(response, "callerNumber");
                return;
            }

            String calleeNumber = getParameter( "calleeNumber", request );
            if (calleeNumber == null) {
                missingRequiredParameter(response, "calleeNumber");
                return;
            }

            PhoneBill bill = null;
            for (PhoneBill bill : phoneBillArrayList) {
                if (bill.getCustomerName().equals(customerName)) {
                    getCustomerName = bill;
                    break;
                }
            }
            if(getCustomerName == null){
                noairlinefound(getCustomerName, response);
            } else {
                StringWriter stringWriter = new StringWriter();
                stringWriter.flush();
                XmlDumper dumper = null;
                try {
                    dumper = new XmlDumper(stringWriter);
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                }
                ArrayList<PhoneCall> calls = getphoneBillArrayList.getPhoneCalls();
                if (callerName == null && calleeName == null) {
                    dumper.dump(getphoneBillArrayList);
                } else {
                    PhoneBill filteredPhoneBill = new PhoneBill();
                    filteredPhoneBill.setCustomer(customerName);
//                    for (Flight flight : arrli) {
//                        if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
//                            filteredairline.addFlight(flight);
//                        }
//                    }
                    dumper.dump(filteredPhoneBill);
                }
                response.getWriter().println(dumper.generateAsString());
                response.setStatus(HttpServletResponse.SC_OK);
            }
        }

        /**
         * Handles an HTTP POST request by storing the flight entry for the airline.
         */
        @Override
        protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
        {
            response.setContentType( "text/plain" );

            String customerName = getParameter("customerName", request );
            if (customerName == null) {
                missingRequiredParameter(response, "customerName");
                return;
            }
            String callerName = getParameter("callerName", request );
            if ( callerName == null) {
                missingRequiredParameter( response, "callerName" );
                return;
            }
            String callerNumber = getParameter("callerNumber", request );
            if ( callerNumber == null) {
                missingRequiredParameter( response, "callerNumber" );
                return;
            }

            String calleeNumber = getParameter("calleeNumber", request );
            if ( calleeNumber == null) {
                missingRequiredParameter( response, "calleeNumber" );
                return;
            }

            PhoneBill bill = createOrValidatePhoneBillForPost(customerName);
            PhoneCall call = new PhoneCall();
            call.setCallerName(words[2]);
            call.setCallerNumber(words[3]);
            call.setCalleeNumber(words[5]);
            call.setPhoneCallBeginDate(words[7]);
            call.setPhoneCallBeginTime(words[7],words[8],words[9]);
            call.setPhoneCallEndDate(words[11]);
            call.setPhoneCallEndTime(words[11],words[12],words[13]);
            bill.addPhoneCall(call);
            phoneBillArrayList.add(bill);
            response.setStatus( HttpServletResponse.SC_OK);
        }


        /**
         * Writes an error message about a missing parameter to the HTTP response.
         *
         * The text of the error message
         */
        private void missingRequiredParameter( HttpServletResponse response, String parameterName )
            throws IOException
        {
            String message = "The required parameter " + parameterName + " is missing!";
            response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED, message);
        }

        /**
         * Returns the value of the HTTP request parameter with the given name.
         *
         * @return <code>null</code> if the value of the parameter is
         *         <code>null</code> or is the empty string
         */
        private String getParameter(String name, HttpServletRequest request) {
        String value = request.getParameter(name);
        if (value == null || "".equals(value)) {
            return null;

        } else {
            return value;
        }
    }
}
