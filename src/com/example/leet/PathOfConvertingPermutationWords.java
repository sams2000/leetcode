
package com.example.leet;

import java.util.ArrayList;

/**
 * Given two strings that are the permutation to each other. You can swap two
 * adjacent character a time, print the path of how one string converts to
 * another.
 * 
 * @author bin zhou
 * @since 2016-02-03
 */
public class PathOfConvertingPermutationWords {
    public static void main(String[] args) {
        System.out.println(pathSwap("ABCDE", "DEACB"));
    }
    
    public static ArrayList<String> pathSwap(String s1, String s2){
        ArrayList<String> result = new ArrayList<String>();
        result.add(s1);
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int j=0; //as the destination string index
        while (j<c2.length){
            while(j<c2.length && c1[j] == c2[j]) j++;
            
            int i=j;
            while (i<c1.length && c1[i] != c2[j]) i++;
            
            //swap s1 character at i with i-1 
            while (i>j){
                char tmp = c1[i-1];
                c1[i-1] = c1[i];
                c1[i] = tmp;
                result.add(new String(c1));
                i--;
            }
            
            j++;
        }
        
        return result;
    }
}
