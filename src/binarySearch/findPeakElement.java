package binarySearch;
/**
 * 
 * @author bin zhou 
 *         Created on Feb 17, 2016
 *
 */
public class findPeakElement {
	  public int findPeak(int[] A) {
	        if (A.length==0||A.length==1) return 0;
	        int start=1;
	        int last=A.length-2;
	        int mid=1;
	        while(start<=last){
	            mid=start+(last-start)/2;
	            if (A[mid]>A[mid-1]&&A[mid]>A[mid+1]){
	                return mid;
	            }
	            if (A[mid]>A[mid+1]){
	                last=mid;
	            }else{
	                start=mid+1;
	            }
	        }
	        return mid;
	    }
	  
	 //http://www.cnblogs.com/yuzhangcmu/p/4202633.html
	  public int findPeak2(int[] A) {
	        if (A.length==0||A.length==1) return 0;
	        int start=1;
	        int last=A.length-2;
	        int mid=1;
	        while(start+1<last){
	            mid=start+(last-start)/2;
	            if (A[mid]>A[mid-1]&&A[mid]>A[mid+1]){
	                return mid;
	            }
	           if (A[mid]>A[mid-1]&&A[mid]<A[mid+1]){
	                   // rising area. move right;
	                 start=mid;
	             }else{
	                 last=mid;
	            }
	        }
	        return A[start]>A[last]?start:last;
	    }
}
