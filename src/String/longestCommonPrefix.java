/*iven k strings, find the longest common prefix (LCP).

Example
For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"

For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
*/
package String;

public class longestCommonPrefix {
	 public String longestCommonPrefix(String[] strs) {
	        if (strs==null||strs.length==0) return "";
	        if (strs.length==1) return strs[0];
	        StringBuilder res=new StringBuilder();
	        int idx=0;
	        int minLen=strs[0].length();
	        
	        for(String s:strs){
	            minLen=Math.min(minLen,s.length());
	        }
	        
	        for(int i=0;i<minLen;i++){
	            char temp=strs[0].charAt(i);
	            for(int j=1;j<strs.length;j++){ 
	                  if (temp==strs[j].charAt(i)){    
	                    if (j==strs.length-1){
	                        res.append(temp);
	                    } 
	                  }else{
	                      break;
	                  }    
	               
	            }
	        }
	        return res.toString();
	    }
}
