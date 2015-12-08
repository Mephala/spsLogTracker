package com.gokhanabi.dao;

import com.gokhanabi.prop.PropertyManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class ConnectionManager {

    private static ConnectionManager instance;
    private Logger logger = Logger.getLogger(this.getClass());
    private Connection connection ;
    private Connection localConnection;


    private ConnectionManager(){

    }

    public static synchronized  ConnectionManager getInstance(){
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }


    public Connection getLocalConnection() throws ClassNotFoundException, SQLException {
           String  jdbcUrl = PropertyManager.getInstance().getTestProperty("db.connection.jdbc");
        if (localConnection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            localConnection = DriverManager.getConnection(jdbcUrl);
        }
        return localConnection;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String jdbcUrl = PropertyManager.getInstance().getProperty("db.connection.jdbc");
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl);
        }
        return connection;
    }



}
