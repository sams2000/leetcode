package com.example.leet;

/**
 * 
 * @author bzhou
 * @since 3/4/2013
 * @since 2016-01-29
 */
public class MergeSortedArray{
    public static void main(String[] args)
    {
        int A[] = new int[]{1,3,5,7,0,0,0};
        int B[] = new int[]{2,4,6};
        merge(A, 4, B, 3);
        
        for (int i =0; i<7; i++)
            System.out.println("->" + A[i]);
    }
    
    public static void merge(int A[], int m, int B[], int n) {
       int i=m-1, j=n-1; //size of A, size of B
       int k = m+n-1; //the merged size 
       while (i>=0 && j>=0)
       {
           if (A[i]>=B[j])
           {
               A[k] = A[i];
               i--;
           }
           else
           {
               A[k] = B[j];
               j--;
           }
           k--;
       }
       
       while (i>=0) 
       {
           A[k] = A[i];
           i--;   
           k--;
       }
       while (j>=0)
       {
           A[k] = B[j];
           j--; 
           k--;
       }
    }
}

