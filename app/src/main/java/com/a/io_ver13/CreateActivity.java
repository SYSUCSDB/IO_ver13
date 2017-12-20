package com.a.io_ver13;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Created by pengb on 2017/12/19.
 */

public class CreateActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_page);
        //add button event here
        Button button_date = (Button)findViewById(R.id.button_date_selecter);
        button_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*link create page here*/
                /*Intent intent = new Intent();
                intent.setClass(CreateActivity.this, DateSelecter.class);
                startActivity(intent);*/
                showDialog(1);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        Button button_time = (Button)findViewById(R.id.button_time_selecter);
        button_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                showDialog(2);
            }
        });
        };

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 1:
                return new DatePickerDialog(this, mdateListener, 2017, 12-1, 20);
            case 2:
                return new TimePickerDialog(this, mtimeListener, 18, 58, true);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            /*mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;*/
            Button button_date = (Button)findViewById(R.id.button_date_selecter);
            button_date.setText(new StringBuffer().append(year).append("-").append(monthOfYear+1).append("-").append(dayOfMonth));
        }
    };
    private TimePickerDialog.OnTimeSetListener mtimeListener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Button button_time = (Button)findViewById(R.id.button_time_selecter);
            button_time.setText(new StringBuffer().append(hourOfDay).append(":").append(minute));
        }
    };
}
