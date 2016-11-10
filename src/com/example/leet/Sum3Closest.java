package com.example.leet;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 *
 * e.g For example, given array S = {-1 2 1 -4}, and target = 1 The sum that is
 * closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author bzhou
 *  	Created on 1/31/2013
 *  	Updated on 8/1/2015
 */
public class Sum3Closest {
	private static int threeSumClosest(int[] num, int target) {
		int start = 0, middle = start + 1, end = num.length - 1;

		int sum = 0, curDiff = Integer.MAX_VALUE, mainDiff = Integer.MAX_VALUE;

		//sort array to increasing order
		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; i++) {
			start = i;
			middle = start + 1;
			end = num.length - 1;
			while (middle < end) {
				int tmpSum = num[start] + num[middle] + num[end];

				if (tmpSum > target) {
					curDiff = tmpSum - target;
					end--;
				} else if (tmpSum < target) {
					curDiff = target - tmpSum;
					middle++;
				} else {
					return tmpSum;
				}
				if (curDiff < mainDiff) {
					sum = tmpSum;
					mainDiff = curDiff;
				}
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 1, 1, 1, 0 };
		int target = 100;

		int result = threeSumClosest(array, target);
		System.out.println("The closest sum to the target is: " + result);

	      array = new int[] { 1, 1, 1, 0 };
	      target = 100;
	        System.out.println("3 is expected:" + threeSumClosest(array, target));

	        array = new int[]{-1, 2, 1, -4};
	        target = 1;
	        System.out.println("2 is expected:" + threeSumClosest(array, target));
	}
}
