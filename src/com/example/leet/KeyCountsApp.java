package com.example.leet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function that sums up keys in a text file. The file contains data in the format of
"key,count" where key is a string and count is an integer. Each line will
	only contain one key-count pair. The output should contain each key
	occurring in the file along with the sum of the count for all occurrences of
	a given key.
	For Example:
	John,2
	Jane,3
	John,4
	Jane,5
	Would result in the output: "The total for John is 6. The total for Jane is 8."
 * @author bzhou
 * @since 2/22/2013
 */
public class KeyCountsApp{

	public static void main(String[] args) {
		//use default file for testing
		String defaultPath = "C:\\temp\\";
		String defaultFile = "dealer.txt";

		Map<String, Integer> result = keyCountsFromFile(defaultPath, defaultFile);
		//print Key Counts results by map entries
		for(Map.Entry<String, Integer> entry: result.entrySet()) {
			System.out.println("The total for " + entry.getKey	() + " is " + entry.getValue() +".");
		}
		
	      ArrayList<String> inList = new ArrayList<String>();
	        Collections.addAll(inList, "john,2", "john,3", "tom,1","jack,4");
	        result = keyCountsFromList(inList);
	        
	        System.out.println("5 is expected : " +  result.get("john").intValue());
	        System.out.println("1 is expected : " +  result.get("tom").intValue());
	        System.out.println("4 is expected : " +  result.get("jack").intValue());
	}




	private static HashMap<String, Integer> keyCountsFromList(ArrayList<String> inList){
		if (inList == null || inList.size() == 0) {
			return null;
		}

		HashMap<String, Integer> result = new HashMap<String, Integer>();

		for (String s: inList){
			String key = s.substring(0, s.indexOf(','));
			String value = s.substring(s.indexOf(',')+1);
			if (result.containsKey(key)){
				result.put(key, result.get(key) + Integer.valueOf(value));
			} else {
				result.put(key, Integer.valueOf(value));
			}
		}

		return result;
	}

	/**
	 * method keyCounts sum values for same key from input text file
	 * @param filePath
	 * @param fileName
	 * @return HashMap with key, SUM(value)
	 */
	private static HashMap<String, Integer> keyCountsFromFile(String filePath, String fileName)
	{
		HashMap<String, Integer> result = new HashMap<String, Integer>();

		FileReader fr = null;
		BufferedReader br = null;
		try{
			//read input text file
			fr = new FileReader(filePath + fileName);
			br = new BufferedReader(fr);

			String inLine;
			//pop "key, count" from text file line by line
			while((inLine = br.readLine()) != null){
				String name = inLine.substring(0, inLine.indexOf(","));
				String value = inLine.substring(inLine.indexOf(",")+1);
				if (!result.containsKey(name)) {
					result.put(name, Integer.parseInt(value)); //create a new entry for new name
				}
				else {
					result.put(name, result.get(name) + Integer.parseInt(value));//add values for same name
				}
			}
			br.close();
			fr.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try
			{
				if (br!= null) {
					br.close();
				}
				if (fr!= null) {
					fr.close();
				}
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}

		return result;
	}



}
