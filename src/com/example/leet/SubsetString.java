package com.example.leet;

import java.util.ArrayList;

/**
 * implement an algorithm to print out the subsets of a string eg:
abc =
	_ (empty)
	a
	b
	c
	ab
	abc
	ac 
	bc 
 * @author bin zhou
 * @since 2016-02-01
 */
public class SubsetString {
	public static void main(String[] args){
		String s = "abc";
		ArrayList<String> result = new ArrayList<String>();
		subset(s, "", result);
		System.out.println(result.toString());
		
		result = new ArrayList<String>();
		permutation(s, "", result);
		System.out.println(result.toString());
	}

	public static void subset(String input, String sofar, ArrayList<String> result) {
		result.add(sofar);
		//optional
		if (input.equals(""))
			return;	

		for (int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			subset(input.substring(i + 1), sofar + c, result);
		}
	}
	
    //permutation recursive avoiding duplicates
	private static void permutation(String input, String sofar, ArrayList<String> result){
        if (input.equals("")){
            result.add(sofar);
        }
        
        for (int i=0; i<input.length();i++) {
            char c = input.charAt(i);
     
            //check duplicate and skip current char if there exists duplicate 
            if(input.indexOf(c, i+1)!=-1)	
                continue;
           
            //either sofar+c or c+sofar is OK
            permutation(input.substring(0,i)+input.substring(i+1), sofar + c, result);
        }
    }	
}
