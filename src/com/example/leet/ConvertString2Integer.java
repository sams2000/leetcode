package com.example.leet;

import java.security.InvalidParameterException;
/**
 * allow:
 *  - or + sign as start
 *  whitespace as beginning text
 *  
 * not allow:
 *  space between sign (- or +) with value
 * 
 * @author Bin Zhou
 * @since 2013-07-21
 */
public class ConvertString2Integer { 
   public static void main(String[] argv){
       String s = " -123456";
       System.out.println("after conversion: " + convertString2Int(s.trim()));
    } 
   
    public static int convertString2Int(String s){
        if(s == null || s.length() == 0){
            throw new InvalidParameterException();
        }
    
        int ret = 0;
        //flag to mark value is positive or negative
        boolean isNegtive = false;
    
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
    
            if( i == 0){    
                if (c=='-')
                    isNegtive = true;
                else if (c=='+')
                    continue;
                else if(c - '0' < 0 || c - '0' > 10)
                    throw new InvalidParameterException();
                else
                    ret = c-'0';
                
                continue;
            }
                
            if(c - '0' < 0 || c - '0' > 10){
                throw new InvalidParameterException();
            }
    
            int tmp = c - '0';
            ret *= 10;
            ret += tmp;
        }
    
        return isNegtive ? (-ret) : ret;
    }
} 
