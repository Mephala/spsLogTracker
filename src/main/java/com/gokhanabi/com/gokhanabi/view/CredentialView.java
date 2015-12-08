package com.gokhanabi.com.gokhanabi.view;

import com.gokhanabi.com.gokhanabi.util.CommonUtils;
import com.gokhanabi.prop.PropertyManager;

import javax.swing.*;

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
        pack();
        setVisible(true);
    }
}
