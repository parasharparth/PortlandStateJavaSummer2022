package edu.pdx.cs410j.whitlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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