package com.atm.atminterface.service;

import com.atm.atminterface.util.AccountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    public boolean validateUser(String userid, String strPin){
        //pin should be between 4 and 6 numbers
        return userid.equalsIgnoreCase("user1") && AccountUtil.validatePin(strPin) && strPin.equals("1234");
    }
}
