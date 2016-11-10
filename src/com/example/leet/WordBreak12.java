package com.example.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
    For example, given
    s = "leetcode",
    dict = ["leet", "code"].
    Return true because "leetcode" can be segmented as "leet code".

 * @author bzhou3
 * @since 2016-01-16
 */
public class WordBreak12{
    static boolean result = false;
    
    public static void main(String[] args) {
/*        //test 1
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");*/
        
        //test 2
        String s = "catsanddog";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");


/*        //test 3
        String s = "aaaaaaa";
        Set<String> dict = new HashSet<String>();
        dict.add("aaaa");
        dict.add("aa");*/
        
/*        //test 4
        String s = "goalspecial";
        Set<String> dict = new HashSet<String>();
        dict.add("go");
        dict.add("goal");
        dict.add("goals");
        dict.add("special");*/
        
        //System.out.println("Word break ok ? " +  wordBreak1(s, dict));
        //System.out.println("Word break ok ? " +  wordBreak1DP(s, dict));
        System.out.println("Word break detail ? " +  wordBreak2(s, dict));
        
        
    }
    // recursion太耗时, 使用dp, 额外建一个数组, 存储每个子问题的结果
    public static boolean wordBreak1DP(String s, Set<String> dict){
        if(s==null||dict==null) return false;
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1; i<s.length()+1; i++){
            
            for(int j=0; j<i; j++){
                if(dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i]=true;
                    continue;
                }
            }
        }
        return dp[s.length()];
    }
    
    //Time Limit Exceeded
    public static boolean wordBreak1(String s, Set<String> dict){
        if (s.isEmpty() || dict.isEmpty()) return false;
            
        wordBreak1Helper(s, dict);
     
        return result;
    }
    
    private static void wordBreak1Helper(String s, Set<String> dict){
        if (dict.contains(s) || s.isEmpty()) result = true;
        
        for (int i=1; i<=s.length(); i++){
            String aWord = s.substring(0, i);
            if (dict.contains(aWord)){
                HashSet<String> aDict = new HashSet<String>(dict);
                aDict.remove(aWord);
                
                wordBreak1Helper(s.substring(i), aDict);
            }
        }
        
    }
    
    
    public static ArrayList<String> wordBreak2(String s, Set<String> dict){
        ArrayList<String> result = new ArrayList<String>();
        
        String sol = "";
        
        if (s.isEmpty() || dict.isEmpty()) return result;
        
        wordBreak2Helper(s, dict, sol, result);
        
        return result;
    }
    
    private static void wordBreak2Helper(String s, Set<String> dict, String sol, ArrayList<String> result){
        if (dict.contains(s)){
            sol += " " + s;
            result.add(sol.trim());
            return;
        }
        
        for (int i=1; i<s.length(); i++){
            String aWord = s.substring(0, i);
            
            if (dict.contains(aWord)){
                //making a copy to let sub solution run independently
                String aSol = new String(sol);
                aSol += " " + aWord;
               
                Set<String> aDict = new HashSet<String>(dict);
                aDict.remove(aWord);
                
                wordBreak2Helper(s.substring(i), aDict, aSol, result);
            }
        }
        
        return ;
    }
}
