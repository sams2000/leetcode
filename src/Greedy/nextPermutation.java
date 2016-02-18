package Greedy;

import java.util.Arrays;

public class nextPermutation {
	   public static int[] nextPermutation(int[] nums) {
		      
	         if (nums.length<=1) return nums;
	          int[] res= new int[nums.length];
	         int cur=nums.length-1;
	        while(cur>0&& nums[cur]<=nums[cur-1]){
			  cur--;
	         }
	         
	        if (cur==0&&nums[cur]>=nums[cur+1]){
	            Arrays.sort(nums);
	                return nums;
	        }
	        cur--;
	        int last=nums.length-1; int min=Integer.MAX_VALUE;
	        while(last>=cur){
	                if (nums[last]>nums[cur] && (min==Integer.MAX_VALUE||nums[last]<nums[min])) min=last;
	                last--;
	        }
	        int temp=nums[min];
	        nums[min]=nums[cur];
	        nums[cur]=temp;
	        Arrays.sort(nums, cur+1,nums.length);
	        return nums;
	    }
	  
	  public static void main(String[] args){
		  int[] nums={1,3,2};
		 
	        
		  System.out.println(nextPermutation(nums));
	  }
}
