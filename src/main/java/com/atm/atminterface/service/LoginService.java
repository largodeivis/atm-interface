package com.atm.atminterface.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    public boolean validateUser(String userid, String strPin){
        int pin = 0;
        try {
            pin = Integer.parseInt(strPin);
        } catch (NumberFormatException ex){
            logger.error("The PIN should be numerical digits only. PIN provided: " + strPin);
            return false;
        }
        //pin should be between 4 and 6 numbers
        return userid.equalsIgnoreCase("sss") && pin == 1234;
    }
}
