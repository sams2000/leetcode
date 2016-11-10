package com.example.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Prints a frequency table of the words on the command line/input line
 * @author bzhou
 */

public class WordFrequencyApp {

	public static void main(String[] args) {

		String input = "if it is to be it is up to me to do the watusi";
		Map<String, Integer> m = new HashMap<String, Integer>();
		m = wordFrequency(input);
		System.out.println("2 is expected : " + m.get("it").intValue());

		m = new HashMap<String, Integer>();
		m = wordFrequency(null);
		System.out.println("null is expected:" + m.get("it"));
	}

	/**
	 * Prints a frequency table of the words on the command line
	 *
	 * @param str
	 * @return
	 */
	public static Map<String, Integer> wordFrequency(String str) {
		Map<String, Integer> m = new HashMap<String, Integer>();

		if (str == null || str.trim().length()==0) {
			return m;
		}

		String[] args = str.split("\\s+");//split string with white space(s)

		for (String word : args) {
			Integer freq = m.get(word);
			m.put(word, (freq == null ? 1 : freq + 1));
		}

		return m;
	}

}
