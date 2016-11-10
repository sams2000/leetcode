package com.example.leet;

import java.util.ArrayList;

/**
 * given a string find the number of distinct substrings of the string.
	ex:
	input-> aaaa
	output-> 4(a, aa, aaa, aaaa)
	input->abcd
	output->10(a, b, c, d, ab, bc, cd, abc, bcd, abcd)
 * @author bin zhou
 * @since 2014-03-18
 */
public class DistinctSubstrings {

	public static void main(String[] args) {
		//String s = "aaaa";
		String s = "abcd";
		System.out.println(distinctSubstrings(s));
	}	
	
	public static ArrayList<String> distinctSubstrings(String s) {
		ArrayList<String> result = new ArrayList<String>();
		
		int N = s.length();
		if (N == 0) 
		    return result;
		
		for (int i=1; i<=N; i++) {
			for (int j=0; j+i<=N; j++) {//j can go upto N-1
				if (!result.contains(s.substring(j, i+j)))
					result.add(s.substring(j, i+j));
			}
		}
		return result;
	}
}
