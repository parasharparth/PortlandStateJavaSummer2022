package edu.pdx.cs410j.whitlock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import edu.pdx.cs410J.ParserException;

public class resultsActivity extends AppCompatActivity {

    String customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        File dir = getFilesDir();
        Intent intent = getIntent();
        customer = intent.getStringExtra("customer");
        String callerNumber = intent.getStringExtra("callerNumber");
        String calleeNumber = intent.getStringExtra("calleeNumber");

        ListView listView = findViewById(R.id.resultsview);
        ArrayAdapter<PhoneCall> adapter = new PhoneCallAdapter(this);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
        TextParser parser = new TextParser(dir, customer + ".txt", customer);
        PhoneBill parsedphonebill = null;
        try {
            parsedphonebill = (PhoneBill) parser.parse();
        } catch (ParserException e) {
            e.printStackTrace();
        }
        ArrayList<PhoneCall> calls = parsedphonebill.getPhoneCalls();
        ArrayList<PhoneCall> temp = new ArrayList<>();

        if (callerNumber.equals("") && calleeNumber.equals("")) {
            for (PhoneCall f : calls) {
                adapter.add(f);
                temp.add(f);
            }
        } else {
            for (PhoneCall call : calls) {
                if (call.getCallerNumber().equals(callerNumber) && call.getCalleeNumber().equals(calleeNumber)) {
                    adapter.add(call);
                    temp.add(call);
                }
            }
        }
        if (temp.size() == 0) {
            adapter2.add("No flights found!");
            listView.setAdapter(adapter2);
        } else {
            listView.setAdapter(adapter);
        }
    }

    class PhoneCallAdapter extends ArrayAdapter<PhoneCall> {

        public PhoneCallAdapter(@NonNull Context context) {
            super(context, R.layout.phonecall_view);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View phonecallview, @NonNull ViewGroup parent) {
            PrettyPrinter pretty = new PrettyPrinter();
            if (phonecallview == null){
                phonecallview = getLayoutInflater().inflate(R.layout.phonecall_view, parent, false);
            }
            PhoneCall call = getItem(position);
            TextView number = phonecallview.findViewById(R.id.phonecallview);
            number.setText(pretty.getpretty(call, customer));
            return phonecallview;
        }
    }
}