package com.example.leet;



/**
 * count the number of zeros for particular number will have, e.g n!
 * @author bzhou3
 * @since 2015-08-01
 * @since 2016-01-20
 */
public class NumberOfZeros {
	public static void main(String[] args) {
		System.out
				.println("Number of zeros for number 26 is : " + numZeros(125));
	}


	private static int numZeros(int num) {
		int count = 0;
		if (num < 0) {
			System.out.println("Factorial is not defined for < 0");
			return 0;
		}

		//count the number of steps that num has, 
		//first step is 5
		//second step is 5*5 = 25
		//third step is 5*5*5 = 125
		//
		for (int i = 5; num / i > 0; i *= 5) {
		    count += num / i;
		}

		return count;
	}
}
