package com.example.leet.todo;

import java.util.ArrayList;

/**
 * Given an infinite number of quarters(25 cents), dimes(10 cents), nickels(5 cents)
 * and pennies(1 cent), write code to calculate the number of ways of representing in cents 
 * @author Bin Zhou
 * @since 2016-02-01
 */
public class DenominationSets{
    public static void main(String[] args){
        System.out.println("number of ways by solution 1: " + makeChange(6, 25));

        System.out.println("number of ways by solution 2: " + ways(6));

    }
    
    /**
     * @param n
     * @param denom
     * @return the number of denomination combinations
     */
    public static int makeChange(int n, int denom){
        int next_denom = 0;
        switch(denom){
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5: 
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        
        int ways = 0;
        for (int i=0; i*denom <= n; i++)
            ways += makeChange(n - i*denom, next_denom);
        
        return ways;
    }    
    
    /**
     *  
     * @param n
     * @param denom
     * @param sofar
     * @param result
     * @return all the combination detail
     */
    public static void makeChangePrint(int n, int denom, String sofar, ArrayList<String> result){
        int next_denom = 0;
        if (n==0){
            result.add(sofar);
        } else if (n<0){
            return;
        }

        switch(denom){
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5: 
                next_denom = 1;
                break;
            case 1:
                break;
        }
        
        for (int i=0; i*denom <= n; i++){
            makeChangePrint(n - i*denom, next_denom, sofar+ denom + "x" + i + ", ", result);
        }
    }
    
    
    static int count = 0;
    public static int ways(int n){
        int[] denom = {25, 10, 5, 1};
        
        if (n ==0) return 0;
        
        helper(denom, n);
        
        return count;
    }
    
    private static void helper(int[] denom, int n){
        //stop condition: there is only one combination option for 0, 1, 2, 3, 4
        if (n>=0 && n<5) 
            count++;
        
        for (int i=0; i<denom.length; i++){
            if (n>=denom[i]){
                helper(denom, n-denom[i]);
            }
        }
    }
}
