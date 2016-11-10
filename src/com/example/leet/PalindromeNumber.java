package com.example.leet;
/**
 * key point is to find correct d(current base) and use % / correctly.
 * @author bin zhou
 * @since 2013-07-29
 */
public class PalindromeNumber{
    public static void main(String[] args){
        int input = 1001;
        System.out.println("Is " + input + " a Palindrome ? " + isPalindrome(input));
    }
    
    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        
        int d=1;
        //if int starts with 10, should include >= 
        while (x/d >= 10) d*=10;
        
        while (x!=0){
            int first = x/d;
            int last = x%10;
            
            if (first != last) return false;
            
            x = (x%d)/10;  
            d=d/100;
        }
    
        return true;
    }    
}



