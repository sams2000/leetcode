package com.example.leet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * check string only includes unique characters 
 * 
 * The integral types are byte, short, int, and long, whose values are 8-bit, 16-bit, 32-bit and 64-bit
 * signed two's-complement integers, respectively, and char, whose values are
 * 16-bit unsigned integers representing UTF-16 code units (§3.1).
 * 
 * @author bzhou3
 * @since 2016-01-20
 */
public class UniqueCharInString {
    public static void main(String[] args) {
        try {
            BufferedReader stdin = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Please input a string : ");
            String inStr = stdin.readLine();
            System.out.println("this is has unique ASCII characters? "
                    + isUniqueChars2(inStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this method time complexity is O(n), space complexity is O(1), space
     * usage is
     * 
     * @param str
     * @return
     */
    private static boolean isUniqueChars(String str) {
        if (str.length() > 256)
            return false;
        // use boolean array to check the position of character
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);

            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;

        }
        return true;
    }

    /**
     * this method use less space with bitwise(not recommended, as it's not easy
     * to understand)
     * 
     * @param str
     * @return
     */
    private static boolean isUniqueChars2(String str) {
        if (str.length() > 256)
            return false;

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            System.out.println("difference: " + val);
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }
        return true;
    }
}
