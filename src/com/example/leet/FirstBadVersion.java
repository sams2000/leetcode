package com.example.leet;

import java.util.Random;

/**
 * There are versions 1, 2, 3 ... n,   if one version is bad, all following versions are bad. 
 * The solution is to find the first version in binary way.
 * 
 * @author bzhou3
 * @since 2016-01-20
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 6;
        boolean[] isBadTable = new boolean[n];
        Random random = new Random();
        int num = random.nextInt(n);
        
        for (int i=num; i<n; i++){
            isBadTable[i] = true;
        }
        
        for (int i=0; i<n; i++){
            System.out.print(isBadTable[i] + " ");
        }
        
        System.out.print("\nThe first bad version is : " + findFirstBadVersion(isBadTable, n));
        
    }
    
    public static int findFirstBadVersion(boolean[] table, int n){
        if (n<=1) {
            if (isBad(table, 1)) {
                return 1;
            } else {
                return -1;
            }
        }
        
        int low = 1, high = n;
        int mid = -1;
        
        while (low <= high){
            mid = (low + high)/2;
            
            if (isBad(table, mid) && (mid == 1 || !isBad(table, mid-1))) {
                return mid;
            } 

            if (isBad(table, mid)){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        
        return mid;
    }

    public static boolean isBad(boolean[] table, int n){
        return table[n-1];
    }
}
