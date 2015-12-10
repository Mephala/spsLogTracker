package com.gokhanabi.controller;

import com.gokhanabi.exception.LogTrackerException;
import org.apache.log4j.Logger;
import service.provider.client.executor.ServiceClient;
import service.provider.common.core.RequestApplication;
import service.provider.common.dto.SPApplicationIntent;
import service.provider.common.dto.SPApplicationUserDto;
import service.provider.common.request.RequestDtoFactory;
import service.provider.common.request.SPApplicationDto;
import service.provider.common.request.SPApplicationRequestDto;
import service.provider.common.response.SPApplicationResponseDto;
import service.provider.common.util.CommonUtils;

import java.util.List;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class ViewController {

    private static ViewController instance;
    private Logger logger = Logger.getLogger(this.getClass());

    private ViewController(){}

    public static synchronized ViewController getInstance(){
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }


    public boolean loginUser(String userName, String password) throws LogTrackerException {
        try {
            logger.info("Logging user with username:" + userName);
            SPApplicationRequestDto req = RequestDtoFactory.createSPApplicationRequest(RequestApplication.SPA);
            req.setIntent(SPApplicationIntent.LOGIN);
            SPApplicationUserDto user = new SPApplicationUserDto();
            user.setUsername(userName);
            user.setPassword(password);
            req.setUser(user);
            SPApplicationResponseDto resp = ServiceClient.processSPARequest(req);
            if (resp == null) {
                throw new Exception("No response from server");
            }
            List<SPApplicationDto> spApps = resp.getEligibleApplications();
            if(CommonUtils.isEmpty(spApps))
                return false;
            for (SPApplicationDto spApp : spApps) {
                if("spsLogTracker.jar".equals(spApp.getName()))
                    return true;
            }
            return false;
        } catch (Throwable t) {
            logger.error("Authentication exception",t);
            throw new LogTrackerException(t.getMessage());
        }
    }


}
