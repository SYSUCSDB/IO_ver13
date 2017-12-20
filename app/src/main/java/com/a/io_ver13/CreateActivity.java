package com.a.io_ver13;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * Created by pengb on 2017/12/19.
 */

public class CreateActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_page);
        //add button event here
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
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
    }
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 1:
                return new DatePickerDialog(this, mdateListener, 2017, 12-1, 20);
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
            Button button1 = (Button)findViewById(R.id.button_date_selecter);
            button1.setText(new StringBuffer().append(year).append("-").append(monthOfYear+1).append("-").append(dayOfMonth));
        }
    };
}
