/*
 * Given an array of strings, return all groups of strings that are anagrams.

Example
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

Note
All inputs will be in lower-case
 */

package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public static List<String> anagrams(String[] strs) {
        // write your code here
        if (strs.length==0||strs==null) return null;
        List<String> res=new ArrayList<String>();
        Map<String, List<String>> map=new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++){
            
             // Sort the string.            
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String strSort = new String(chars);   
            
        
            
            if (map.containsKey(strSort)){
                map.get(strSort).add(strs[i]);
            }else{
                map.put(strSort,new ArrayList<String>());
                (map.get(strSort)).add(strs[i]);
            }
        }
        for(String key: map.keySet()){
            if (map.get(key).size()>1){
                res.addAll(map.get(key));
            }
        }
        return res;
    }
}
