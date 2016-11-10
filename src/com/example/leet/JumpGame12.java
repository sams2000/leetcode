package com.example.leet;

/**
 * jump game I & II 
 * 
 * @author bin zhou
 * @since 2016-02-02
 */
public class JumpGame12 {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 1, 1, 4 };

        System.out.println("can jump ? " + canJump(nums));
        
        System.out.println("step, start, end, next");

        System.out.println("The min steps : " + jump(nums));
    }
    
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

        Each element in the array represents your maximum jump length at that position.
        
        Determine if you are able to reach the last index.
        
        For example:
        A = [2,3,1,1,4], return true.
        
        A = [3,2,1,0,4], return false.
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            end = Math.max(end, i + nums[i]);
            if (end >= nums.length - 1)//if the move reachs end of array
                return true;
            else if (end <= i) {//if the move can't reach current index
                return false;
            }
        }

        return false;
    }


    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

        Each element in the array represents your maximum jump length at that position.
        
        Your goal is to reach the last index in the minimum number of jumps.
        
        For example:
        Given array A = [2,3,1,1,4]
        
        The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int step = 0, start = 0, end = 0, next = 0;
        
        while (end < nums.length-1){
            step++;
            for (int i=start; i<=end; i++){
                next = Math.max(next, i+nums[i]);
            }
            
            if (next<end) return -1;
            start = end+1;
            end = next;
            
            System.out.println("   " + step + ",    " + start + ",    " + end
                    + ",   " + next);
            
        }
        
        return step;
    }

}
