package com.example.leet;

/**
 * This file is to reverse int array by 
 * (1) create new int array and read reverse order from original int array
 * (2) backward runner and forward runner indexes to swap array values 
 * @author bzhou
 * @since 2016-01-30
 */
public class ReverseIntegerArray{
    public static void main(String[] args){
        int N = 8;
        // generate N random real numbers between 0 and 10
        int [] a = new int[N];
        for (int i = 0; i < N; i++){
            a[i] = (int)(java.lang.Math.random()*10);
        }
            
        System.out.println("Before reverse:");              
        for (int i = 0; i < N; i++)
            System.out.print("(" + i + ")->" + a[i] + ", ");      

        int[] b = reverseInNewArray(a);
            
        System.out.println("\rAfter reverseInNewArray:");               
        for (int i = 0; i < N; i++)
            System.out.print("(" + i + ")->" + b[i] + ", ");      
        
        reserveBySwap(a);
        
        System.out.println("\rAfter reserveBySwap:");              
        for (int i = 0; i < N; i++)
            System.out.print("(" + i + ")->" + a[i] + ", ");        
    }     
    
    /**
     * create same size new array and read reverse order from end to start and save it to new array individually
     * @return int[]
     */
    public static int[] reverseInNewArray(int[] a){
        int [] b = new int[a.length];
        for (int i = 0; i< a.length; i++)
            b[i] = a[a.length-1-i];
        
        return b;
    }
    
    /**
     * using same array and a variable to swap elements e.g end <-> first, second end <-> second, and so on
     * @param a
     * @return
     */
    public static int[] reserveBySwap(int[] a){
        int i=0, j=a.length-1;
        while (i<j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
        
        return a;
    }
} 

