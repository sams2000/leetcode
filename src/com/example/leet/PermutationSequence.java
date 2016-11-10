package com.example.leet;

import java.util.ArrayList;

/**
 * Write a program to generate ALL unique permutations of those characters. 
 * Unique. You may not store in an array or list, due to memory constraints. e.g. for input of abc your program should give 6 
 * permutations but for aba your program should give 3. Hint: make the list alphabetical.
 * 
 * input  "abc"
 * output [abc, acb, bac, bca, cab, cba]
 * 
 * input "aba"
 * output [baa, aab, aba]
 * 
 * @author bin zhou
 * @since 2016-02-03
 */
public class PermutationSequence{
    public static void main(String[] args){
        System.out.println(permutations("aba"));
    }

    public static ArrayList<String> permutations(String input){
        ArrayList<String> result = new ArrayList<String>();
        
        helper(input, "", result);
        
        return result;
    }
    
    private static void helper(String input, String sol, ArrayList<String> result){
        if (input.length() == 0){
            result.add(sol);
        }
        
        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            
            if (input.substring(i+1).indexOf(c) != -1) continue;
            
            helper(input.substring(0, i) + input.substring(i+1), sol+c, result);
        }
    }
}
