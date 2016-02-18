package Greedy;

import java.util.Stack;

public class deleteDigits {
	  public static String DeleteDigits(String A, int k) {
	       if (A==null || A.length()==0) return A;
	       Stack<Integer> stack = new Stack<Integer>();
	       stack.push(A.charAt(0)-'0'); 
	       for(int i=1;i<A.length();i++){
	           
	           int temp=A.charAt(i)-'0'; 
	           while(!stack.empty()&&stack.peek()>temp&&k>0){
	                   stack.pop();
	                   k--;
	                    
	            }
	            stack.push(temp); 
	       }
	       
	       StringBuilder sb=new StringBuilder();
	        while(k>0){
	               stack.pop();k--;
	        }
	       
	          while(!stack.empty()){
	             sb.insert(0,stack.pop());
	          } 
	          while(sb.charAt(0)=='0') sb.delete(0,1);
	        return sb.toString();
	       
	    }
	 
	 public static void main(String[] args){
		 System.out.println(DeleteDigits("178542",4));
	 }
}
