package hagai.edu.dialogs;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pickTheTime(View view) {
        TimePickerDialog dialog = new TimePickerDialog(this,
                this,10,22,true);
        dialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this,"Saved!", Toast.LENGTH_SHORT).show();

    }

    public void showStandardDialog(View view) {
        //title, message , positiveButton , negativeButton

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("The app requiers Internet to proceed")
                .setMessage("Do you wish to quit")
                .setPositiveButton("Quit",this)
                .setNegativeButton("Stay",this);

        AlertDialog dialog = builder.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
