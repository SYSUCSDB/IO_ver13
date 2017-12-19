package com.a.io_ver13;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

/**
 * Created by lenovo on 2017/12/19.
 */

public class DateSelecter extends DatePickerDialog {
    public DateSelecter(Context context, OnDateSetListener callback, int year, int month, int day){
        super(context, callback, year, month, day);

        this.setTitle("Select reminding date");
        this.setButton2("Cancle", (OnClickListener)null);
        this.setButton("Confirm", this);
    }
    public void onDateChanged(DatePicker view, int year, int month, int day){
        super.onDateChanged(view, year, month, day);
        this.setTitle("Select reminding date");
    }
}
