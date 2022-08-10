package edu.pdx.cs410j.whitlock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
    }

    public void deletephonecall(View view) {
        EditText customer = findViewById(R.id.deletecustomer);
        if(customer.getText().toString().equals("")){
            Snackbar.make(view, "Enter valid Customer name", 1000).show();
            return;
        }
        File dir = getFilesDir();
        File f = new File(dir, customer.getText().toString() + ".txt");
        if (f.exists()){
            f.delete();
            Snackbar.make(view, "The Phonecall " + customer.getText().toString() + " has been deleted", 1000).show();
            customer.setText("");
        }
        else {
            Snackbar.make(view, "The Phonecall " + customer.getText().toString() + " does not exist", 1000).show();
            customer.setText("");
        }
    }
}