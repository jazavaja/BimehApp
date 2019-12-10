package com.javad.mrbimeh;

import android.app.Application;
import ir.tapsell.sdk.Tapsell;

public class App extends Application {
    public void onCreate() {
        super.onCreate();
        Tapsell.initialize((Application) this, "mimnldtbrakirfifekggpfnbimbtjonmqescarioramnjgbqhajgrotljelhicrrqhqses");
    }
}
