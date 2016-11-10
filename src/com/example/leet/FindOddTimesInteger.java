package com.example.leet;

/**
 * find first number which appears odd times in array
 * solution : runner index i , j(=i-1), compare each pair elements from beginning, 
 *  if same, move fast index 2 forward, if not same, return the number as the result
 *  
 * @author bzhou
 * @date 2013-07-20
 */
class FindOddTimesInteger{
    public static void main (String args[]){
        int a[] = new int[]{1, 2, 2, 1, 3, 3, 1};
        System.out.println("checkOddTimesByBinary " + checkOddTimesByBinary(a) + " appears odd times");        
    }

    //with xor a integer wipe out itself, Complexity O(N), space O(1)
    private static int checkOddTimesByBinary(int[] a){
        int result = 0;
        
        for (int i=0; i<a.length; i++){
            result ^= a[i];
        }
        return result;
    }
}