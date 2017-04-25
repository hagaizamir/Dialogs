package hagai.edu.dialogs;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.provider.Settings;
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
        switch (which){
            case AlertDialog.BUTTON_POSITIVE:
                Toast.makeText(this, "Quiting",Toast.LENGTH_SHORT).show();
                System.exit(0);
                break;
            case AlertDialog.BUTTON_NEGATIVE:
                Toast.makeText(this, "Staying",Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void showListDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final String[] colors = {"Red" , "Green", "Blue"};

        builder.setTitle("Pick A Color");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(colors, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectColor = colors[which];
                Toast.makeText(MainActivity.this,selectColor,Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();
    }

    public void toppings(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String [] toppings = {"Onion" , "Tomato" , "Lettuce"};

        builder.setTitle("Pick A Toppings").setMessage("Do you wish to quit")
                .setPositiveButton("Quit",this)
                .setNegativeButton("Stay",this);
        ;

        builder.setMultiChoiceItems(R.array.toppings, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                switch (which){
                    case AlertDialog.BUTTON_POSITIVE:
                        Toast.makeText(this, "Stay",Toast.LENGTH_SHORT).show();
                        System.exit(0);
                        break;
                    case AlertDialog.BUTTON_NEGATIVE:
                        Toast.makeText(this, "Quit",Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });

    }
}
