package com.a.io_ver13;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.a.io_ver13.R.id.action_settings;


public class MainActivity extends AppCompatActivity{
    //initialize data here
    public final int CREATE_REQUEST = 1;
    public final int CREATE_RESULT = 2;
    public int event_id;
    public String event_title;
    public Date event_date;
    public Time event_time;
    public boolean event_if_alarm;
    public String event_note;
    public boolean i = false;

    public EventData a;

    private ListView listView;
    private DBOper dbOper;
    private ArrayList<EventData> eventlist;
    private  SimpleAdapter adapter;

    private static final String[] title = {"事件1", "事件2", "事件3", "事件4", "事件5", "事件6", "事件7", "事件8", "事件9", "事件10"};
    private static final String[] date = {"2017-12-30 23:59:59", "2017-12-30 23:59:59", "2017-12-30 23:59:59", "2017-12-30 23:59:59", "2017-12-30 23:59:59", "2017-12-30 23:59:59", "2017-12-30 23:59:59", "2017-12-30 23:59:59", "2017-12-30 23:59:59", "2017-12-30 23:59:59"};
    private static final String[] note = {"1111", "1111", "1111", "1111", "1111", "1111", "1111", "1111", "1111", "1111"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.card_listView);
        a = new EventData();
        initView();
        dbOper = new DBOper(this);
        try {
            eventlist = dbOper.query();
        } catch (ParseException e) {
            e.printStackTrace();
        }
       final List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for(int i = 0; i < /*eventlist.size()*/title.length; i++) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            //数据库读取
            /*EventData temp = eventlist.get(i);
            item.put("data1", temp.get_event_title());
            item.put("data2", temp.get_event_data());
            item.put("data3", temp.get_event_note());
            item.put("data4", R.mipmap.tu);*/
            //数组测试
            item.put("data1", title[i]);
            item.put("data2", date[i]);
            item.put("data3", note[i]);
            item.put("data4", getResource(i));
            list.add(item);
        }
        adapter = new SimpleAdapter(this, list, R.layout.list_item_card, new String[]{"data1", "data2", "data3", "data4"}, new int[]{R.id.title, R.id.date, R.id.note, R.id.image});
        //添加头和尾
        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));
        listView.setAdapter(adapter);

        //删除
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //数据库删除
                /*dbOper.delete(eventlist.get(i));
                try {
                    eventlist = dbOper.query();
                } catch (ParseException e) {
                    e.printStackTrace();
                }*/
                //数组删除
                list.remove(i-1);
                ((BaseAdapter)adapter).notifyDataSetChanged();
                return true;
            }
        });

        FloatingActionButton fab;
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*link create page here*/
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CreateActivity.class);
                startActivityForResult(intent, CREATE_REQUEST);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        Toolbar menu = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(menu);

        menu.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_settings:
                        //Toast.makeText(MainActivity.this, "yes!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, Settings.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
                return true;
            }
        });

    }

    private int getResource(int index) {
        int res;
        //if(index%2 == 0) {
            res = R.mipmap.tu;
       /* }
        else {
            res = R.mipmap.icon;
        }*/
        return res;
    };

    private void initView() {
        listView = (ListView)findViewById(R.id.card_listView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent return_intent) {
        super.onActivityResult(requestCode, resultCode, return_intent);
        if(resultCode == CREATE_RESULT) {
            if(requestCode == CREATE_REQUEST) {
                //event_title = return_intent.getStringExtra("m_event_title");
                //event_note = return_intent.getStringExtra("m_event_note");
                //i = return_intent.getBooleanExtra("i",false);
                TextView show_title = (TextView)findViewById(R.id.show_title);
                //show_title.setText(event_title);
                TextView show_note = (TextView)findViewById(R.id.show_note);
                //show_note.setText(event_note);
                /*Button btn_confirmed = (Button)findViewById(R.id.button_confirm);
                if(i)
                    btn_confirmed.setText("yes");
                else
                    btn_confirmed.setText("nooooooo!");*/
                //DBOper oper = new DBOper(this);
                //Cursor c = oper.queryCursor();
                //在这个地方把a里的数据赋成数据库里读到的，可以用那两行字测试
                a.set_event_title("title");
                a.set_event_note("note");
                show_title.setText(a.get_event_title());
                show_note.setText(a.get_event_note());
            }
        }

        //点击确认后执行以下更新操作：
        //重新查询数据库
        try {
            eventlist = dbOper.query();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //刷新数据适配器
        adapter.notifyDataSetChanged();

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
        if (id == action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

