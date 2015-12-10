package com.gokhanabi.main;

import com.gokhanabi.data.AppData;
import com.gokhanabi.view.CredentialView;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);
    private static JFrame loginFrame;
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        logger.info("App has started running...");
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                loginFrame =new CredentialView();
                loginFrame.addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent e)
                    {
                        logger.info("Login frame closed, aborting app.");
                        e.getWindow().dispose();
                        System.exit(0);
                    }
                });
            }
        }).start();

        while (!AppData.getInstance().isLoginCompleted()) ;

        logger.info("Login success.");
        loginFrame.setVisible(false);
        loginFrame.dispose();
        logger.info("Login Frame disposed.");




    }
}
