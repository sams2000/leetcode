package com.example.leet;

import java.util.Scanner;
/**
 * Fibonacci in resursive and iterative ways to get results.
 * @author bzhou3
 *
 */
public class Fibonacci{

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
        
        int num = 1;
        
        System.out.println("Fibonacci value for " + num + " = " + fibResursive(num));

        System.out.println("Fibonacci value for " + num + " = " + fibIterative(num));
    }
    
    public static int fibResursive(int n) {
        if (n<=0){
            return 0;
        } else if (n == 1 || n==2){
            return n;
        }
        
        return fibResursive(n-1)+fibResursive(n-2);
    }

    
    public static int fibIterative(int n){
        if (n<=0){
            return 0;
        } 
        
        int a = 0, b=1, c=0;
        for (int i=1; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        
        return c;
    }
}
