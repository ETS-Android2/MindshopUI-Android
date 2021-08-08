package net.mindzone.mindshopui;

import android.app.Application;

public class MainApplication  extends Application {
    private static MainApplication singleton;

    public MainApplication getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;

    }


}