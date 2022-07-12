package edu.pdx.cs410J.vidyav2;

import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class Project1 {
  static final String README = "This is my README that prints basic information.";
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
        printDummyPhoneCallForTestingPurposesOnly();
      }

  }

    private static void printDummyPhoneCallForTestingPurposesOnly() {
      String phoneBillToString = "Registered phone call from 123-456-7890 to 234-567-8901 from 07/07/2022 7:12 to 07/07/2022 7:56";
      System.out.println(phoneBillToString);
    }

    private static void printReadme() {
      System.out.println(README);
    }

    private static boolean containsOption(String[] args, String option) {
      return Arrays.asList(args).contains(option);
    }

  }