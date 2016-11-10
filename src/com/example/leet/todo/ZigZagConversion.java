package com.example.leet.todo;
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	
	P   A   H   N
	A P L S I I G
	Y   I   R
	
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

	"abcdefghijklmnopqrstuvwxyz" and nRows = 4 as example
	a   g   m   s   y
	b f h l n r t x z
	c e i k o q u w
	d   j   p   v
		
 * @author bin zhou
 * @since 2016-02-10
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		int rows = 5;
		System.out.println(convert(str, rows));
	}
    
	public static String convert(String s, int nRows) {
        //edge condition: nRows is 0 or negative
		if (nRows == 1) return s;
    
        StringBuffer buf = new StringBuffer();
        //index difference of two characters in first row after conversion
        int diff = nRows + nRows - 2;
        for (int curRow = 0; curRow < nRows; curRow++) {
            int index = curRow;//starting index for first letter in curRow
            while (index < s.length()) {
                buf.append(s.charAt(index));
                index += diff;
                //for rows(not first, not last), index difference of two neighbor characters should minus row number x 2
                if (curRow != 0 && curRow != nRows - 1 && index - curRow - curRow < s.length()) {
                    buf.append(s.charAt(index - curRow - curRow));
                }
            }
        }
    
        return buf.toString();
   }
	
}
