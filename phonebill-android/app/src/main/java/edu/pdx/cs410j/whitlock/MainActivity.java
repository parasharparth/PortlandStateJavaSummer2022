package edu.pdx.cs410j.whitlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/***************************************************************************************
 * This code defines the MainActivity class, which extends the AppCompatActivity class.
 * It is the main activity of the Android application.
 ***************************************************************************************/
public class MainActivity extends AppCompatActivity {

    /***********************************************************************************************
     * onCreate() This method is called when the activity is created
     * launchreadme() This method is called when the user clicks the "Read Me" button
     * launchaddphonecall() This method is called when the user clicks the "Add Phone Call" button
     * launchsearch() This method is called when the user clicks the "Search" button
     * launchdelete() This method is called when the user clicks the "Delete" button
     ***********************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchreadme(View view) {
        Intent intent = new Intent(this, readmeactivity.class);
        startActivity(intent);
    }

    public void launchaddphonecall(View view) {
        Intent intent = new Intent(this, CreateNewPhoneCallActivity.class);
        startActivity(intent);
    }

    public void launchsearch(View view) {
        Intent intent = new Intent(this, LaunchSearchActivity.class);
        startActivity(intent);
    }

    public void launchdelete(View view) {
        Intent intent = new Intent(this, DeleteActivity.class);
        startActivity(intent);
    }
}