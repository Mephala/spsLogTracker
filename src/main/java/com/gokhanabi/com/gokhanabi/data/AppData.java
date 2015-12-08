package com.gokhanabi.com.gokhanabi.data;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class AppData {
    private static AppData ourInstance = new AppData();
    private AtomicBoolean loginComplete = new AtomicBoolean(false);

    public static AppData getInstance() {
        return ourInstance;
    }

    private AppData() {
    }

    public void loginCompleted(){
        this.loginComplete.set(true);
    }

    public boolean isLoginCompleted(){
        return  this.loginComplete.get();
    }


}
