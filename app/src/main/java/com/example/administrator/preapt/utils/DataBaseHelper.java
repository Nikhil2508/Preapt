package com.example.administrator.preapt.utils;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.preapt.model.PreAptModel;
import com.example.administrator.preapt.model.PreAptTable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 11/10/2017.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    //     private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
    private static String DB_NAME = "Preapt";// Database name
    private static int VERSION = 1;


    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(PreAptTable.creatTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
