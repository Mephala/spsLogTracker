package com.gokhanabi.view;

import com.gokhanabi.controller.ViewController;
import com.gokhanabi.data.AppData;
import com.gokhanabi.exception.LogTrackerException;
import com.gokhanabi.util.CommonUtils;
import com.gokhanabi.prop.PropertyManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class CredentialView extends  JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel loginPanel;

    public CredentialView(){
        super("Please Login");
        setContentPane(loginPanel);
        String appIcon = PropertyManager.getInstance().getProperty("icon.imageIcon");
        ImageIcon imageIcon = CommonUtils.createImageIcon(appIcon,"appIcon");
        setIconImage(imageIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CommonUtils.centralizeJFrame(this);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String username = textField1.getText();
                    String password = new String(passwordField1.getPassword());
                    boolean login = ViewController.getInstance().loginUser(username,password );
                    if(!login){
                        JOptionPane.showMessageDialog(null,"Wrong credentials", "Failed to login", JOptionPane.ERROR_MESSAGE);
                    }else{
                        CredentialView.this.setVisible(false);
                        CredentialView.this.dispose();
                        AppData.getInstance().loginCompleted();
                    }
                } catch (LogTrackerException e1) {
                   JOptionPane.showMessageDialog(null,"Failure:"+ e1.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pack();
        setVisible(true);
    }
}
