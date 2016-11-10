package com.example.leet;
/**
 * function to check whether an input int is power of 3
 * 
 * @author bzhou
 * @since 2013-08-09
 */
class Check3Power{
	public static void main (String[] args){
		
		for (int i=9; i<10; i++){
			if (validate3pow(i))
				System.out.println("YES!! " + i + " is power of 3");
			else
				System.out.println("NO!!! " + i + " is NOT power of 3");
		}
	}
	
	private static boolean validate3pow(int num){
	    if(num == 1)   //optional edge check
			return true;

	    //if current check value i is less than input value, multiply 3 again
		int i = 1;
		while(i< num){
			i = i*3;
		}
		
		if(i==num)
			return true;
		else
			return false;
	}
	
}