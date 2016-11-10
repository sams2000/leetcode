package com.example.leet;

import java.util.ArrayList;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters(including space) and is fully (left and right)
 * justified. You should pack your words in a greedy approach; that is, pack as
 * many words as you can in each line. Pad extra spaces ' 'when necessary so
 * that each line has exactly L characters. Extra spaces between words should be
 * distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned
 * more spaces than the slots on the right. For the last line of text, it should
 * be left justified and no extra space is inserted between words. For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."] L: 16.
 * Return the formatted lines as: [ "This    is    an", "example  of text",
 * "justification.  " ]
 * 
 * @author bin zhou
 * @since 2016-02-11
 */
public class TextJustification {
	public static void main(String[] args) {
    	String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		 
    	ArrayList<String> result = fullJustify(words, 16);
    	for (String str : result)
    		System.out.println(str);

	}
	
	public static ArrayList<String> fullJustify(String[] words, int L) {
	    ArrayList<String> result = new ArrayList<String>();
	    ArrayList<String> list = new ArrayList<String>();
	    StringBuilder sb = new StringBuilder();
	    int cur = 0;
	    int len = 0;

	    while (cur < words.length) {
	        sb.setLength(0); //clear sb
	        list.clear(); //clear current row
	        sb.append(words[cur]);
	        len = words[cur].length();
	        cur++;	        

	        while (cur<words.length && len + 1 + words[cur].length() <= L) {
	            list.add(" " + words[cur]);
	            len += words[cur].length() + 1;
	            cur++;
	        }

	        if (cur < words.length && list.size() > 0) {
	            int spaces = L - len;
	            int average = spaces / list.size();
	            int remain = spaces % list.size();
	            for (int i=0; i<list.size(); i++) {
	                appendSpaces(sb, i<remain? average+1 : average);
	                sb.append(list.get(i));
	            }
	        } else {
	            for (int i=0; i<list.size(); i++) //this is required 
	            	sb.append(list.get(i));
	            
	            appendSpaces(sb, L - len);
	        }

	        result.add(sb.toString());
	    }
	    
	    return result;
	}

	//append n white spaces
	private static void appendSpaces(StringBuilder sb, int n) {
	    for (int i=0; i<n; i++) 
	    	sb.append(" ");
	}
}


