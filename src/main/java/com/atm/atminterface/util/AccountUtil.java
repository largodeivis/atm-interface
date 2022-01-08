package com.atm.atminterface.util;

import com.atm.atminterface.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountUtil {
    public static final Logger logger = LoggerFactory.getLogger(AccountUtil.class);

    public static Boolean validatePin(String strPin){
        if (strPin == null){
            return false;
        }
        if (strPin.matches("\\d+")){
            return true;
        }
        return false;

    }

    public static Boolean verifyPin(String strPin, String verifyPin){
        if(strPin.equals(verifyPin)){
            return true;
        }
        return false;
    }

    public static Boolean validateBalance(String balance){
        if (balance == null){
            return false;
        }

        if (balance.matches("\\d+")){
            return true;
        }
        return false;
    }
}
