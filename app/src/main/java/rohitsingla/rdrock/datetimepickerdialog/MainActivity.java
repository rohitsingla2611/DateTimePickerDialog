package rohitsingla.rdrock.datetimepickerdialog;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    TextView textViewDate, textViewTime;
    Button buttonDatePicker, buttonTimePicker;
    DialogFragment datePicker, timePicker;
    Calendar calendarDate, calendarTime;
    String strCurrentDate, strCurrentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        textViewDate = findViewById(R.id.textViewDate);
        textViewTime = findViewById(R.id.textViewTime);
        buttonDatePicker = findViewById(R.id.buttonDatePicker);
        buttonTimePicker = findViewById(R.id.buttonTimePicker);
        calendarDate = Calendar.getInstance();
        datePicker = new DatePickerFragment();
        timePicker = new TimePickerFragment();

        buttonDatePicker.setOnClickListener(this);
        buttonTimePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonDatePicker) {

            datePicker.show(getSupportFragmentManager(), "Date Picker");
        } else if (view.getId() == R.id.buttonTimePicker) {
            timePicker.show(getSupportFragmentManager(), "Time Picker");
        }

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        calendarDate.set(Calendar.YEAR, year);
        calendarDate.set(Calendar.MONTH, month);
        calendarDate.set(Calendar.DAY_OF_MONTH, day);
        strCurrentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendarDate.getTime());
        textViewDate.setText(strCurrentDate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
     
        textViewTime.setText(hour + ":" + minutes);

    }
}
