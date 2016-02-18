package binarySearch;
/**
 * 
 * @author bin zhou 
 *         Created on Feb 17, 2016
 *
 */
public class binarySearchDuplicateSortedArray {
	 public int binarySearch(int[] nums, int target) {
         if (nums.length==0) return -1;
       int start=0;
       int last=nums.length-1;
       while(start<=last){
           int mid=(start+last)/2; 
           while (mid>0&&nums[mid]==target&&nums[mid-1]==target){
               mid--;
           }
           if (nums[mid]==target ) return mid;
           if (nums[mid]>target){
           while (mid>start&&nums[mid]==target&&nums[mid-1]==target){
               mid--;
           }
               last=mid-1;
           }else{
                while (mid<last&&nums[mid]==target&&nums[mid++]==target){
                  mid++;
               }
               start=mid+1;
           }
       }
       return -1;
   }
}
