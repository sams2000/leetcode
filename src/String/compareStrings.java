package String;

import java.util.HashMap;
import java.util.Map;


public class compareStrings {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    // O(n) O(n) space
	public static boolean compareStrings(String A, String B) {
        char[] a= A.toCharArray();
        char[] b= B.toCharArray();
        if (b==null||b.length==0) return true;
        if (a==null||a.length==0) return false;
        Map<Character , Integer > m = new HashMap<Character, Integer>();
        for(int i=0;i<A.length();i++){
            if (m.containsKey(A.charAt(i))){
                m.put(A.charAt(i),m.get(A.charAt(i))+1);
                
            }else{
                 m.put(A.charAt(i),1);
            }
            System.out.println(A.charAt(i) + " "+ m.get(A.charAt(i)));
        }
        
        for(int i=0;i<B.length();i++){
              if (m.containsKey(B.charAt(i))){
                 if (m.get(B.charAt(i))>0) {
                    m.put(B.charAt(i),m.get(B.charAt(i))-1);
                 }else{ 
                     return false;
                 }    
            }else{
                return false;
            } 
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(compareStrings("ABCDEFG", "ACC"));
   } 
    
    // solutin --simple
    public boolean compareStrings2(String A, String B) {
        int[] a=new int[26];
        int[] b=new int[26];
        for(int i=0;i<A.length();i++){
            a[A.charAt(i)-'A']++;
        }
        for(int j=0;j<B.length();j++){
             char temp=B.charAt(j);
             b[temp-'A']++;
             if (b[temp-'A']>a[temp-'A']) return false;
        }
        return true;
    }
}