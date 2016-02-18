package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class largestNumber {
    public static void main(String[] args){
        int[] array = {2, 1, 3, 4, 5};
        
        System.out.println(largestNumber(array));
    }
    
    public static String largestNumber(int[] num) {
            StringBuilder sb=new StringBuilder();
            
	        if (num.length==0) return sb.toString();
	        
	        ArrayList<Integer> num1= new ArrayList<Integer>();
	        for(int i=0;i<num.length;i++){
	        	num1.add(num[i]);
	        }
	        
	        Collections.sort(num1,new Comparator<Integer>(){
	          public int compare(Integer o1, Integer o2){
	             String s1 = "" + o1;
	                String s2 = "" + o2;
	                 return s2.compareTo(s1);
	          }});
	        
	        for(int i=0;i<num.length;i++){
	            sb.append(num1.get(i));
	        }
	        
	        int i=0;
	        while(i<num.length-1&&sb.charAt(i)=='0'){
	            i++;
	        }
	        
	        return sb.substring(i);
	    }
}
