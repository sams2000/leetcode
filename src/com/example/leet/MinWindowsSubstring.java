package com.example.leet;

import java.util.ArrayList;
import java.util.HashMap;

public class MinWindowsSubstring {

	public static void main(String[] args) {


		System.out.println(minWindow2("abbcdabc", "abc"));
	}
	
	/**
	 * using map to store character counts
	 * @param S
	 * @param T
	 * @return
	 */
	public static String minWindow1(String S, String T) {
        if (T.length() == 0 || S.length()<T.length()) return "";
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        HashMap<Character, Integer> toFind = new HashMap<Character, Integer>();
        
        for (int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            if (toFind.containsKey(c))
                toFind.put(c, toFind.get(c) + 1);
            else
            	toFind.put(c, 1);
        }
        
        String min = "";
        int minLen = Integer.MAX_VALUE;
        int count=0;
        int begin=0;
        for (int j=0; j<S.length(); j++){
            char c = S.charAt(j);
            
            if (!toFind.containsKey(c)) continue;
            
            if (found.containsKey(c))
                found.put(c, found.get(c) + 1);
            else
                found.put(c, 1);
            
            if (found.containsKey(c) && found.get(c)<=toFind.get(c)) count++;    
                
            if (count == T.length()){
                c = S.charAt(begin);
                while (!toFind.containsKey(c) || found.get(c) > toFind.get(c)){
                  if (found.containsKey(c) && found.get(c) > toFind.get(c)){
                        found.put(c, found.get(c)-1);
                    } 
                    begin ++;
                    c = S.charAt(begin);
                }
                if (minLen>(j-begin+1)){
                	minLen = j-begin+1;
                    min = S.substring(begin, j+1);
                }	                
            }
        }
        return min;
	}
	
	/**
	 * using int array to store character counts
	 * @param S
	 * @param T
	 * @return
	 */
	 public static String minWindow2(String S, String T) {
        if (T.length() == 0 || S.length()<T.length()) return "";
        int[] found = new int[256];
        int[] toFind = new int[256];
        
        for (int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            toFind[c]++;
        }
        
        String min = "";
        int minLen = Integer.MAX_VALUE;
        int count=0;
        int begin=0;
        for (int j=0; j<S.length(); j++){
            char c = S.charAt(j);
            
            if (toFind[c] == 0) continue;
            found[c] ++;
            
            if (found[c] <= toFind[c]) count++;
            // if window constraint is satisfied
            if (count == T.length()){
                // advance begin index as far right as possible,
                // stop when advancing breaks window constraint.            	
                c = S.charAt(begin);
                while (toFind[c] == 0 || found[c] > toFind[c]){
                    if (found[c] > toFind[c]) found[c] --;
                    begin++;
                    c = S.charAt(begin);
                }
                // update minWindow if a minimum length is met
                if (minLen>(j-begin+1)){
                	minLen = j-begin+1;
                    min = S.substring(begin, j+1);
                }
            }
        }
        return min;
    }
	
	 public static String minWindow3(String S, String T) {
	        if (T.length() == 0) return "";
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        for (int i=0; i<T.length(); i++){
	            char c = T.charAt(i);
	            if (map.containsKey(c))
	                map.put(c, map.get(c) + 1);
	            else
	                map.put(c, 1);
	        }
	        
	        String min = S;
	        for (int i=0; i<S.length(); i++){
	            HashMap<Character, Integer> tmpMap = (HashMap<Character, Integer>)map.clone();
	            for (int j=i; j<S.length(); j++){
	                char c = S.charAt(j);
	                if (tmpMap.containsKey(c) && tmpMap.get(c)>1)
	                    tmpMap.put(c, map.get(c) - 1);
	                else if (tmpMap.containsKey(c))    
	                    tmpMap.remove(c);
	                    
	                if (tmpMap.size() == 0){
	                    min = S.substring(i, j+1);
	                }
	                
	                if (min.length() == T.length())
	                    return min;
	            }
	        }
	        
	        return min;
	    }	
}
