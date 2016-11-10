package com.example.leet;

import java.util.Stack;
/**
 * reverse words in string 
 * word1 word2 word3 -> word3 word2 word1
 * @author bin zhou
 *
 */
public class ReverseWordsInAString {

	public static void main(String[] args) {
		String s = "hello world!";
	
		String reversed = reverseWordsByStack(s);
		
		System.out.println(reversed);
	}
	/**
	 * using stack
	 * @param s
	 * @return
	 */
    public static String reverseWordsByStack(String s) {
        if (s==null) return null;
        
        s=s.trim();
        if (s.indexOf(" ") == -1 || s.trim().equals("")) return s;
        
        Stack<String> stack = new Stack<String>();
        int N = s.length();
        int start = 0;
        for (int i=1; i<N; i++){
            if (s.charAt(i) == ' '){
                stack.push(s.substring(start, i));
                
	            while (s.charAt(i) == ' ') i++;
	            
	            start = i;
            }
        }
        
        //save the last word
        if (start<N)
            stack.push(s.substring(start));
            
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        
        return sb.toString();
    }	
	
    /**
     * using array and reverse in place
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s== null || s.indexOf(" ") == -1) 
            return s;
        else if (s.trim().length() == 0)
            return "";
        
        s = s.trim();
        //convert string to char array
        char[] ca = s.toCharArray(); 
        int N = ca.length;
        //swap start with end chars, till the middle of array
        for (int i=0; i<N/2; i++){
            char tmp = ca[i];
            ca[i] = ca[N-i-1];
            ca[N-i-1] = tmp;
        }
        
        int start = 0;
        for (int i=1; i<N; i++){
            if (ca[i] == ' '){
                for (int j=start; j<=(start+i-1)/2; j++){
                    char tmp = ca[j];
                    ca[j] = ca[i-1-j+start];
                    ca[i-1-j+start] = tmp;
                }
                
                while(ca[i] == ' ') i++;
                
                start = i;                
            }
        }
        //revert the last word
        for (int j=start; j<=(start+N-1)/2; j++){
            char tmp = ca[j];
            ca[j] = ca[N-1-j+start];
            ca[N-1-j+start] = tmp;
        }	
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            char tmp = ca[i];
            if (tmp != ' ' || ca[i-1]!=' ') 
                sb.append(tmp);
        }
        
        return sb.toString();
    }	
 
}
