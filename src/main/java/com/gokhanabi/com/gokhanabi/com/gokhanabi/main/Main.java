package com.gokhanabi.com.gokhanabi.com.gokhanabi.main;

import com.gokhanabi.com.gokhanabi.data.AppData;
import com.gokhanabi.com.gokhanabi.view.CredentialView;

import javax.swing.*;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class Main {


    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                new CredentialView();
            }
        }).start();

        while (!AppData.getInstance().isLoginCompleted()) ;

        System.out.println("Hi.");



    }
}
