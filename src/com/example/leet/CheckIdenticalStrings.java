package com.example.leet;
import java.util.Arrays;

class CheckIdenticalStrings{
    public static void main(String[] args){
        String str1 = "abbffgg";
        String str2 = "fgbagfb";
        
        if(sameCheck(str1, str2))
            System.out.println("Yes, same letters");                
        else
            System.out.println("No, different letters");                
    }   
    
    /**
     * check unsorted(original) strings
     * @param s1
     * @param s2
     * @return
     */
    static boolean checkStr(String s1, String s2){
        if (s1.length()!=s2.length())
            return false;
        for (int i=0; i<s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
       
        return true;
    }
	
	/**
	 * check whether two strings are composed of same letters
	 * @param s1
	 * @param s2
	 * @return
	 */
	static boolean sameCheck(String s1, String s2){
		char[] char1 = s1.toCharArray();
		char[] char2 = s2.toCharArray();
		
		Arrays.sort(char1);
		Arrays.sort(char2);
		
		if(char1.length != char2.length)
			return false;
			
		for (int i=0; i<char1.length; i++){
			if (char1[i] != char2[i]) 
				return false;
		}	
		
		return true;
	}


}