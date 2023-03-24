package edu.pdx.cs410J.vidyav2;

import edu.pdx.cs410J.ParserException;
import java.io.*;
import java.util.*;

/**
 * The main class that parses the command line and communicates with the
 * Phone Bill server using REST.
 */
public class Project4 {

    public static void main(String[] args) throws ParserException, IOException,NullPointerException {
        String fileName= "Project4_PrettyFile";

        for (String arg : args) {
            if (arg.equals("-README")) {
                HelperFunctions.readMeInfo();
                return;
            }
        }

        ArrayList<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));

        switch(commandLineArgs.size())
        {
            case 0:  System.err.println("No arguments!");
                     HelperFunctions.readMeInfo();
                     break;

            case 5:  if (BaseConditions.baseCondition5(commandLineArgs))
                      {
                         BaseConditions.baseCondition5Print(fileName,commandLineArgs);
                      }
                      break;

            case 12: if (BaseConditions.baseCondition12(commandLineArgs))
                      {
                         PhoneBillRestClient client= HelperFunctions.hostCalling(args);
                         BaseConditions.baseCondition12Print(client,commandLineArgs);
                      }
                      break;

            case 13: if (BaseConditions.baseCondition13(commandLineArgs))
                      {
                          PhoneBillRestClient client = HelperFunctions.hostCalling(args);
                          String customerName=commandLineArgs.get(1);
                          PhoneCall call= BaseConditions.baseCondition13Print(commandLineArgs);
                          if (HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs)) {
                                return;
                          }
                          client.addCustomer(customerName, call);
                      }
                      break;

            case 14:  if (BaseConditions.baseCondition14(commandLineArgs))
                       {
                            PhoneBillRestClient client = HelperFunctions.hostCalling(args);
                            String customerName = "";
                            PhoneCall call = BaseConditions.baseCondition14Print(commandLineArgs);
                            client.addCustomer(customerName,call);
                            if (HelperFunctions.checkValidityOfRequiredArgs(commandLineArgs))
                            {
                            return;
                            }
                        BaseConditions.baseCondition14Check(commandLineArgs, args);
                       }
                       break;

            case 15:  System.out.println("Extraneous Arguments.\nPlease check the number of arguments entered.");
                      break;

            default:  System.err.println("There are some missing arguments.");
                      HelperFunctions.readMeInfo();
                      break;
        }
    }
}