package com.example.leet;

import java.util.HashSet;
import java.util.Set;


/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author bin zhou
 * @since 2016-02-02
 */
public class LongestSubstringNoRepeating {

    public static void main(String[] args) {

        System.out.println("the longest substring without repeating is 1 ? "
                + lengthOfLongestSubstring1("aa"));
//        System.out.println("the longest substring without repeating is 3 ? "
//                + lengthOfLongestSubstring2("abcabcbb"));

    }

    /**
     * using set to store character count
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<Character>();
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                // record current length
                len = Math.max(len, i - start);
                // move start index forward till not a repeating character
                while (s.charAt(start) != c) {
                    set.remove(s.charAt(start));//make sure to remove current character
                    start++;
                    
                }
                start++;
            } else {
                set.add(c);
            }
        }
        len = Math.max(len, s.length() - start );
        return len;
    }

    /**
     * using character array to store the character count
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int len = 0;
        int start = 0, end = 0;
        char[] set = new char[256];
        while (end < s.length()) {
            set[s.charAt(end)]++;
            while (set[s.charAt(end)] > 1) {
                len = Math.max(len, end - start);
                set[s.charAt(start)]--;
                start++;
            }
            end++;
        }
        return Math.max(len, end - start);
    }
}
