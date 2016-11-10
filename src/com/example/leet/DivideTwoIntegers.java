package com.example.leet;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * Solution: use shift<< operator to check quotient, also check sign of dividend and divisor.
 * e.g 90/3 = 30, 90 is dividend; 3 is divisor; 30 is quotient
 * Note:    max int is : 2147483647
 *          min int is : -2147483648
 * 
 * @author bzhou
 * @since 2013-02-08
 */
public class DivideTwoIntegers{
    public static void main(String[] args){
        int num = 0;
        num |= (1<<0);
        System.out.println("after setting, new number is : "+ num);
        System.out.println("max int is : "+ Integer.MAX_VALUE);
        System.out.println("min int is : "+ Integer.MIN_VALUE);
        
        /*int dividend = -2147483648;
        int divisor = -2147483648;
        */
        int dividend = 80;
        int divisor = 3;
        System.out.println(dividend + " / " + divisor + " = " + divide(dividend, divisor));
    }
    
    public static int divide(int dividend, int divisor) {
        
        //use sign to represent positive or negative result 
        boolean postive = true;
        if ((dividend<0 && divisor >0) || (dividend>0 && divisor<0)) postive = false;

        int unsigned_dividend = Math.abs(dividend);
        int unsigned_divisor = Math.abs(divisor);
        
        //when divisor is 0
        if (divisor == 0) {             
            return Integer.MAX_VALUE;
        }
        
        //when divisor is 1
        if (Math.abs(divisor) == 1){
            return (postive) ? unsigned_dividend : -unsigned_dividend;
        }
            
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        
        if (dividend == Integer.MIN_VALUE) {
            if (postive) {
                return 1 - divide(dividend + unsigned_divisor, unsigned_divisor);
            }
            else {
                return -1 + divide(dividend + unsigned_divisor, unsigned_divisor);
            }
        }        
        
        int result = unsigned_divide(unsigned_dividend, unsigned_divisor);
        return (postive) ? result : -result;
    }

    private static int unsigned_divide(int dividend, int divisor) {
        int quotient = 0;
        while (dividend >= divisor) {
            long tmp = divisor;//when tmp reach int max 2147483648, it should be able to handle 2147483648 x 2, then use long 64 bits
            int shift = 0;
            while (((long)tmp << 1) <= dividend) {
                tmp <<= 1;
                shift++;
            }
            dividend -= tmp;
            //set the bit of position at shift
            quotient |= (1 << shift);
        }
        return quotient;//get the int value of quotient which was set in bits
    }
}



