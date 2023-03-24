package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.web.HttpRequestHelper;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Integration test that tests the REST calls made by {@link PhoneBillRestClient}
 */
@TestMethodOrder(MethodName.class)
class PhoneBillRestClientIT {
//  private static final String HOSTNAME = "localhost";
//  private static final String PORT = System.getProperty("http.port", "8080");

//  private PhoneBillRestClient newPhoneBillRestClient() {
//    int port = Integer.parseInt(PORT);
//    return new PhoneBillRestClient(HOSTNAME, port);
//  }

//  @Test
//  void test0RemoveAllDictionaryEntries() throws IOException {
//    PhoneBillRestClient client = newPhoneBillRestClient();
//    client.removeAllDictionaryEntries();
//  }
//
//  @Test
//  void test1EmptyServerContainsNoDictionaryEntries() throws IOException, ParserException {
//    PhoneBillRestClient client = newPhoneBillRestClient();
//    Map<String, String> dictionary = client.getAllDictionaryEntries();
//    assertThat(dictionary.size(), equalTo(0));
//  }
//
//  @Test
//  void test2DefineOneWord() throws IOException, ParserException {
//    PhoneBillRestClient client = newPhoneBillRestClient();
//    String testWord = "TEST WORD";
//    String testDefinition = "TEST DEFINITION";
//    client.addDictionaryEntry(testWord, testDefinition);
//
//    String definition = client.getDefinition(testWord);
//    assertThat(definition, equalTo(testDefinition));
//  }
//
//  @Test
//  void test4MissingRequiredParameterReturnsPreconditionFailed() throws IOException {
//    PhoneBillRestClient client = newPhoneBillRestClient();
//    HttpRequestHelper.Response response = client.postToMyURL(Map.of());
//    assertThat(response.getHttpStatusCode(), equalTo(HttpURLConnection.HTTP_PRECON_FAILED));
//  }
}
