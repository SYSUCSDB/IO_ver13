package com.a.io_ver13;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Message;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.text.SimpleDateFormat;
;

/**
 * Created by Administrator on 2017/12/26.
 */

public class FilesSystem {
    private static File dirFirstFolder = Environment.getDataDirectory();
    // 保存头像到本地
    public static void saveData(EventData data) {
        try {
            FileOutputStream out = new FileOutputStream(dirFirstFolder,true);
            OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            SimpleDateFormat sdf= (SimpleDateFormat) SimpleDateFormat.getDateInstance();
            SimpleDateFormat sde = (SimpleDateFormat) SimpleDateFormat.getTimeInstance();
            String mydata =  Integer.toString(data.event_id) + ','+ data.event_title +','+
                    sdf.format(data.event_date)+ ',' + /*sde.format(data.event_time)+
                    ',' +*/ data.event_note + "\n";
            bw.write(mydata);
            bw.close();
            osw.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EventData readData() {
        EventData data = new EventData();
        data.event_note = "just a test";
        //返回的是事件数组。先获取字符串行数组，有length确定事件数组长度，然后逐渐分割。
        return data;
    }
}
