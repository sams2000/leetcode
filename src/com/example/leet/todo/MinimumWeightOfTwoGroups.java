package com.example.leet.todo;

import java.util.Arrays;
/**
 * there are two groups of people; n number of A's & n of B's. 
 * We want to have n pairs of A and B from two groups and  
 * to minimize the sum of the weight differences.
	e.g
	input: 
	        A[]={5,3,4};
	        B[]={1,6,2}; 
	output: min = 5 (3-1, 4-2,5-6)
 *         
 * @author bin zhou
 * @since 2014-05-05
 */
public class MinimumWeightOfTwoGroups {
	public static void main(String[] args){
		int[] a = {5, 3, 4};
		int[] b = {1, 6, 2};
		System.out.println(minWeight(a, b));
	}
	
	/**
	 * DP solution
	 * @param a
	 * @param b
	 * @return
	 */
	public static int minWeight(int[]a, int[]b){
	    Arrays.sort(a);
	    Arrays.sort(b);
	    
	    int dp[][] = new int[a.length+1][b.length+1];
	    dp[0][0]=0;
	    for(int j =1; j<dp[0].length; j++)
            dp[0][j]=Integer.MAX_VALUE;
        for(int i =1; i<dp.length; i++) 
	        dp[i][0]=Integer.MAX_VALUE;
	    
	    
	    for(int i =1;i<dp.length;i++)
	        for(int j=1;j<dp[0].length;j++){
	            int temp=Math.min(dp[i-1][j], dp[i][j-1]);
	            dp[i][j] = Math.abs(a[i-1]-b[j-1]) + Math.min(dp[i-1][j-1],temp);
	        }
	    return dp[a.length][b.length];
	}	
}



