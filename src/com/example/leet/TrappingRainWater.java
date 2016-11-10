package com.example.leet;
/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author bin zhou
 * @since 2016-02-01
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] A = {2, 1, 0, 2};
		
		System.out.println("water size is : " + trap(A));
	}
    public static int trap(int[] A) {
        int N = A.length;
        if (N<=2) return 0;
        int[] lmax = new int[N];
        int[] rmax = new int[N];
        
        //int leftmax = A[0];
        lmax[0] = A[0];
        for (int i=1; i<=N-1; i++){
            if (A[i]>lmax[i-1])
                lmax[i] = A[i];
            else
                lmax[i] = lmax[i-1];
        }
        
        //int rightmax = 0;
        rmax[N-1] = A[N-1];
        for (int i=N-2; i>=0; i--){
            if (A[i]>rmax[i+1])
                rmax[i] = A[i];
            else
                rmax[i] = rmax[i+1];
        }
        
        int sum = 0;
        for (int i=0; i<N; i++){
            int low = Math.min(lmax[i], rmax[i]);
            sum += low - A[i]>0 ? low - A[i] : 0;
        }
        
        return sum;
    }
}



