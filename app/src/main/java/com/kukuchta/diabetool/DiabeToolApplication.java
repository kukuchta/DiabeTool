package com.kukuchta.diabetool;

import android.app.Application;

import com.kukuchta.diabetool.data.db.AppDatabase;

public class DiabeToolApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the database when the app starts.
        // This will create the database file on its first run.
        AppDatabase.getInstance(this);
    }
}
