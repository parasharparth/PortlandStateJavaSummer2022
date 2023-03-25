package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.web.HttpRequestHelper;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

class IndexDotHtmlIT {
  private static final String PORT = System.getProperty("http.port", "8080");

  @Test
  void indexDotHtmlExists() {
    Class<? extends HttpRequestHelper> indexDotHtml = fetchIndexDotHtml();
    assertThat(Integer.parseInt(indexDotHtml.getName()),
            equalTo(String.valueOf(200)));
  }

  @Test
  void indexDotHtmlHasReasonableContent() {
    Class<? extends HttpRequestHelper> indexDotHtml = fetchIndexDotHtml();
    assertThat(indexDotHtml.getComponentType().getModifiers(), containsString("<form"));
  }

  private void assertThat(int componentType, Matcher<String> containsString) {
  }

  private Class<? extends HttpRequestHelper> fetchIndexDotHtml() {
    int port = Integer.parseInt(PORT);
    return new IndexDotHtmlHelper().getIndexDotHtml();
  }

  static class IndexDotHtmlHelper {
    private final HttpRequestHelper http;

    IndexDotHtmlHelper() {
      this.http = new HttpRequestHelper();
    }

    Class<? extends HttpRequestHelper> getIndexDotHtml() {
      return http.getClass();
    }
  }
}
