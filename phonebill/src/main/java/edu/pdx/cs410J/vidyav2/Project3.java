package edu.pdx.cs410J.vidyav2;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The main class for the CS410J phone bill Project
 */

public class Project3 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));

        boolean readMeFlag = HelperFunctions.readMeFlagCheck(args);

        if (readMeFlag)
        {
            String FileContentReadMe = HelperFunctions.readFromReadMeFileOnlyProject3();
            System.out.println(FileContentReadMe);
            HelperFunctions.printGenericMessage();
        }

        if (commandLineArgs.size() < 11)
        {
            HelperFunctions.printGenericMessage();
        }

        switch(commandLineArgs.size()){
            case 0: System.out.println("\nNo arguments passed at the command line.\n");
                    HelperFunctions.printGenericMessage();
                    break;

            case 11: if(BaseConditions.baseCondition11TextDump(commandLineArgs))
                    {
                        String fileName = commandLineArgs.get(commandLineArgs.indexOf("-textFile")+1);
                        TextDumper dumper = new TextDumper();
                        TextParser parser = new TextParser(fileName, commandLineArgs.get(commandLineArgs.indexOf("-textFile")+1));
                        parser.setFilename(fileName);
                        dumper.setFileName(fileName);
                        parser.setCustomerName(commandLineArgs.get(2));
                        PhoneBill bill = parser.parse();
                        PhoneCall call = new PhoneCall();
                        BaseConditions.Caller(commandLineArgs, call);
                        bill.addPhoneCall(call);
                        dumper.dump(bill);
                        System.out.println("\nA new file called "+ fileName +" is created." );
                    }
                    else if ((commandLineArgs.get(1).contains("-")))
                    {
                        String fileName = commandLineArgs.get(commandLineArgs.indexOf("-pretty")+1);
                        TextDumper dumper = new TextDumper();
                        dumper.setFileName(fileName);
                        PhoneBill bill = new PhoneBill(commandLineArgs.get(2));
                        PhoneCall call = new PhoneCall();
                        BaseConditions.Caller(commandLineArgs, call);
                        bill.addPhoneCall(call);
                        PrettyPrinter printer = new PrettyPrinter();
                        System.out.println("\nThis is a pretty file, printing the following Phone details:\n" + printer.getPretty(call, bill.getCustomer()));
                    }
                    break;

            case 12: BaseConditions.baseCondition12(commandLineArgs);
                     break;

            case 13: if (BaseConditions.baseCondition13Dump(commandLineArgs))
                     {
                         BaseConditions.baseCondition13PrettyFileDump(commandLineArgs);
                     }
                     else if (BaseConditions.baseCondition13(commandLineArgs))
                     {
                         BaseConditions.baseCondition13FileDump(commandLineArgs);
                     }
                     break;

            default : System.err.println("Extraneous or wrong arguments are being printed, this is not allowed.");
                      break;
        }
    }
}
