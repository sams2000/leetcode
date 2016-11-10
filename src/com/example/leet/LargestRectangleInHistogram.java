package com.example.leet;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] height = {5, 7, 2, 9, 6};
		
		System.out.println("max sum is: " + largestRectangleArea(height));

	}
   
	public static int largestRectangleArea(int[] height) {
		int[] h = new int[height.length+1];
		for (int i=0; i<height.length; i++) {
		    h[i] = height[i];
		}
		h[height.length]=0;//add this 0 value extra element to make sure to clean stack up and calculate all possible max
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int sum = 0;
		for (int i=0; i<h.length; i++){
			if (stack.isEmpty() || h[i] > h[stack.peek()]){
				stack.push(i);//push index
			} else {
				int tmp = stack.pop();
				sum = Math.max(sum, h[tmp]*(stack.isEmpty()? i: i-stack.peek()-1));
				i--;
			}
		}
		
		return sum;        
   }

}
