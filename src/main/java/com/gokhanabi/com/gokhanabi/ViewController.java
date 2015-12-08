package com.gokhanabi.com.gokhanabi;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class ViewController {

    private static ViewController instance;

    private ViewController(){}

    public static synchronized ViewController getInstance(){
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }


    public boolean loginUser(String userName, String password){
        return userName.equals("gokhanabi");
    }


}
