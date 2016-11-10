package com.example.leet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Please implement this method to capitalize all first letters of the words in the given String.
 * All other symbols shall remain intact. If a word starts not with a letter, it shall remain intact too.
 * Assume that the parameter String can only contain spaces and alphanumeric(number or letter) characters.
 * 
 * NOTE: please keep in mind that the words can be divided by single or multiple spaces.
 * The spaced also can be found at the beginning or the end of the parameter string, and you need to preserve them.
 * 
 * 1. read input string
 * 2. using String.toCharArray() to convert string content to char array
 * 3. use flag startLetter to control whether to uppercase first letter.
 * @author bzhou
 * @since 2/3/2013
 * @since 2016-01-21
 */
public class CapitalizeFirstLetters{
    public static void main(String[] args){
        try {
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Type exit to stop or input a string:");
            String input = stdin.readLine();      
            
            while (!input.equalsIgnoreCase("exit")) {
                System.out.println("After Capitalization by way 1 : "+ capitalizeString(input));
                System.out.println("After Capitalization by way 2 : "+ capitalizeStringByCharAt(input));
                System.out.print("Type exit to stop or input a string AGAIN :");
                input = stdin.readLine();   
            }     
            
            System.out.print("Application is stopped! Thank you!");
        }catch(Exception e){
           System.err.println("Error: " + e.getMessage());
       }

    }
    
    /**
     * By converting string to array
     * @param str
     * @return
     */
    public static String capitalizeString(String str) {
        //if (str.length()==0) return str; //optional
        //char[] chars = string.toLowerCase().toCharArray(); //if need to convert all others to lower case
        
        char[] chars = str.toCharArray(); //if keep all others in original case
        boolean startLetter = true;
        
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])){
                if (startLetter){
                     chars[i] = Character.toUpperCase(chars[i]);
                     startLetter = false;   
                }
            } else if(Character.isWhitespace(chars[i])) {
                startLetter = true;
            } 
        }
        return String.valueOf(chars);
    }

    
    /**
     * by append string builder 
     */
    public static String capitalizeStringByCharAt(String str){
        if (str.length()==0) return str;
        StringBuilder sb = new StringBuilder();
        
        boolean startLetter = true;
        for (int i=0; i<str.length(); i++){
            if (Character.isLetter(str.charAt(i))){
                if (startLetter){
                    sb.append(Character.toUpperCase(str.charAt(i)));
                    startLetter = false;
                } else {
                    sb.append(str.charAt(i));
                }   
            } else if (Character.isWhitespace(str.charAt(i))){
                startLetter = true;
                sb.append(str.charAt(i));
            } else {
                sb.append(str.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
