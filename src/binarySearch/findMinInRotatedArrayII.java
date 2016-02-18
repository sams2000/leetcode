package binarySearch;
/**
 * 
 * @author bin zhou 
 *         Created on Feb 17, 2016
 *
 */
public class findMinInRotatedArrayII {
	  public int findMin(int[] num) {
	        if (num.length==0) return -1;
	        int l=0;
	        int r=num.length-1;
	        int mid=-1;
	        while(l+1<r){
	            mid=l+(r-l)/2;
	            if (num[mid]==num[r])
	            {
	                r--;
	            }else if (num[mid]>num[r]){
	                l=mid;
	            }else{
	                r=mid;
	            }
	        }
	        return Math.min(num[l],num[r]);
	    }
}
