package com.example.leet;
/**
 * 
 * Add two string represented integers
 * 
 * input    "123"
 *          "456"
 *          
 * output    "579"
 * 
 * @author bin zhou 
 *  Created on Feb 17, 2016
 *
 */
public class AddStringIntegers {

    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        
        System.out.println(addStringIntegers(a, b));

    }

    public static int addStringIntegers(String a, String b){
        int i=a.length(), j=b.length();
        
        int d=1, carry=0, result=0;
        
        while(i>0 && j>0){
            int cur = Character.getNumericValue(a.charAt(i-1)) + Character.getNumericValue(b.charAt(j-1)) + carry;
            result += (cur % 10) * d;
            carry = cur / 10;
            d *=10;
            i--;
            j--;
        }
        
        while (i>0){
            int cur = Character.getNumericValue(a.charAt(i-1)) + carry;
            result += (cur % 10) * d;
            carry = cur / 10;
            d *=10;
            i--;            
        }
        
        while (j>0){
            int cur = Character.getNumericValue(b.charAt(j-1)) + carry;
            result += (cur % 10) * d;
            carry = cur / 10;
            d *=10;
            j--;
        }
        
        if (carry>0){
            result += carry * d;
        }
        
        return result;
    }
}
