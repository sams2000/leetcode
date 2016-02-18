package DP;

import java.util.ArrayList;

public class maximumSubarrayII {
	  public int maxTwoSubArrays(ArrayList<Integer> nums) {
	        if (nums==null||nums.size()==0){
	            return 0;
	        }
	        int len=nums.size();
	        int[] left=new int[len];
	        int[] right=new int[len];
	        left[0]=nums.get(0);
	        right[len-1]=nums.get(len-1);
	        for(int i=1;i<len;i++){
	            left[i]=Math.max(nums.get(i),left[i-1]+nums.get(i));
	        }
	        int curMax=left[0];
	        for(int i=1;i<len;i++){
	            int temp=Math.max(left[i],curMax);
	            left[i]=temp;
	            curMax=temp;
	        }
	        for(int i=len-2;i>=0;i--){
	            right[i]=Math.max(nums.get(i),right[i+1]+nums.get(i));
	        }
	        curMax=right[len-1];
	         for(int i=len-2;i>=0;i--){
	            int temp=Math.max(curMax,right[i]);
	            curMax=temp;
	            right[i]=curMax;
	        }
	        int max=Integer.MIN_VALUE;
	        for(int i=0;i<len-1;i++){
	            max=Math.max(left[i]+right[i+1],max);
	        }
	        return max;
	    }
}
