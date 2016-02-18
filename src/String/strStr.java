package String;

class strStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
	  public static int strStr(String source, String target) {
	         
	        if (target==null||source == null) return -1;
	        if (source.length()==0&&source.equals(target)) return 0;
	        int j;
	        for(int i=0;i<source.length()  ;i++){
	            for(j=0;j<target.length();j++){
	                if (source.charAt(i+j)!=target.charAt(j)){break;}
	            }
	            if (j==target.length()){return i;}
	        }
	        
	        return -1;
	    }
    
    public static void main(String[] args) {
      //  System.out.println(strStr("", ""));
    	String a=" #  5    7";
    	String[] t=a.split("\\s+");
    	for(int i=0;i<t.length;i++){
    		System.out.println(t[i]);
    	}
    	System.out.println(maxProfit(null));
   } 
    
    public static int maxProfit(int[] prices) {
    	if (prices==null) return 1;
    	return 0;
    }
    
    
    /// good solution
    public int strStr1(String source, String target) {
        //Check Null
        if(source == null || target == null){
            return -1;
        }
        //Two Pointer check for target
        int i,j;
        for (i = 0; i < source.length() - target.length() + 1; i++){
            for (j = 0; j < target.length(); j++){
                if (source.charAt(i+j) != target.charAt(j)){
                    break; 
                } 
            }
            if( j == target.length()){
                return i;
            }
        }
        //'target' not found:
        return -1;
}
}
