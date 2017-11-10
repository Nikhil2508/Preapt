package com.example.administrator.preapt.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.administrator.preapt.utils.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/10/2017.
 */

public class PreAptTable {

    private SQLiteDatabase database;

    private static String TABLE_NAME = "preapt";

    private static String Question = "Question";
    private static String mcq1 = "mcq1";
    private static String mcq2 = "mcq2";
    private static String mcq3 = "mcq3";
    private static String mcq4 = "mcq4";
    private static String correct = "correct";
    private static String module = "module";


    public PreAptTable(SQLiteDatabase database) {
        this.database = database;
    }


    public static String creatTable() {

        String query = " Create table " + TABLE_NAME + " ( " +
                module + " integer PRIMARY KEY," +
                Question + " varchar," +
                mcq1 + " varchar," +
                mcq2 + " varchar," +
                mcq3 + " varchar," +
                mcq4 + " varchar," +
                correct + " integer " +
                ");";
        return query;
    }


    public List<PreAptModel> getPurchasedProducts(int moduleNumber) {

        List<PreAptModel> list = new ArrayList<>();
        String query = "Select " + Question + " , " + mcq1 + " , " + mcq2 + " , " + mcq3 + " , " + correct +" , " + module +  " from " + TABLE_NAME + " where module IS " + moduleNumber;

        Cursor cursor = null;
        database = DatabaseManager.getInstance().openDatabase();
        cursor = database.rawQuery(query, null);

        if (cursor != null) {

            while (cursor.moveToNext()) {
                PreAptModel model = new PreAptModel();
                model.question = cursor.getString(0);
                model.mcq1 = cursor.getString(1);
                model.mcq2 = cursor.getString(2);
                model.mcq3 = cursor.getString(3);
                model.mcq4 = cursor.getString(4);
                model.correct = String.valueOf(cursor.getInt(4));
                list.add(model);

            }
        } else {
            return null;
        }

        return list;
    }


    public boolean insertData(PreAptModel model) {

        long result = 0;

        if (model == null) {
            return false;
        } else {
            database = DatabaseManager.getInstance().openDatabase();

            ContentValues values = new ContentValues();
            values.put(Question, model.question);
            values.put(module, model.module);
            values.put(mcq1, model.mcq1);
            values.put(mcq2, model.mcq2);
            values.put(mcq3, model.mcq3);
            values.put(mcq4, model.mcq4);
            values.put(correct, model.correct);


            try {
                database.beginTransaction();
                result = database.insert(TABLE_NAME, null, values);
                database.setTransactionSuccessful();
            } catch (SQLiteException e) {

            } finally {
                database.endTransaction();
                DatabaseManager.getInstance().closeDatabase();

            }


            if (result != -1) {
                return true;
            } else {
                return false;

            }


        }
    }
}
