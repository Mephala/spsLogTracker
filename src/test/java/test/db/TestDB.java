package test.db;

import com.gokhanabi.util.CommonUtils;
import com.gokhanabi.dao.ConnectionManager;
import com.gokhanabi.dao.ControllerLog;
import com.gokhanabi.dao.LogFetcer;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Connection;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Masraf2 on 12/8/2015.
 */

@RunWith(JMockit.class)
public class TestDB {

    @Test
    public void getConnectionForProperties(){
        try{
           Connection con = ConnectionManager.getInstance().getConnection();
            assertTrue(con!=null);
            con = ConnectionManager.getInstance().getLocalConnection();
            assertTrue(con!=null);
        }catch(Throwable t){
            t.printStackTrace();
            fail("Failed to obtain connection. Reason:" + t.getMessage());
        }
    }

    @Test
    public void getControllerLogs(){
        try{
            List<ControllerLog> controllerLogList =  LogFetcer.getLatestControllerLogs();
            System.out.println(controllerLogList);
            assertTrue(!CommonUtils.isEmpty(controllerLogList));
        }catch(Throwable t){
            t.printStackTrace();
            fail("Failed:" + t.getMessage());
        }

    }
}
