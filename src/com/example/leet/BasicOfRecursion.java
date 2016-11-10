package com.example.leet;
import java.io.*;
/**
 * 
 * @author bzhou3
 *
 */
public class BasicOfRecursion{
	public static void main(String[] args) throws IOException{
		//test - accumulate integer - recursive way
		//System.out.println("Sum of integer to 5 is : " + func(5));
		
		//test - function using Recursion to print numbers from n to 0
		System.out.println(printNToZero(10));
		
		//test - function using Recursion to print numbers from 0 to n
		System.out.println(printZeroToN(10));
		
		HelloWorld(5);
	}

	/**
	 * accumulate integer - recursive way
	 * @param inVal
	 * @return
	 */
	public static int func(int inVal){
		int outVal = 0;
		
		if (inVal == 1)
			outVal = 1;
		else if (inVal > 1)	
			outVal = func(inVal-1) + 1;
			
		return outVal;
	}
	
	/**
	 * Write a function using Recursion to print numbers from n to 0
	 * @param n
	 */
	static String printNToZero(int n){
		if (n == 0) 
			return " 0 " ;
		else 
			return " " + n + " " + printNToZero(n-1);
	}	
	
	/**
	 * Write a function using Recursion to print numbers from 0 to n.
	 * @param n
	 */
	static String printZeroToN(int n){
		if (n == 0)
			return "0 ";
		else {
			return printZeroToN(n-1) + " " + n + " ";
		}
	}
	
	static void HelloWorld(int count){
	    if(count<1)
	    	return;
	    HelloWorld(count - 1);     
	    System.out.println("Hello World!" + count);
	    
	}	
}