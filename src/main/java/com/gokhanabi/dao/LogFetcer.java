package com.gokhanabi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class LogFetcer {

public static List<ControllerLog> getLatestControllerLogs(Integer limit) throws SQLException, ClassNotFoundException {
    List<ControllerLog> retval = new ArrayList<>();
    Connection connection = ConnectionManager.getInstance().getConnection();
    if (limit == null) {
        limit = Integer.valueOf(10);
    }
    String sql = "SELECT * FROM SPG_CONTROLLER_LOG order by LOG_TIME limit " + limit.toString();
    Statement st = connection.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while(rs.next()){
        ControllerLog controllerLog = new ControllerLog();
        controllerLog.setMethod(rs.getString("METHOD"));
        controllerLog.setDuration(rs.getLong("EXECUTION_TIME"));
        controllerLog.setCustomLog(rs.getString("CUSTOM_MSG"));
        controllerLog.setTimeStamp(rs.getString("LOG_TIME"));
        retval.add(controllerLog);
    }
    return retval;
}


    public static List<ControllerLog> getLatestControllerLogs() throws SQLException, ClassNotFoundException {
        return getLatestControllerLogs(null);
    }
}
