package com.example.leet;

/**
 * find the index for longest reoccuring character in string
 * @author bin zhou
 * @since 2016-02-01
 */
public class IndexOfLongestReoccuring {
	public static void main(String[] args){
	    String input1 = "AAABBCCCCD";
	    String input2 = "AAABBCCCCDDDDD";
	    String input3 = "AAABBCCCCDDDD";
	    String input4 = "AAABBCCCC AADDDD";
	    String input5 = " ";
	    String input6 = "";
	    String input7 = null;
	 
	    System.out.println(longestRecurr(input1));
	    System.out.println(longestRecurr(input2));
	    System.out.println(longestRecurr(input3));
	    System.out.println(longestRecurr(input4));
	    System.out.println(longestRecurr(input5));
	    System.out.println(longestRecurr(input6));
	    System.out.println(longestRecurr(input7));		
	}
	
	/**
	 * greedy solution 
	 * @param s
	 * @return the start index of reoccuring place
	 */
	public static int longestRecurr(String s){
	    if( s==null || s.equals("")) return -1;
        
	    int startIndex=0, count=1, tempStartIndex=0, tempCount=1;
	    
	    for (int i=1; i<s.length(); i++){
	        if(s.charAt(i) == s.charAt(i-1)){
	            tempCount++;
	        } else {
	        	if (tempCount>count){
		        	count = tempCount;
		        	startIndex = tempStartIndex; 	        		
	        	}
	            tempCount = 1;
	            tempStartIndex = i;
	        }
	    }
    	
	    if (tempCount>count){
        	count = tempCount;
        	startIndex = tempStartIndex; 	        		
    	}	    
	    
	    return startIndex;
	}	
}
