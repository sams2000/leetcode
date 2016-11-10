package com.example.leet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * You are to write a program that takes a list of strings containing integers
	and words and returns a sorted version of the list.

	The goal is to sort this list in such a way that all words are in
	alphabetical order and all integers are in numerical order.  Furthermore,
	if the nth element in the list is an integer it must remain an integer,
	and if it is a word it must remain a word.

	Output:
	-------

	The program must output the list of strings, sorted per the requirements
	above. Strings must be separated by a single space, with no leading space
	at the beginning of the line or trailing space at the end of the line.
 *
 * @author bin zhou
 * 			Created on 2013-03-01
 */
public class SortIntegerAndStringApp {
	public static void main(String[] args) {
		BufferedReader stdin = null;

		try {
			stdin = new BufferedReader(new InputStreamReader(System.in));
			String inStr = stdin.readLine();
			// run the program for each input until 'exit' is entered to exit program
			while (!inStr.equalsIgnoreCase("exit")) {

				System.out.println(convertListToString(sortIntegerString(inStr)));
				// read next input string for processing
				inStr = stdin.readLine();
			}

		     System.out.println("null is expected" + convertListToString(sortIntegerString(null)));
		        System.out.println("null is expected" +  convertListToString(sortIntegerString("")));
		        System.out.println("a b c is expected" +  convertListToString(sortIntegerString("c b a")));
		        System.out.println("1 2 3 is expected" +  convertListToString(sortIntegerString("2 1 3")));
		        System.out.println("1 a 2 b 3 c is expected" +  convertListToString(sortIntegerString("3 c 2 b  1 a")));
		        
			stdin.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stdin != null) {
					stdin.close();
				}
			} catch (Exception e) {

			}
		}
	}

	/**
	 * Method to sort input string
	 * @param input
	 * @return ArrayList<String>
	 */
	private static ArrayList<String> sortIntegerString(String input) {
		if (input == null || input.trim().equals("")) {
			return null;
		}

		ArrayList<Boolean> wholeList = new ArrayList<Boolean>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<String> strList = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();

		// clean leading space if there is any
		input = input.replaceAll("^\\s+|\\s+$", "");

		// split string into string elements by space
		String[] inputArray = input.split("\\s+");

		for (int i = 0; i < inputArray.length; i++) {
			String szStr = inputArray[i];

			if (isInteger(szStr))// mark false for integer, true for String
			{
				wholeList.add(false);
				intList.add(Integer.parseInt(szStr));
			} else {
				wholeList.add(true);
				strList.add(szStr);
			}
		}

		// sort both Integer and String lists
		Collections.sort(intList);
		Collections.sort(strList);

		Iterator<Boolean> itr = wholeList.iterator();
		Iterator<String> itrStr = strList.iterator();
		Iterator<Integer> itrInt = intList.iterator();

		while (itr.hasNext()) {
			// if current element is a String at input, then fill in element
			// from string list; otherwise from integer list
			if (itr.next()) {
				result.add(itrStr.next());
			} else {
				result.add(itrInt.next().toString());
			}
		}

		return result;

	}

	/**
	 * method to check input string, return true if it's valid Integer, otherwise return false
	 * @param s
	 * @return boolean
	 */
	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

	private static String convertListToString(ArrayList<String> result) {
		//
		if (result == null || result.size() == 0) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		// System.out.println(result);
		for (String element : result) {
			sb.append(element + " ");
		}

		return sb.toString().trim();
	}
}
