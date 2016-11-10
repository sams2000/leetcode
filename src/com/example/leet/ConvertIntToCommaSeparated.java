package com.example.leet;
import java.io.*;

public class ConvertIntToCommaSeparated{
	public static void main(String[] args) throws IOException{
		String value = "1543729";
		System.out.println("Before converstion: buf is " + value);
		System.out.println("After converstion: buf is " + convertIntToCommaSeparated(value));	
	}	
	
	private static StringBuffer convertIntToCommaSeparated(String value){
		StringBuffer buf = new StringBuffer(value);
		if (buf.length()<=3)
			return buf;
		
		int cNum = buf.length()/3;
		
		for (int i=0; i<cNum; i++){
			//3*(i+1) is the number of 3 character blocks, i is the number of commas have been added so far.
			if ((buf.length() - 3*(i+1) -i) > 0)
				buf.insert((buf.length() - 3*(i+1) -i), ',');
		}	
		
		return buf;
	}	
}