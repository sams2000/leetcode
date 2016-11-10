package com.example.leet;

import java.util.regex.Pattern;


/**
 * Please implement this method to
 * return the sum of all integers found in the parameter String. You can assume that
 * integers are separated from other parts with one or more spaces (' ' symbol).
 * For example, s="12 some text 3  7", result: 22 (12+3+7=22)
 * @author bzhou
 *      Created on 1/31/2013
 *      Updated on 8/1/2015
 *
 */

public class SumOfNumbersInString {
	public static void main(String args[]) {
		String input = "12 some text 3  4 7";

		System.out.println("The total is expected 26: " + sumOfNumbers(input));
	}

	public static int sumOfNumbers(String s) {
		int sum = 0;
		Pattern p = Pattern.compile("[\\s]+"); // split string by white space

		// Split input with the pattern
		String[] result = p.split(s);
		for (int i = 0; i < result.length; i++) {
			if (isInteger(result[i])) {
				sum += Integer.parseInt(result[i]);
			}
		}
		return sum;
	}

	/**
	 * method to validate value is numeric or not
	 *
	 * @param s
	 * @return
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
