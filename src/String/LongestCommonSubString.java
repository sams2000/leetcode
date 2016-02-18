/*
 * Given two strings, find the longest common substring.

Return the length of it.

Example
Given A = "ABCD", B = "CBCE", return 2.

Note
The characters in substring should occur continuously in original string. This is different with subsequence.

Challenge
O(n x m) time and memory.
 * 
 */

package String;

public class LongestCommonSubString {
	 /**
      Solution 1: O(n*m*m)
     */
    public int longestCommonSubstring(String A, String B) {
         if (A==null||B==null) return 0;
         if (B.length()==0||A.length()==0){
              return 0;
         }
         int max=0;
         String A1=A.length()>B.length()?A:B;
         String B1=A.length()>B.length()?B:A;
         for(int i=0;i<A1.length()-max;i++){
             
              for(int j=0;j<B1.length()-max;j++){
                int temp=0;
                for(int k=0;k<B1.length()-j;k++){ 
                     
                    if (A1.charAt(k+i)==B1.charAt(j+k)){
                      temp++;
                     
                    }else{
                        break;
                        
                    }
                }  
                max=max<temp?temp:max;
               } 
         }
         return max;
    }
    
    /*
     * Solution 2: DP O(n*m)
     */
    public int longestCommonSubstring2(String A, String B) {
        if (A==null||B==null) return 0;
        int lenA=A.length();
        int lenB=B.length();
        int[][] matrix=new int[lenA+1][lenB+1];
        int max=0;
        for(int i=0;i<=lenA;i++){
            for(int j=0;j<=lenB;j++){
                if (i==0||j==0){
                    matrix[i][j]=0;
                }else{
                    matrix[i][j]=A.charAt(i-1)==B.charAt(j-1)?matrix[i-1][j-1]+1:0;
                }
                max=max<matrix[i][j]?matrix[i][j]:max;
            }
        }
        return max;
   }
}
