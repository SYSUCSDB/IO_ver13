package com.a.io_ver13;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //initialize data here
    public int event_id;
    public String event_title;
    public Date event_date;
    public Time event_time;
    public boolean event_if_alarm;
    public String event_note;
    public boolean i = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*link create page here*/
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CreateActivity.class);
                startActivityForResult(intent, 1);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent return_intent) {
        super.onActivityResult(requestCode, resultCode, return_intent);
        if(resultCode == 2) {
            if(requestCode == 1) {
                event_title = return_intent.getStringExtra("m_event_title");
                event_note = return_intent.getStringExtra("m_event_note");
                i = return_intent.getBooleanExtra("i",false);
                TextView show_title = (TextView)findViewById(R.id.show_title);
                show_title.setText(event_title);
                TextView show_note = (TextView)findViewById(R.id.show_note);
                show_note.setText(event_note);
                /*Button btn_confirmed = (Button)findViewById(R.id.button_confirm);
                if(i)
                    btn_confirmed.setText("yes");
                else
                    btn_confirmed.setText("nooooooo!");*/

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}

