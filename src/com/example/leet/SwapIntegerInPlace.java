package com.example.leet;

/**
 * Write a function to swap a number in place without temporary variables
 *
 * @author Bin Zhou
 * @since 2013-07-21
 * @version 2014-03-05
 */
public class SwapIntegerInPlace {
	public static void main(String[] args) {
        int[] input = new int[2];
        input[0] = 4;
        input[1] = 5;

        int[] result = swapInPlace1(input);

        System.out.println("5 is expected:" + result[0]);
        System.out.println("4 is expected:" + result[1]);
	}



	/**
	 * solution 1 : regular sum and subtract by base 10
	 * @param input
	 * @return
	 */
	public static int[] swapInPlace1(int[] input){
		int[] result = new int[2];
		int a = input[0];
		int b = input[1];

		a = a + b; //get 9 = 4 + 5
		b = a - b; //get 4 = 9 - 5;
		a = a - b; //get 5 = 9 - 4;

		result[0] = a;
		result[1] = b;

		return result;

	}

	/**
	 * solution 2: binary xor, and
	 * @param input
	 * @return
	 */
	public static int[] swapInPlace2(int[] input){
		int[] result = new int[2];
		int a = input[0];
		int b = input[1];


		a = a ^ b; //
		b = a ^ b; // apply above assignment: b=a^b =(a^b)^b=a^(b^b)=a
		a = a ^ b; // apply above two assignments: a=(a^b)^a=(a^a)^b=b

		result[0] = a;
		result[1] = b;

		return result;

	}

}
