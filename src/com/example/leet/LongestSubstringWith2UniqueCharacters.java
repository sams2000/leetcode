package com.example.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the longest substring that contains only two unique
 * characters. For example, given "abcbbbbcccbdddadacb", the longest substring
 * that contains 2 unique character is "bcbbbbcccb".
 * 
 * @author bin zhou
 * @since 2016-02-02
 */
public class LongestSubstringWith2UniqueCharacters {

    public static void main(String[] args) {
        String s = "aabbccccceeedd";
        System.out.println(longestTwoUnique(s));
    }

    /**
     * create a set to remember the lastest index (i) coming from the left
     * @param s
     * @return
     */
    public static String longestTwoUnique(String s){
        Set<Character> set = new HashSet<Character>();
        int start = 0; 
        int end = 0; 
        String result = "";
        
        while (end <s.length()){
            char c = s.charAt(end);
            if (!set.contains(c) && set.size()==2){
                set.add(c);
                
                if (end-start > result.length()){
                    result = s.substring(start, end);
                }
                char charToRemove = s.charAt(start);
                while (s.charAt(start) == charToRemove){
                    start++;
                }
                set.remove(charToRemove);
                
            } else {
                set.add(c);
                end++;
            }
        }
        
        return result;
    }
}
