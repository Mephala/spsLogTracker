package test.controller;

import com.gokhanabi.controller.ViewController;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by GokhanOzgozen on 12/10/2015.
 */
@RunWith(JMockit.class)
public class TestViewController {


    @Test
    public void testAuthentication(){
        try {
            String username = "gokhanabi";
            String password = "gerebic";
            boolean loginSuccess = ViewController.getInstance().loginUser(username,password);
            assertTrue(loginSuccess);
        } catch (Throwable t) {
            t.printStackTrace();
            fail("Login failed:" + t.getMessage());
        }

    }
}
