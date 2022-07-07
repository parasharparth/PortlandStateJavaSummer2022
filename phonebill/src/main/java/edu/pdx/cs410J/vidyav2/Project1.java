package edu.pdx.cs410J.vidyav2;

import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1 {
  static final String README = "This is my README. Your's should be much better!";
  @VisibleForTesting
  static boolean isValidPhoneNumber(String phoneNumber) {
    return true;
  }

  public static void main(String[] args) {
    PhoneCall call = new PhoneCall();  // Refer to one of Dave's classes so that we can be sure it is on the classpath

    if (args.length == 0) {
      System.err.println("Missing command line arguments");
      return;
    }

    if (containsOption(args, "-README")) {
      printReadme();
      return;
    }

      if (containsOption(args, "-print")) {
        printTotallyBogusPhoneCallForTestingPurposesOnly();
      }

  }

    private static void printTotallyBogusPhoneCallForTestingPurposesOnly() {
      String phoneBillToString = "Phone call from 123-456-7890 to 234-567-8901 from 07/04/2018 6:24 to 07/04/2018 6:48";
      System.out.println(phoneBillToString);
    }

    private static void printReadme() {
      System.out.println(README);
    }

    private static boolean containsOption(String[] args, String option) {
      return Arrays.asList(args).contains(option);
    }

  }