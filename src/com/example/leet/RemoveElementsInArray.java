package com.example.leet;

public class RemoveElementsInArray{
    public static void main(String arg[]){
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        System.out.println("Before removing elements, size of array is : "+ input.length);
        System.out.println("After removing elements, size of array is : "+ removeElement(input, 5));
        
    }
    
    public static int removeElement(int[] A, int elem) {
        int N = A.length;
        if (N==0) return 0;
        int i=0, j=0;//i as fast runner index, j as slow runner index
        while (i<N){
            if (A[i]!=elem){
                A[j] = A[i];
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j;
    }
}


