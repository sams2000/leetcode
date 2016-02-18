package IntegerArray;

import java.util.Arrays;

public class removeDuplicatesFromSortedArrayII {
	 public static int removeDuplicates(int[] nums) {
         if (nums.length==0){return 0;}
        int prev=1;
        
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i++){
           if (nums[prev]!=nums[prev-1]){
               prev++;
           }else if (nums[prev]==nums[prev-1]&&nums[i]!=nums[prev]){
                  prev++;
                  nums[prev]=nums[i];
           }
        }
       return prev+1;
    }
	 
	 public static void main(String[] args){
		 int[] res={-8,0,1,2,3};
		 System.out.println(removeDuplicates(res));
	 }
}
