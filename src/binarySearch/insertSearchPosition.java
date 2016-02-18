package binarySearch;

/**
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume NO duplicates in the array.

Have you met this question in a real interview? Yes
Example
[1,3,5,6], 5-> 2

[1,3,5,6], 2->1

[1,3,5,6], 7->4

[1,3,5,6], 0 ->0

Challenge
O(log(n)) time 
 */
public class insertSearchPosition {
    public int searchInsert(int[] A, int target) {
        if (A.length == 0)
            return 0;
        int res = 0;
        int left = 0;
        int right = A.length - 1;

        int temp = 0;
        while (left <= right) {
            temp = (left + right) / 2;
            if (target > A[temp]) {
                left = temp + 1;
            } else if (target < A[temp]) {
                right = temp - 1;
            } else {
                return temp;
            }
        }
        return left;
    }
}
