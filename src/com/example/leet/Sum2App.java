package com.example.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number. The function twoSum should return indices of the two
 * numbers such that they add up to the target, where index1 must be less than
 * index2. Please note that your returned answers (both index1 and index2) are
 * not zero-based.
 *
 * hashing method - time O(N), space O(2)
 *
 * You may assume that each input would have exactly one solution. e.g-1 Input:
 * numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2 e.g-2 Input:
 * numbers={2, 1, 9, 4, 4, 56, 90, 3}, target=8 Output: index1=4, index2=5
 *
 * @author bzhou
 * 		Created on 2/3/2013
 * 		Updated on 8/1/2015
 */
public class Sum2App {

	public static void main(String[] args) {

		System.out.println("Please run junit test to verify solution");

		int[] result = twoSumIndex(new int[] { 2, 7, 11, 15 }, 9);
		System.out.println("1 is expected: " + result[0]);
		System.out.println("2 is expected: " +  result[1]);

		result = twoSumIndex(new int[] { 2,1,9,4,4,56,90,3 }, 8);
		System.out.println("4 is expected: " + result[0]);
		System.out.println("5 is expected: " +  result[1]);

		result = twoSumIndex(null, 9);
		System.out.println("0 is expected: " + result[0]);
		System.out.println("0 is expected: " +  result[1]);

		result = twoSumByClone(new int[] { 2, 7, 11, 15 }, 9);
		System.out.println("1 is expected: " + result[0]);
		System.out.println("2 is expected: " + result[1]);

		result = twoSumByClone(new int[] { 2,1,9,4,4,56,90,3 }, 8);
		System.out.println("4 is expected: " + result[0]);
		System.out.println("5 is expected: " + result[1]);

		result = twoSumByClone(null, 9);
		System.out.println("0 is expected: " + result[0]);
		System.out.println("0 is expected: " + result[1]);

	}

	/**
	 * one loop to finish checking with help of HashMap
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSumIndex(int[] numbers, int target) {
		int[] result = new int[2]; //int array, default value is 0

		//edge case
		if (numbers == null || numbers.length<=1) {
			return result;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i=0; i<numbers.length; i++){
			if (map.containsKey(target - numbers[i])){
				result[0] = map.get(target-numbers[i]);
				result[1] = i+1;
				break;
			} else {
				map.put(numbers[i],i+1);
			}
		}

		return result;
	}


	/**
	 * by using clone and sort, not using HashMap
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSumByClone(int[] numbers, int target) {
		int[] result = new int[2];

		if (numbers == null || numbers.length<=0) {
			return result;
		}

		// step 1 : clone current array and use new array as sorted
		int[] copy = numbers.clone();
		// step 2 : sort copied array function will use nlog(n)
		Arrays.sort(copy);

		// step 3 : find two values in copied int array
		int i = 0, j = copy.length - 1;
		while (i < j) {
			if (copy[i] + copy[j] < target) {
				i++;
			} else if (copy[i] + copy[j] > target) {
				j--;
			} else {
				break;
			}
		}

		// step 4 : find index for each value in result
		for (int k = 0; k < numbers.length; k++) {
			if (copy[i] == numbers[k]) {
				result[0] = k + 1;
			}
		}

		for (int k = 0; k < numbers.length; k++) {

			// find value copy[j] but need to avoid to use same index if there
			// are duplicate values in copy array
			if (copy[j] == numbers[k] && k + 1 != result[0]) {
				result[1] = k + 1;
			}
		}

		// step 5 : sort two indices in result array
		Arrays.sort(result);

		return result;
	}

}
