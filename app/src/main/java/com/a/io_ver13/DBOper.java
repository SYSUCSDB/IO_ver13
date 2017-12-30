package com.a.io_ver13;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/12/30.
 * 这个是用来调用的！
 */

public class DBOper {
    private DBConnector connector;
    public DBOper(Context context) {
        connector = new DBConnector(context);
    }
    //插入事件将接受一个EventData数据，注意event_id在此函数中无效
    public int insert(EventData eventdata) {
        int rtn = 0;
        SimpleDateFormat sdf= (SimpleDateFormat) SimpleDateFormat.getDateTimeInstance();
        int if_alarm = 0;
        if(eventdata.event_if_alarm) if_alarm = 1;
        SQLiteDatabase database = connector.getWritableDatabase();
        database.beginTransaction();
        try {
            database.execSQL("insert into EventData (event_title, event_date, event_if_alarm, event_note) values ('"+
                    eventdata.event_title+"','"+
                    sdf.format(eventdata.event_date)+"',"+
                    Integer.toString(if_alarm) + " ,'"+
                    eventdata.event_note + "')");
            database.setTransactionSuccessful();
            rtn = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            rtn = 0;
        } finally {
            database.endTransaction();
        }
        database.close();
        return rtn;
    }

    /*
        如何使用DBOper查询记录？
        在main_activity中：
            DBOper oper = new DBOper(this);
            Cursor c = oper.queryCursor();
        即获得数据库游标，如果想得到记录总数，则可使用：
            int all_the_events = c.getCount();
     */

    public Cursor queryCursor() {
        Cursor c = null;
        SQLiteDatabase database = connector.getReadableDatabase();
        c = database.rawQuery("select * from EventData",null);
        return c;
    }



}
