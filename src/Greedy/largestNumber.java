package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class largestNumber {
	 public String largestNumber(int[] num) {
	        String res="";
	        if (num.length==0) return res;
	        ArrayList<Integer> num1= new ArrayList<Integer>();
	        for(int i=0;i<num.length;i++){
	        	num1.add(num[i]);
	        }
	        Collections.sort(num1,new Comparator<Integer>(){
	          public int compare(Integer o1, Integer o2){
	             String s1 = "" + o1 + o2;
	                String s2 = "" + o2 + o1;
	                 
	                 return s2.compareTo(s1);
	        }}
	        
	        
	        );
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<num.length;i++){
	            sb.append(num1.get(i));
	        }
	        int i=0;
	        while(i<num.length-1&&sb.charAt(i)=='0'){
	            i++;
	        }
	        return sb.substring(i);
	    }
    
	public static void main(String[] args){
		
	}
}
