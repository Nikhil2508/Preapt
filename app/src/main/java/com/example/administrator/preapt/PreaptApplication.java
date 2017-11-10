package com.example.administrator.preapt;

import android.app.Application;
import android.database.SQLException;

import com.example.administrator.preapt.utils.DataBaseHelper;
import com.example.administrator.preapt.utils.DatabaseManager;

import java.io.IOException;

/**
 * Created by Administrator on 11/10/2017.
 */

public class PreaptApplication  extends Application{


    @Override
    public void onCreate() {
        super.onCreate();

        DataBaseHelper helper = new DataBaseHelper(this);
        DatabaseManager.initializeInstance(helper);

    }
}
