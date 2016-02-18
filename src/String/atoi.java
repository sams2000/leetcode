package String;
/*
 * Implement function atoi to convert a string to an integer.

If no valid conversion could be performed, a zero value is returned.

If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

Example
"10" => 10

"-1" => -1

"123123123123123" => 2147483647

"1.0" => 1


 */
public class atoi {
	  public int atoi(String str) {
	        // write your code here
	        if (str.length()==0) return 0;
	        str=str.trim();
	        //check if it has negative value
	        boolean signed=false;
	        if (str.charAt(0)=='-'){
	            signed=true;
	            str=str.substring(1);
	        }else if (str.charAt(0)=='+'){
	            str=str.substring(1);
	        } 
	        
	        long res=0;
	        int idx =0;
	        while(idx<str.length()){
	          int temp=str.charAt(idx)-'0';
	          if (temp<0||temp>9){
	              break;
	          }    
	            res=res*10+temp;
	            idx++;
	            if (!signed&&res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
	            if (signed&&res-Integer.MAX_VALUE>1) return Integer.MIN_VALUE;
	        }
	        if (!signed) return (int)res;
	        else return (int)(0-res);
	    }
}
