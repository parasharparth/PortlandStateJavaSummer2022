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
            Snackbar.make(view, "Enter valid Airline name", 1000).show();
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

//        if(source.getText().toString().length() > 0 && dest.getText().toString().length() > 0){
//            if(!checkairportcode(source.getText().toString()) || !checkairportcode(dest.getText().toString())){
//                Snackbar.make(view, "Check the Airport codes", 1000).show();
//                return;
//            }
//        }

        intent.putExtra("customer", customer.getText().toString());
        intent.putExtra("callerNumber", callerNumber.getText().toString());
        intent.putExtra("calleeNumber", calleeNumber.getText().toString());
        startActivity(intent);
    }

//    /**
//     * This method checks whether the airport codes in the text file are correct or not
//     * @param source the airport code of a source or a destination
//     */
//    public static boolean checkairportcode(String source) {
//        String sourceuppercase = source.toUpperCase();
//        Map names = AirportNames.getNamesMap();
//        if(!names.containsKey(sourceuppercase)){
//            System.err.println("The three-letter airport code is invalid");
//            return false;
//        }
//        else{
//            return true;
//        }
//    }
}