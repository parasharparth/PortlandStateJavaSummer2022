package edu.pdx.cs410j.whitlock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //static PhoneBillCollection pBills;
//    Button createPhoneCall;
//    Button displayPhoneBill;
//    Button searchPhoneCalls;
//    Button help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
//    @Override
//    public void onStart(){
//        super.onStart();
//
////        createPhoneCall = findViewById(R.id.create_new_phone_call);
////        displayPhoneBill = findViewById(R.id.display_phonebill_button);
////        searchPhoneCalls = findViewById(R.id.search_phonecalls_button);
////        help = findViewById(R.id.help_button);
//    }

    public void launchReadMe(View view) {
        Intent intent = new Intent(this, CreateNewPhoneCallActivity.class);
        startActivity(intent);
    }


}