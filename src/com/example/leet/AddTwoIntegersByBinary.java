package com.example.leet;

/**
 * Adds two numbers, not use + or any arithmetic operators. (refer to 150-20.1)
 * @author bin zhou 
 *         Created on Aug 8, 2016
 *
 */
public class AddTwoIntegersByBinary {

	public static void main(String[] args) {
		int num1 = 59;
		int num2 = 674;

		System.out.println("Sum is " + addTwoIntegersByBinary(num1, num2));
	}

	public static int addTwoIntegersByBinary(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		} else if (num1 == 0){
		    return num2;
		}
		
		// using XOR to add two binary numbers together excluding carry
		int sum = num1 ^ num2;
		// using AND + shifted to add two numbers together only for carry
		int carry = (num1 & num2) << 1;

		System.out.println("in loop: Sum is " + sum + " carry is : " + carry);

		// recursive until there is nothing to carry.
		return addTwoIntegersByBinary(sum, carry);
	}

}
