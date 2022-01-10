package com.atm.atminterface.util;

import java.math.BigDecimal;

public class AccountUtil {

    public static Boolean validatePin(String strPin){
        /**
         * Returns true if PIN is a positive digit.
         */

        if (strPin == null){
            return false;
        }
        if (strPin.matches("\\d+")){
            return true;
        }
        return false;

    }

    public static Boolean verifyPin(String strPin, String verifyPin){
        /**
         * Returns true if both PINS match.
         */

        if(strPin.equals(verifyPin)){
            return true;
        }
        return false;
    }

    public static Boolean validateBalance(String balance){
        /**
         * Returns true if balance is a positive float value. Also accepts positive integers.
         */

        if (balance == null || balance.isBlank()){
            return false;
        }

        if (balance.matches("\\d+(\\.\\d+)?")){
            return true;
        }
        return false;
    }

    public static Boolean validateBalance(BigDecimal balance){
        /**
         * Returns true if balance >= 0.
         */

        if (balance == null){
            return false;
        }

        if (balance.compareTo(BigDecimal.ZERO) >= 0){
            return true;
        }
        return false;
    }

    //validate userid to not be null or empty
}
