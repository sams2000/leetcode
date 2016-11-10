package com.example.leet;

public class Sum3 {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 8;
        
        System.out.println(sum3check(array, target));
    }
    
    public static boolean sum3check(int[] array, int target){
        if (array.length <=2) return false;
        
        for (int i=0; i<array.length-2; i++){
            int mid = i+1, right=array.length-1;
            while (mid<right){
                if (array[i] + array[mid] + array[right] > target){
                    right--;
                } else if (array[i] + array[mid] + array[right] < target){
                    mid++;
                } else {
                    return true;
                }
            }            
        }
        
        return false;
    }
}
