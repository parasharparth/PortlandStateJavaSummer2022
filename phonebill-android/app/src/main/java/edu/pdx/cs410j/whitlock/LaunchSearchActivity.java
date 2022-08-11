package edu.pdx.cs410j.whitlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.util.Map;

public class LaunchSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_search);
    }

    public void searchphonecallbtn(View view) {
        Intent intent = new Intent(this, resultsActivity.class);
        EditText customer = findViewById(R.id.searchphonecall);
        if(customer.getText().toString().equals("")){
            Snackbar.make(view, "Enter valid Customer name", 1000).show();
            return;
        }
        File dir = getFilesDir();
        File file = new File(dir, customer.getText().toString() + ".txt");
        if(!file.exists()){
            Snackbar.make(view, "Phone Call for " + customer.getText().toString() + " does not exist", 1000).show();
            return;
        }
        EditText callerNumber = findViewById(R.id.searchcallernumber);
        EditText calleeNumber = findViewById(R.id.searchcalleenumber);

        if(callerNumber.getText().toString().equals("") && calleeNumber.getText().toString().length() > 0){
            Snackbar.make(view, "Enter valid search parameters", 1000).show();
            return;
        }
        else if (calleeNumber.getText().toString().equals("") && callerNumber.getText().toString().length() > 0){
            Snackbar.make(view, "Enter valid search parameters", 1000).show();
            return;
        }

        intent.putExtra("customer", customer.getText().toString());
        intent.putExtra("callerNumber", callerNumber.getText().toString());
        intent.putExtra("calleeNumber", calleeNumber.getText().toString());
        startActivity(intent);
    }

}