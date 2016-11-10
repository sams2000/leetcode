package com.example.leet;

/**
 * Given a sorted array with target, find the range (starting with index 1) for elements
 * with the value same as target.
 * e.g input {1, 2, 3, 4, 4, 4, 4, 5}
 *     output {4, 7}
 * 
 * @author bin zhou
 * @since 2016-02-01
 */
public class SearchRange {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 4, 4, 4, 5};
		int[] result = searchRange(A, 4);
		
		System.out.print("range is : from " + result[0] + " to " + result[1]);
	}
    public static int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if (A.length ==0) return result;//A is empty
        
        //binary search to find mid index(based on 0)
        int low = 0;
        int up = A.length-1;
        int mid=-1;
        while (low <=up){
            mid = (low+up)/2;
            
            if (A[mid] == target){ 
                break;
            } else if (A[mid] > target){
                up = mid-1;
            } else if (A[mid] < target){
                low = mid+1;
            }
        }
            
        if (A[mid] != target) {
            return result;
        } else {
            //check forward and backforward for duplicate values
            low = mid;
            while (low>=0 && A[low] == target) low--;
            up = mid;
            while (up<A.length && A[up] == target) up++;
        }
            
        result[0] = low+1+1;
        result[1] = up -1+1;
        
        return result;
    }
}


