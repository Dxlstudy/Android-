package com.example.justloginregistertest;

import android.app.Application;
import com.facebook.stetho.Stetho;


public class JustLoginRegisterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
