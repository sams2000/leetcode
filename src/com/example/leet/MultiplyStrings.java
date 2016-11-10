package com.example.leet;

/**
 * 
 * @author bin zhou
 * @since 2016-01-20
 */

public class MultiplyStrings {

	public static void main(String[] args) {
		String num1 = "123" ;
		String num2=  "12" ;
		System.out.println(multiply(num1, num2));
	}
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int n3 = n1+n2;//result length of two string multiplication is n1+n2 
        int[] num3 = new int[n1+n2] ;
        
        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0, j, t;
            for (j = n2 - 1; j >= 0; j--) {
                t = carry + num3[i+j+1] + (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                num3[i+j+1] = t % 10;
                carry = t / 10;
            }
            num3[i+j+1] = carry;
        }
        
        
        int i = 0;
        while (i < n3-1 && num3[i] == 0) i++;
        StringBuilder sb = new StringBuilder();
        while (i < n3){
        	sb.append(num3[i]);
        	i++;
        }
        	
        return sb.toString();       
    }

}

