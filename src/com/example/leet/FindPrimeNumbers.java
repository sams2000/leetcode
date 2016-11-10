package com.example.leet;

/**
 * A prime number is a natural number that has exactly two distinct natural number divisors,
 * which are 1 and the prime number itself.
 * The first prime numbers are: 2, 3, 5, 7, 11, 13.
 * Return the number of almost prime numbers within the given range (inclusively).
 * @author bzhou
 * @since 2/18/2013
 */
public class FindPrimeNumbers {

    public static void main(String args[]){
        printPrimeNumbers (1, 100);
    }
    
    public static void printPrimeNumbers(int from, int to) {
         System.out.print("Prime numbers:");
        
         for(int i = from; i <= to; i++){
        
           if(isPrime(i)){
               System.out.print(i+", ");
           }   
        }
    }
    
    //check given number is a prime number e.g 2, 3, 5, 7, 11, 13, 17, 19...
    public static boolean isPrime(int n){
        
        if (n<2) return false;
        else if (n==2) return true;
        
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;       
    }
        

}
