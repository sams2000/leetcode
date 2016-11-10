package com.example.leet;


/**
 * Write a program that provides an implementation of the following interface
 * using recursion:
 *
 * @author bzhou
 * 			Created on 4/2/2013
 */

interface Reverser {
	public String reverse(String str);
}

/**
 * recursive to reverse string characters
 * @author bzhou3
 * @since 2016-01-19
 */
class ReverserClass implements Reverser {
	@Override
	public String reverse(String str) {

		if (str == null || str.length() <= 1) {
			return str;
		}

		return str.charAt(str.length() - 1)
				+ reverse(str.substring(0, str.length() - 1));

	}
}

public class StringReverserApp {
	public static void main(String[] args) {
		ReverserClass rc = new ReverserClass();
		System.out.println(rc.reverse("abcdefg"));
		
	      System.out.println("null is expected" + (new ReverserClass()).reverse(null));
	        System.out.println("[] is expected" + (new ReverserClass()).reverse(""));
	        System.out.println("a is expected" + (new ReverserClass()).reverse("a"));
	        System.out.println("dcba is expected" + (new ReverserClass()).reverse("abcd"));
	        System.out.println("edcba is expected" + (new ReverserClass()).reverse("abcde"));
	}


}
