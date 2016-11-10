package String;
/**
 * given k strings, find the longest common prefix (LCP).

Example
For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"

For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
*/
public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs1={  "ABED",
                "ABEF",
                "ACEF"};
        System.out.println("LCP is " + lcp(strs1));
        
        
        String[] strs2={  "ABCDEFG",
                "ABCEFG",
                "ABCEFA"};
        System.out.println("LCP is " + lcp(strs2));
        
    }
    
    /*
     * O(m*n) m - min length of string; n - number of strings 
     */
	 public static String lcp(String[] strs) {
	        if (strs==null||strs.length==0) return "";
	        if (strs.length==1) return strs[0];
	        StringBuilder res=new StringBuilder();
	        
	        int minLen=Integer.MAX_VALUE;
	        
	        for(String s:strs){
	            minLen=Math.min(minLen,s.length());
	        }
	        
	        for(int i=0;i<minLen;i++){
	            char tmp=strs[0].charAt(i);
	            for(int j=1;j<strs.length;j++){ 
	                if (tmp!= strs[j].charAt(i)){
	                    return res.toString();
	                }
	            }
	            
	            res.append(tmp);
	        }
	        return res.toString();
	    }
}