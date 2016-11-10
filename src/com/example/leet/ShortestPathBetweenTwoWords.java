package com.example.leet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Given start word, end word and dictionary which contains valid words. 
 * Each step, you can change one character, find the shortest path from 
 * start word to end word, also print out the path.
 * 
 * @author bin zhou
 * @since 2016-02-07
 */
public class ShortestPathBetweenTwoWords {
	public static void main(String[] args) {
		String start = "DAMP" ;
		String end = "LIKE";
		
		Set<String> dict = new HashSet<String>();
		dict.add("DAMP");
		dict.add("LAMP");
		dict.add("LIMP");
		dict.add("LIME");
		dict.add("LIKE");
		dict.add("TTT");
		dict.add("AAA");
		
		List<String> result = transform(start, end, dict);
		System.out.println(result);
	}

	private static List<String> transform(String start, String end,	Set<String> dict) {
		start = start.toUpperCase();
		end = end.toUpperCase();
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		Map<String, String> backtrackMap = new TreeMap<String, String>();
		
		queue.add(start);
		visited.add(start);
		
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			// For each possible word v from w with one edit operation
			for (String next : getOneEditWords(cur)) {
				// If next is a dictionary word
				if (dict.contains(next)) {
	                if (next.equals(end)) {
	                    // Found end word! Now, print back track
	                    List<String> path = new LinkedList<String>();
	                    // Append next to list
	                    path.add(next);
	                    while (cur != null) {
	                        path.add(0, cur);
	                        cur = backtrackMap.get(cur);
	                    }
	                    return path;
	                }
	                
					if (!visited.contains(next)) {
						queue.add(next);
						visited.add(next); // mark visited
						backtrackMap.put(next, cur);
					}
				}
			}
		 }
			 
		return null;
	}
	
	private static Set<String> getOneEditWords(String word) {
		Set<String> words = new TreeSet<String>();
		 	for (int i = 0; i < word.length(); i++) {
		 		char[] wordArray = word.toCharArray();
		 		// change that letter to something else
		 		for (char c = 'A'; c <= 'Z'; c++) {
		 			if (c != word.charAt(i)) {
		 				wordArray[i] = c;
		 				words.add(new String(wordArray));
		 			}
		 		}
		 	}
		 return words;
	}	
}
