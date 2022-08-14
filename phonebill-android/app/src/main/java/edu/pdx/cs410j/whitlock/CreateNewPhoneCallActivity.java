package edu.pdx.cs410j.whitlock;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import edu.pdx.cs410J.ParserException;

public class CreateNewPhoneCallActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_phonecalls);
    }

    public void addPhonecallBtn(View view) throws ParserException, IOException {
        File dir = getFilesDir();
        EditText customer = findViewById(R.id.customer);
        EditText callerNumber = findViewById(R.id.caller);
        EditText calleeNumber = findViewById(R.id.callee);
        EditText beginDateTime = findViewById(R.id.beginDateTime);
        EditText endDateTime = findViewById(R.id.endDateTime);

        String[] beginDateTimeWords = beginDateTime.getText().toString().split(" ");
        System.out.println("print date 1" + Arrays.toString(beginDateTimeWords));
        String[] endDateTimeWords = endDateTime.getText().toString().split(" ");
        System.out.println("print date 2" + Arrays.toString(endDateTimeWords));

        if(customer.getText().toString().equals("")){
            Snackbar.make(view, "Enter valid Customer name", 1000).show();
            return;
        }
        if(callerNumber.getText().toString().equals("")){
            Snackbar.make(view, "Enter correct caller number", 1000).show();
            return;
        }
        if(calleeNumber.getText().toString().equals("")){
            Snackbar.make(view, "Enter correct callee number", 1000).show();
            return;
        }

        PhoneCall call = new PhoneCall();
        call.setCallerName(customer.getText().toString());
        call.setCallerNumber(callerNumber.getText().toString());
        call.setCalleeNumber(calleeNumber.getText().toString());
        call.setPhoneCallBeginDate(beginDateTimeWords[0]);
        call.setPhoneCallBeginTime(beginDateTimeWords[0], beginDateTimeWords[1], beginDateTimeWords[2]);
        call.setPhoneCallEndDate(endDateTimeWords[0]);
        call.setPhoneCallEndTime(endDateTimeWords[0], endDateTimeWords[1], endDateTimeWords[2]);

        TextParser parser = new TextParser(dir, customer.getText().toString() + ".txt", customer.getText().toString());
        PhoneBill parsedphonebill  = parser.parse();
        parsedphonebill.addPhoneCall(call);
        TextDumper dumper = new TextDumper(dir, customer.getText().toString() + ".txt");
        dumper.dump(parsedphonebill);


        customer.setText("");
        callerNumber.setText("");
        calleeNumber.setText("");
        beginDateTime.setText("");
        endDateTime.setText("");
        Snackbar.make(view, "Phonecall Added Successfully. Please search the phonecall details in SEARCH PHONECALL tab.", 3000).show();
    }

    /**
     * This method checks whether the dates and times in the text file are correct or not
     * @param date defines call date
     * @param time defines call time
     * @param ampm The time of the day (am or pm)
     */
    public static boolean checkdatetime(String date, String time, String ampm) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm am");
        String finaldatetime = date + " " + time + " " + ampm;
        try{
            Date d = formatter.parse(finaldatetime);
        }
        catch (ParseException e){
            System.err.println("Please verify the format for date time");
            return false;
        }
        return true;
    }

}



