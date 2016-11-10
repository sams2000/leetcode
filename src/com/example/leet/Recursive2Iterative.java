package com.example.leet;

public class Recursive2Iterative {
    public static void main(String[] args) {
        fn(4);
        fnIterative(4);
    }
    
    /**
     * recursive to run a testing case
     * @param i
     */
    public static void fn(int i){

        System.out.println("before " + i);
        
        if (i>0){
            fn(i-1);
        }
        
        System.out.println("after " + i);
    }
    
    
    /**
     * iterative to represent the recursion
     * @param i
     */
    public static void fnIterative(int i){
        
        System.out.println("before " + i--);//i=4
        
        if (i>0){
            System.out.println("before " + i--);//i=3
            
            if (i>0){
                System.out.println("before " + i--);//i=2
                
                if (i>0){
                    System.out.println("before " + i--);//i=1
                    
                    if (i==0){
                        System.out.println("before " + i);//i=0

                        System.out.println("after " + i);//i=0
                    }
                    System.out.println("after " + ++i);//i=1
                }
                System.out.println("after " + ++i);//i=2
            }
            System.out.println("after " + ++i);//i=3
        }
        
        System.out.println("after " + ++i);//i=4
        
    }    
}
