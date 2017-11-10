package com.example.administrator.preapt.ui.activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.preapt.R;
import com.example.administrator.preapt.model.PreAptModel;
import com.example.administrator.preapt.model.PreAptTable;
import com.example.administrator.preapt.utils.DatabaseManager;

import java.util.List;


public class HomeActivity extends AppCompatActivity {


    private SQLiteDatabase database;
    private PreAptTable preAptTable;
    private List<PreAptModel> data;
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialize();
        insertData();
    }

    private void insertData() {



    }


    private void initialize() {


        DatabaseManager manager = DatabaseManager.getInstance();

        database = manager.openDatabase();

        preAptTable = new PreAptTable(database);

        data = preAptTable.getPurchasedProducts(1);



//        notifyPurchasedProducts(purchasedProducts);


        Log.d(TAG, "initialize: questions-----> " + data);

    }
}
