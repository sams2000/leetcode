package binarySearch;

public class SearchInRoatatedArrayII {
	  public boolean search(int[] A, int target) {
	         if (A.length==0) return false;
	        int l=0;
	        int r=A.length-1;
	        int mid=-1;
	        while(l+1<r){
	            mid=l+(r-l)/2;
	            if (A[mid]==target||A[l]==target||A[r]==target) return true;
	            if (A[mid]==A[r])
	            {
	                r--;
	            }else if (A[mid]>A[r]){
	              if (A[r]<target)    
	                l=mid;
	              else r=mid;
	            }else{
	                if (A[mid]>target)r=mid;
	                else l=mid;
	            }
	        }
	        return false;
	    }
}
