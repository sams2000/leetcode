package IntegerArray;

import java.util.ArrayList;
import java.util.HashMap;
/*
 * Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].

Note
There is at least one subarray that it's sum equals to zero.

http://www.cnblogs.com/yuzhangcmu/p/4174507.html
 */
public class SubarraySum {
	// worst case O(n^2)
	  public ArrayList<Integer> subarraySum(int[] nums) {
	        ArrayList<Integer> res=new ArrayList<Integer>();
	        if (nums.length==0){
	            return res;
	        }
	        
	        for(int i=0;i<nums.length;i++){
	            int start=i;
	            int temp=nums[i];
	            if (temp==0){
	                res.add(start);
	                res.add(start);
	                return res;
	            }
	            for(int j=i+1;j<nums.length;j++){
	                 temp=temp+nums[j];
	                if (temp==0){
	                   
	                    res.add(start);
	                    res.add(j);
	                    return res;
	                }
	            }
	        }
	        return res;
	    }
	  // better solution: O(n) 
	    public ArrayList<Integer> subarraySum2(int[] nums) {
	        ArrayList<Integer> res=new ArrayList<Integer>();
	        if (nums==null|| nums.length==0){
	            return res;
	        }
	        
	        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	        
	      //  map.put(0,0);
	        int sum=0;
	        map.put(0,-1);
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            if (map.containsKey(sum)){
	                res.add(map.get(sum)+1);
	                res.add(i);
	                return res;
	            }
	            map.put(sum,i);
	        }
	        
	        return res;
	    }
}
