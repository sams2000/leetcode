package com.example.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent(refer to leedcode).
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author bzhou
 * @since 2013-07-29
 * @since 2016-01-25
 */
public class LetterCombinations {
	static Map<Character, String> keyMap = new HashMap<Character, String>();
	public static void main(String[] args) {
		keyMap.put('1', "");
		keyMap.put('2', "abc");
		keyMap.put('3', "def");
		keyMap.put('4', "ghi");
		keyMap.put('5', "jkl");
		keyMap.put('6', "mno");
		keyMap.put('7', "pqrs");
		keyMap.put('8', "tuv");
		keyMap.put('9', "wxyz");
		keyMap.put('0', "");
		
		ArrayList<String> result = letterCombinations("12");
		
		System.out.println(result);
	}
	
	public static ArrayList<String> letterCombinations(String digits) {
	
		ArrayList<String> result = new ArrayList<String>();
		
		if (digits== null || digits.length() ==0) return result;
        
		letterCombinationsHelper(digits, 0, "", result);
		
		return result;
	}
	
	
	public static void letterCombinationsHelper(String digits, int start, String sol, ArrayList<String> result){
	    if (sol.length() == digits.length()){
	        result.add(sol);
	    } else {
	        //loop each char in input string
	        String curStr = keyMap.get(digits.charAt(start));
	        for (int i=0; i<curStr.length(); i++){
	            letterCombinationsHelper(digits, start+1, sol+curStr.charAt(i), result);
	        }
	    }
	}
}


