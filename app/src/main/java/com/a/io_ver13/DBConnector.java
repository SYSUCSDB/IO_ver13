package com.a.io_ver13;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/12/30.
 * 这个不是用来给别的activity调用的~
 */

public class DBConnector extends SQLiteOpenHelper {
    private final static int VERSION = 1;
    private final static String DATABASE_NAME = "localevents.db";

    public DBConnector(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table EventData (event_id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "event_title varchar(255),\n" +
                "event_date varchar(255),\n" +
                "event_if_alarm integer,\n" +
                "event_note varchar(255))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        this.onDelete(db);
        this.onCreate(db);
    }

    public void onDelete(SQLiteDatabase db) {
        db.execSQL("drop table if exists EventData");
    }
}
