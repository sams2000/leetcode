package com.example.leet;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 * @author bin zhou
 * @since 2016-02-02
 */
public class Interleaving {
    public static void main(String[] args) {
        String s1 = "XXY", s2 = "XXZ", s3 = "XXXXYZ";
        System.out.println("isInterleave ? " + isInterleave(s1, s2, s3));
    }
    
    /**
     * DP solution, leetcode accepted!
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        int M = s1.length(), N = s2.length();

        //combination length is not correct, sanity check
        if (M + N != s3.length())
            return false;
        
        //s1, s2 and s3 are empty, sanity check
        if (M == 0 && N == 0 && s3.length() == 0)
            return true;
        
        //initialize a dp matrix, s1 as rows and s2 as columns
        boolean[][] dp = new boolean[M + 1][N + 1];

        // starting row as s1 is empty
        for (int j = 0; j <= N; j++) {
            if (j == 0 || (dp[0][j-1] == true && s2.charAt(j-1) == s3.charAt(j-1))){
                dp[0][j] = true;
            } else
                dp[0][j] = false;
        }
        
        // starting column as s2 is empty
        for (int i = 0; i <= M; i++) {
            if (i == 0 || (dp[i-1][0] == true && s1.charAt(i-1) == s3.charAt(i-1))){
                dp[i][0] = true;
            } else
                dp[i][0] = false;
        }

        // fill remaining dp elements
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                // Current s3 character matches current s1 character, but doesn't match current s2 character
                if ((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1 ))
                    || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))){
                    dp[i][j] = true;
                } 
            }
        }

        return dp[M][N];      
    }
}
