package edu.pdx.cs410J.vidyav2;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static edu.pdx.cs410J.vidyav2.PhoneBillServlet.DEFINITION_PARAMETER;
import static edu.pdx.cs410J.vidyav2.PhoneBillServlet.WORD_PARAMETER;
import static groovy.test.GroovyTestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

/**
 * A unit test for the {@link PhoneBillServlet}.  It uses mockito to
 * provide mock http requests and responses.
 */
class PhoneBillServletTest {

  private PhoneBillServlet servlet;
  private HttpServletRequest request;
  private HttpServletResponse response;
  @Before
  public void setUp() {
    servlet = new PhoneBillServlet();
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
  }

  @Test
  void initiallyServletContainsNoDictionaryEntries() throws IOException {
    PhoneBillServlet servlet = new PhoneBillServlet();

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    PrintWriter pw = mock(PrintWriter.class);

    when(response.getWriter()).thenReturn(pw);

    servlet.doGet(request, response);

    verify(pw, never()).println(anyString());
    verify(response).setStatus(HttpServletResponse.SC_OK);
  }

  @Test
  void addOneWordToDictionary() throws IOException {
    PhoneBillServlet servlet = new PhoneBillServlet();

    String word = "TEST WORD";
    String definition = "TEST DEFINITION";

    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getParameter(WORD_PARAMETER)).thenReturn(word);
    when(request.getParameter(DEFINITION_PARAMETER)).thenReturn(definition);

    HttpServletResponse response = mock(HttpServletResponse.class);
    StringWriter stringWriter = new StringWriter();
    PrintWriter pw = new PrintWriter(stringWriter, true);

    when(response.getWriter()).thenReturn(pw);

    servlet.doPost(request, response);

    assertThat(stringWriter.toString(), containsString(Messages.definedWordAs(word, definition)));

    ArgumentCaptor<Integer> statusCode = ArgumentCaptor.forClass(Integer.class);
    verify(response).setStatus(statusCode.capture());

    assertThat(statusCode.getValue(), equalTo(HttpServletResponse.SC_OK));

    assertThat(servlet.getDefinition(word), equalTo(definition));
  }

  @Test
  void creatingDefinitionWithMissingParameterResultsInPreconditionFailed() throws IOException {
    PhoneBillServlet servlet = new PhoneBillServlet();

    HttpServletRequest request = mock(HttpServletRequest.class);

    HttpServletResponse response = mock(HttpServletResponse.class);

    StringWriter stringWriter = new StringWriter();
    PrintWriter pw = new PrintWriter(stringWriter, true);

    when(response.getWriter()).thenReturn(pw);

    servlet.doPost(request, response);

    ArgumentCaptor<Integer> statusCode = ArgumentCaptor.forClass(Integer.class);
    ArgumentCaptor<String> message = ArgumentCaptor.forClass(String.class);
    verify(response).sendError(statusCode.capture(), message.capture());

    assertThat(message.getValue(), equalTo(Messages.missingRequiredParameter(WORD_PARAMETER)));
  }

  @Test
  public void testDoGetWithWordParameter() throws IOException {
    Map<String, String> dictionary = new HashMap<>();
    dictionary.put("test", "this is a test definition");
    servlet.dictionary = dictionary;

    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    when(response.getWriter()).thenReturn(printWriter);
    when(request.getParameter("word")).thenReturn("test");

    servlet.doGet(request, response);

    verify(response).setContentType("text/plain");
    verify(response).setStatus(HttpServletResponse.SC_OK);
    assertEquals(TextDumper.formatDefinition("test", "this is a test definition"), stringWriter.toString().trim());
  }

  @Test
  public void testDoGetWithoutWordParameter() throws IOException {
    Map<String, String> dictionary = new HashMap<>();
    dictionary.put("test", "this is a test definition");
    servlet.dictionary = dictionary;

    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    when(response.getWriter()).thenReturn(printWriter);

    servlet.doGet(request, response);

    verify(response).setContentType("text/plain");
    verify(response).setStatus(HttpServletResponse.SC_OK);
    assertEquals(Messages.dumpDictionary(dictionary), stringWriter.toString().trim());
  }

}
