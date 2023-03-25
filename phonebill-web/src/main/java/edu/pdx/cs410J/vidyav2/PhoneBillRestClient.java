package edu.pdx.cs410J.vidyav2;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class PhoneBillRestClient {

	String hostName;
	int portNum ;
	PhoneBillRestClient(String hostName, int portNum){
		this.hostName = hostName;
		this.portNum = portNum;
	}
	public static String sendGetRequest(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} else {
			throw new IOException("GET request failed with response code: " + responseCode);
		}
	}

	public static void getInfo() throws IOException {
		String servletUrl = "http://localhost:8080/myServlet";
		String response = sendGetRequest(servletUrl);
		System.out.println("Response from servlet: " + response);
	}

	public static <JSONObject> void sendJsonResponse(HttpServletResponse response, int statusCode) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(statusCode);
		//response.getWriter().write(json.toString());
	}

	public void addCustomer(String customerName,PhoneCall call) {
		System.out.println(customerName);
		call.calleeNumber = "callee Number";
	}

    public void removeAllDictionaryEntries() {
    }

	public Map<String, PhoneBill> getPhoneBillEntries(String customer) {
		return null;
	}

	public void addPhoneCallEntry(String customer, String caller, String callee, String beginTime, String endTime) {
	}


	public <T> T addCustomer(String calleeNumber) {
		return null;
	}
}
