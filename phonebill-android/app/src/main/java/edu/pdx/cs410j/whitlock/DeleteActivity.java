package edu.pdx.cs410j.whitlock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;

/******************************************************************************
 * This allows the user to delete a phone call record for a specified customer.
 ******************************************************************************/
public class DeleteActivity extends AppCompatActivity {

    /*********************************************************************************************************
     * Called when the activity is created. This method sets the content view to the layout
     * defined in activity_delete.xml.
     * @param savedInstanceState If the activity is being re-initialized after previously being
     * shut down, then this Bundle contains the data it most recently
     * supplied in onSaveInstanceState(Bundle). Otherwise, it is null.
     * deletephonecall() This method is called when the "Delete Phonecall" button is clicked
     * Find the EditText view that contains the customer name
     * Check if the customer name is empty
     * Get the directory where the phone call files are stored
     * If the file does not exist, show a snackbar message indicating that the phone call does not exist
     * Clear the EditText view that contains the customer name
     *********************************************************************************************************/
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