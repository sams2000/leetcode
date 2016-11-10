package com.example.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * TWO Sigma Interview Question: input is string
 * 
 * The input is any string of any length of any characters. Write a program to
 * generate ALL unique permutations of those characters. Unique. You may not
 * store in an array or list, due to memory constraints. e.g. for input of abc
 * your program should give 6 permutations but for aba your program should give
 * 3. Hint: make the list alphabetical.
 * 
 * input is a string : e.g "abc" and outputs are: [abc, acb, bac, bca, cab, cba]
 * 
 * @author bzhou - leetcode
 * @since 1/31/2013
 * @since 03/24/2014
 * @since 2016-01-19
 */
public class PermutationString {
    static int count = 0;

    public static void main(String[] args) {
        String input = "abccc";

        ArrayList<String> result = new ArrayList<String>();
        
        permutationRecursive(input, "", result);
        System.out.println("permutation result is: " + result);

        // calling iterative solution
        System.out.println("permutation1 result is: " + permutationIterative(input));
    }

    /**
     * recursive permutation by avoiding duplicates
     * 
     * @param input
     * @param sofar
     * @param result
     */
    public static void permutationRecursive(String input, String sofar, ArrayList<String> result) {
        if (input.equals("")) {
            count += 1;
            System.out.println("solution " + count + ": " + sofar);
            result.add(sofar);
        } else {

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                // check duplicate and skip current char if there exists duplicate
                if (input.indexOf(c, i + 1) != -1)
                    continue;   
    
                // either sofar+c or c+sofar is OK
                permutationRecursive(input.substring(0, i) + input.substring(i + 1), sofar + c, result);
            }
        }
    }

    /**
     * iterative permutation 
     * @param input
     * @return
     */
    private static ArrayList<String> permutationIterative(String input) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("");

        for (int i = 0; i < input.length(); i++) {
            
            if (input.indexOf(input.charAt(i), i + 1) != -1)
                continue;
            
            ArrayList<String> current = new ArrayList<String>();
            for (String s : result) {
                for (int j = 0; j < s.length() + 1; j++) {
                    current.add(s.substring(0, j) + input.charAt(i)
                            + s.substring(j));
                }
            }
            result = new ArrayList<String>(current);
        }
        return result;
    }
}
