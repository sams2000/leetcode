package com.example.leet;

/**
 *           A prime number is a natural number that has exactly two distinct natural number divisors,
          which are 1 and the prime number itself.
          The first prime numbers are: 2, 3, 5, 7, 11, 13.

          Almost prime numbers are the non-prime numbers which are divisible by only a single prime number.

          Please implement this method to return the number of almost prime numbers within the given range (inclusively).
 * @author bin zhou
 * @since 2016-02-01
 */
public class FindAlmostPrimeNumbers {
    public static void main(String args[]){
        countAlmostPrimeNumbers (1, 100);
    }
    
    //check given number is an almost prime
    public static boolean isAlmostPrime(int n){
        if(n < 3){
            return false;
        }
        
        for(int i=3;i<n;i++) {
            if (isPrime(i) && n%i==0){
                int szResult = n/i;
                if (isPrime(szResult)){
                    return true;
                }
            }
        }        

        return false;
    }

    public static int countAlmostPrimeNumbers(int from, int to) {
         int counter = 0;
         System.out.print("almost prime numbers:");
        
         for(int i = from; i <= to; i++){
        
           if(!isPrime(i)){
               if(isAlmostPrime(i)){
                   System.out.print(i+",");
                   counter++;
               }
           }     
        }
        return counter;
    }
    

    //check given number is a prime number
    public static boolean isPrime(int n){       
        if (n==2) return true;
        
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;       
    }    
}
