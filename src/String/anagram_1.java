package String;

public class anagram_1 {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public static boolean anagram(String s, String t) {
       if (s==null||t==null||s.length()!=t.length()){
           return false;
       }
       int[] s1=new int[256];
       int[] t1=new int[256];
       
       for(int i=0;i<s.length();i++){
           s1[s.charAt(i)]++;
           t1[t.charAt(i)]++;
         
          
       
       }

       
         for(int i=0;i<2;i++){
           if (s1[i]!=t1[i]) return false;  
          
         }     
         return true;
    }
    
    public static void main(String[] args) {
         System.out.println(anagram("ab", "ab"));
         System.out.print(new Integer('Z'));
    } 
    
};
