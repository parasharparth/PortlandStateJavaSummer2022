package edu.pdx.cs410J.vidyav2;

import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Integration test that tests the REST calls made by {@link PhoneBillRestClient}
 */
@TestMethodOrder(MethodName.class)
class PhoneBillRestClientIT {
    private static final String HOSTNAME = "localhost";
    private static final String PORT = System.getProperty("http.port", "8080");

    private PhoneBillRestClient newPhoneBillRestClient() {
        int port = Integer.parseInt(PORT);
        return new PhoneBillRestClient(HOSTNAME, port);
    }

    @Test
    void test0RemoveAllDictionaryEntries() {
        PhoneBillRestClient client = newPhoneBillRestClient();
        client.removeAllDictionaryEntries();
    }

    @Test
    void test1EmptyServerContainsNoDictionaryEntries() {
        PhoneBillRestClient client = newPhoneBillRestClient();
        String customer = null;
        Map<String, PhoneBill> dictionary = client.getPhoneBillEntries(null);
        assertThat(dictionary.size(), equalTo(0));
    }

    @Test
    void test2RecievePhoneBill() {
        PhoneBillRestClient client = newPhoneBillRestClient();
        String customer = "customer";
        String caller = "425-741-1269";
        String callee = "425-239-9870";
        String beginTime = "05/24/2022 11:50am";
        String endTime = "05/24/2022 12:00pm";
        new PhoneBill(customer);
        client.addPhoneCallEntry(customer, caller, callee, beginTime, endTime);
        String response =  client.getPhoneBillEntries(customer).toString();

        assertThat(response, equalTo(client.addCustomer("callee Number" )));
    }

}