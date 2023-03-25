package edu.pdx.cs410j.whitlock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*********************************************************************************
 * Declare the public class 'readmeactivity' which extends 'AppCompatActivity'
 *********************************************************************************/
public class readmeactivity extends AppCompatActivity {

    /****************************************************************************************
     * Override the 'onCreate' method of 'AppCompatActivity'
     * Set the content view to be the XML layout defined in 'activity_readme_activity.xml'
     ****************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readme_activity);
    }
}