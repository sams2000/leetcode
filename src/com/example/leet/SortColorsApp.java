package com.example.leet;

/**
 * there are three colors represented by 0, 1, 2, write a function to sort them in sequence 
 * 0's , 1's and 2's in place without extra data structure
 * @author bin zhou
 * @since 2016-02-01
 */
public class SortColorsApp{
    public static void main(String[] args){
        int[] a = {1, 2, 1, 0, 2, 0};
        
        sortColors(a);
        
        for (int i : a){
            System.out.print(i + ",");
        }              
    }   
    
    /**
     * @param A
     */
    private static void sortColors(int[] A) {
        int N=A.length;
        if (N<=1) return;
        int start=0, middle=0, end=N-1;
        
        while (middle<end){//for my testing, this can be < condition
            if (A[middle] == 0){
                //swap elements in start and middle
                int tmp = A[start];
                A[start]=A[middle];
                A[middle] = tmp;
                
                start++;
                middle++;//need to understand
                
            } else if(A[middle]==1){
                middle++;
            } else if(A[middle]==2){
                //swap elements in middle and end
                int tmp = A[end];
                A[end] = A[middle];
                A[middle] = tmp;
                
                end--;
            }
        }
    }

}