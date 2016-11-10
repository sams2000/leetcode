package com.example.leet;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.
 * @author bzhou
 * @since 2/8/2013
 */
public class PalindromeString
{
    public static void main(String[] args){
        //String input = "race a car";
        //String input = "A man, a plan, a canal: Panama";
        String input = ".a";
        System.out.println("Is String(" + input + ") a Palindrome? " + isPalindrome(input));
    }
    
    /**
     * palindrome check considers all characters including while space, letter, number and special characters
     * @param s
     * @return
     */
    public static boolean isPali(String s){
    	if (s.length() <=1) return true;
    	
    	int i=0, j=s.length()-1;
    	while (i<j){
    		if (s.charAt(i++) != s.charAt(j--))
    			return false;    				
    	}
    	
    	return true;
    }
    
    /**
     * converting string to character array, then palindrome check 
     * considers all characters including while space, letter, number and special characters
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s) {
        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to return true if the parameter is a palindrome and false otherwise.
         */
        char[] a = s.toCharArray();
        int i=0, j=a.length-1;
        
        while(i<j){
            if (a[i]== a[j]){
                i++;
                j--;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
	/**
     * Verify whether a input string is a Palindrome 
     * @param s
     * @return boolean 
     */
    private static boolean isPalindrome(String s) {
        if (s.length()<=1 || s.trim().equals("")) return true;
        
        s=s.toLowerCase();
        int i=0, j=s.length()-1;
        while (i<=j){
            char iChar = s.charAt(i);
            if (Character.isLetterOrDigit(iChar)){
               
                char jChar = s.charAt(j);
                if (Character.isLetterOrDigit(jChar)){
                    if (iChar!=jChar){
                    	return false;
                    } else {
                        i++;
                        j--;
                    }
                } else{
                    j--;
                }
            } else {
                i++;
            }            
        }
        
        return true;
    }    
    
}
