package com.example.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 *  Word Ladder Leetcode I && II
 *  
	Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that: 
	Only one letter can be changed at a time
	Each intermediate word must exist in the dictionary
	For example, 
	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5. 
	Note:
	Return 0 if there is no such transformation sequence.
 * @author bz250056
 * @since 2014-05-06
 * @since 2016-01-15
 */
public class WordLadder12 {
	public static void main(String[] args){
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog"); //have this as one dict element
		
		//solution 1-4 needs to be run one by one to avoid interleaving
        //solution 1: to find the length of conversion by breadth first search
		//System.out.println("BFS algorithm: " + ladderLengthBFS(start, end, dict));
		
		//solution 2: to find ONE path of conversion by breadth first search
        //System.out.println("BFS algorithm expected [hit, hot, lot, log, cog];  w/ solution: " + ladderLengthBFSwPath(start, end, dict));
        
        //solution 3: to find the length of conversion by depth first search
        //System.out.println("DFS algorithm: " + ladderLengthDFS(start, end, dict));
        
        //solution 4: to find path of conversion by depth first search
        System.out.println("DFS algorithm expected [hit, hot, lot, log, cog]; w/ solution: " + ladderLengthDFSwPath(start, end, dict));        
        
/*		Set<String> res = adjacent(start, dict);
		for (String s : res)
			System.out.print(s + ", ");*/
	}
	
	/**
	 * BFS algorithm to find the length to convert start word to end word 
	 * @param start
	 * @param end
	 * @param dict
	 * @return length of path from start word to end word by changing one character only each step
	 */
    public static int ladderLengthBFS(String start, String end, HashSet<String> dict) {
        Map<String, String> path = new HashMap<String, String>();
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();//bfs queue
        queue.add(start);
        visited.add(start);
        
        while(!queue.isEmpty()){
            String pre = queue.poll();
            for (String cur : adjacent(pre, dict)){//adjacent words
                if (cur.equals(end)){
                    int count = 1;
                    while(pre!=null){
                        count++;
                        pre = path.get(pre);
                    }
                    return count;
                }
                
                if (!visited.contains(cur)){
                    visited.add(cur);
                    queue.add(cur);
                    path.put(cur, pre);//current -> prev
                }
            }
        }
        
        return 0;
    
    }
    
    /**
     * BFS algorithm to find the path to convert start word to end word
     * @param start
     * @param end
     * @param dict
     * @return the word conversion path from start word to end word
     */
    public static ArrayList<String> ladderLengthBFSwPath(String start, String end, HashSet<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        
        Map<String, String> path = new HashMap<String, String>();
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();//bfs queue
        queue.add(start);
        visited.add(start);
        
        while(!queue.isEmpty()){
            String pre = queue.poll();
            for (String cur : adjacent(pre, dict)){//adjacent words
                if (cur.equals(end)){
                    //int count =1;
                    result.add(end);
                    while(pre!=null){
                        result.add(0, pre);
                        //count++;
                        pre = path.get(pre);
                        
                    }
                    //return count;
                    return result;
                }
                
                if (!visited.contains(cur)){
                    visited.add(cur);
                    queue.add(cur);
                    path.put(cur, pre);//current -> prev
                }
            }
        }
        
        return result;
    }
    
    /**
     * DFS algorithm to find the length to convert start word to end word 
     * @param start
     * @param end
     * @param dict
     * @return length of path from start word to end word by changing one character only each step
     */
    public static int ladderLengthDFS(String start, String end, HashSet<String> dict){
        if (start.equals(end)) return 1;
        
        //set of words in dict which can become start by changing one character in the word
        Set<String> adjacent = adjacent(start, dict);
        //removing start word and make it a smaller problem
        dict.remove(start);
        for (String next : adjacent){
            //for each next word(which can become to start in one step) to run the same check
            return ladderLengthDFS(next, end, dict) + 1;
        }
        
        //if all failed, then return 0;
        return 0;
    }
    
    /**
     * DFS algorithm to find the path to convert start word to end word
     * @param start
     * @param end
     * @param dict
     * @return the word conversion path from start word to end word
     */    
    public static ArrayList<ArrayList<String>> ladderLengthDFSwPath(String start, String end, Set<String> dict){
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        ArrayList<String> sol = new ArrayList<String>();
        
        ladderLengthDFSwPathHelp(start, end, dict, sol, result);
        
        return result;
    }
    
    private static void ladderLengthDFSwPathHelp(String start, 
                                                         String end, 
                                                         Set<String> dict, 
                                                         ArrayList<String> sol,
                                                         ArrayList<ArrayList<String>> result){
        if (start.equals(end)) {
            sol.add(end);
            //by checking the size, only add shortest path 
            if (result.isEmpty() || sol.size() == result.get(0).size()){
                result.add(sol);
            } else if (sol.size() < result.get(0).size()){
                result.clear();
                result.add(sol);
            }
            
            return;
        }
        
        //set of words in dict which can become start by changing one character in the word
        Set<String> adjacent = adjacent(start, dict);
        //removing start word and make it a smaller problem
        dict.remove(start);
        sol.add(start);
        
        for (String cur : adjacent){
            //make sure the current dict is independent with other solution by creating a copy
            Set<String> aDict = new HashSet<String>(dict);
            //make sure the current temp solution is independent with other solution by creating a copy
            ArrayList<String> aSol = new ArrayList<String>(sol);
            
            ladderLengthDFSwPathHelp(cur, end, aDict, aSol, result);
        }
        
        //if all failed, then return 0;
        return;
    }    
    
    /**
     * utility to find all adjacent word in dict by changing one character
     * @param str
     * @param dict
     * @return Set
     */
	private static Set<String> adjacent(String str, Set<String> dict){
		Set<String> res = new HashSet<String>();
		
		for (int i=0; i<str.length(); i++){
			for (char j='a'; j<='z'; j++){
				char[] chs = str.toCharArray();
				if (chs[i] != j){
					chs[i] = j;
					String nstr = new String(chs);
					if (dict.contains(nstr))
						res.add(nstr);
				}
			}
		}
		
		return res;
	}
}