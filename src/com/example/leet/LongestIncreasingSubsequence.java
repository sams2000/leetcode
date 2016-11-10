package com.example.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

    For example,
    Given [10, 9, 2, 5, 3, 7, 101, 18],
    The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
    
    Your algorithm should run in O(n2) complexity.
    
    Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author bin zhou
 * @since 2016-02-02
 */

public class LongestIncreasingSubsequence {
    public static void main(String[]args){
        //int[] ar = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int[] ar = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(ar));
    }	
	
    /**
     * using hashmap to memorize the current vale and its max increasing len, this solution is in O(n2)
     * @param nums
     * @return max len of increasing sequence
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int max=nums[0];
        int len = 1;
        map.put(max, len);
        
        for (int i=1; i<nums.length; i++){
            max = nums[i];
            len = 1;
            for (Integer key: map.keySet()){
                if (nums[i] > key && map.get(key) >= len){
                    len = Math.max(len, map.get(key)+1);
                    max =Math.max(max, nums[i]);
                    
                }
            }
            map.put(max, len);
        }
        
        len = 0;
        for (Integer val : map.values()){
            len = Math.max(len, val);
        }
        
        return len;
    }
}
