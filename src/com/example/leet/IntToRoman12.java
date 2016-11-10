package com.example.leet;

import java.util.HashMap;

/**
 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 * @author bzhou3
 * @since 2016-01-24
 */
public class IntToRoman12 {
    public static void main(String[] args) {
        int intVal = 4;
        String result = intToRoman(intVal);
        System.out.println(intVal + " intToRoman is : " + result);
        System.out.println(result + " romanToInt is : " + romanToInt(result));
    }   

    public static String intToRoman(int num) {
        int[] baseKey = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] baseValue = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I" };

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baseKey.length; i++) {
            int times = num/baseKey[i];
            num = num - baseKey[i]*times;
            
            while (times>0) {
                result.append(baseValue[i]);
                times--;
            }
        }

        return result.toString();        
    }
    /**
     * very trick to process special numbers: 4, 9, etc
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        HashMap dict = new HashMap();
        dict.put('M', 1000);
        dict.put('D', 500);
        dict.put('C', 100);
        dict.put('L', 50);
        dict.put('X', 10);
        dict.put('V', 5);
        dict.put('I', 1);
        int result = 0;
        for (int i=0; i<s.length()-1; i++){
            //to process: 4,"IV" / 9,"IX" / 40,"XL" / 90,"XC" / 400,"CD" / 900, "CM"
            //4 = 5(V) - 1(I)
            if ((Integer)dict.get(s.charAt(i+1)) > (Integer)dict.get(s.charAt(i)))
                result -= (Integer)dict.get(s.charAt(i));
            else            
                result += (Integer)dict.get(s.charAt(i));
        }

        return result += (Integer)dict.get(s.charAt(s.length()-1));
    }

}
