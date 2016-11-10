package com.example.leet;

import java.util.Arrays;

public class MedianSortedArrays {

    public static void main(String[] args) {
        /*
         * int[] A = {1, 3, 5, 7, 9}; 
         * int[] B = {2, 4, 6, 8, 10};
         */

        int[] A = { 3 };
        int[] B = { 1, 2, 4 };

        System.out.println("median is : " + findMedianSortedArrays1(A, B));
    }
    
    /**
     * Iterative solution to find median in linear time
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0, j = 0;
        int preVal = -1, curVal = -1;
        // move this number of elements total
        int s = (m + n) / 2;
        
        while (s >= 0) {
            int a = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int b = (j < n) ? nums2[j] : Integer.MAX_VALUE;
            preVal = curVal;
            if (a < b) {
                curVal = a;
                i++;
            } else {
                curVal = b;
                j++;
            }
            s--;
        }
        
        return (m + n) % 2 == 0? (preVal + curVal) / 2.0: curVal;
    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((n + m) % 2 == 0) // even
            return (GetMedian(A, m, B, n, (m + n) / 2)
                    + GetMedian(A, m, B, n, (m + n) / 2 + 1)) / 2.0;
        else // odd
            return GetMedian(A, m, B, n, (m + n) / 2 + 1);
    }

    /**
     * recursive solution is second choice compared with above iterative
     * solution
     * 
     * @param a
     * @param m
     * @param b
     * @param n
     * @param k
     * @return
     */
    public static int GetMedian(int a[], int m, int b[], int n, int k) {
        // assert(a && b);
        if (m <= 0)
            return b[k - 1];
        if (n <= 0)
            return a[k - 1];
        if (k <= 1)
            return Math.min(a[0], b[0]);
        if (b[n / 2] >= a[m / 2]) {
            if ((m / 2 + 1 + n / 2) >= k)
                return GetMedian(a, m, b, n / 2, k);
            else
                return GetMedian(a = Arrays.copyOfRange(a, m / 2 + 1, m),
                        m - (m / 2 + 1), b, n, k - (m / 2 + 1));
        } else {
            if ((m / 2 + 1 + n / 2) >= k)
                return GetMedian(a = Arrays.copyOfRange(a, 0, m / 2 + 1), m / 2,
                        b, n, k);
            else
                return GetMedian(a, m, b = Arrays.copyOfRange(b, 0, n / 2 + 1),
                        n - (n / 2 + 1), k - (n / 2 + 1));
        }
    }

}
