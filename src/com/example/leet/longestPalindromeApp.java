package com.example.leet;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * Two solutions below have same logic in it. one using external method, another is using inner while loop
 * @author bz250056
 * @since 2014-03-11
 */
public class longestPalindromeApp {

	public static void main(String[] args) {

		String s = "ccddcc";
		System.out.println("longest palindrome string : " + longestPalindromeDP1(s));
	}
	

	/**
	 * iterative solution 1
	 * @param s
	 * @return
	 */
	public static String longestPalindrome1(String s) {
		if (s.isEmpty()) return "";
		if (s.length() == 1) return s;
			 
		String longest = "";
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			// update to current palindrome string if it's longer
			if (tmp.length() > longest.length()) 
				longest = tmp;
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			// update to current palindrome string if it's longer
            if (tmp.length() > longest.length()) 
				longest = tmp;
		}
	 
		return longest;
	}
	 
	// Given a center, either one letter or two letter, find the longest palindrome
	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}	
	
	
	/**
	 * iterative solution 2, same solution as longestPalindrome1, using for loop instead
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s){
		int n = s.length();
		
		if (n==0) return "";
		
		int maxi = 0;
		int maxl = 1;
		for (int i=0; i<n; i++){
			for (int j=0; j<2; j++){//the center can be one letter, or two same letters
                int start = i - j;
                int end = i + 1;
                while (start >= 0 && end <= n-1 && s.charAt(start) == s.charAt(end)){
                	start--;
                	end++;
                }

                start++;
                end--;
                int len = end - start + 1;
                if (len > maxl){
                	maxi = start;
                	maxl = len;
                }
			}
		}
		return s.substring(maxi, maxi+maxl);
	}	
	
	/**
	 * DP-2D matrix solution : clean and good
	 * @param s
	 * @return
	 */
    public static String longestPalindromeDP1(String s) {
        int N = s.length();
        if (s == null || N<=1) return s;
        
        String res = "";
        boolean[][] dp = new boolean[N][N];
        
        for (int i=N-1; i>=0; i--){
            for (int j=i; j<N; j++){
                //when j-i<2(aka==0, ==1, one charactere, or two characters)
                if (s.charAt(i) == s.charAt(j) && (j-i<2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if (j-i+1 > res.length()){
                        res = s.substring(i, j+1);
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return res;        
    }	
	
	/**
	 * DP-2D matrix solution : not clean
	 * @param s
	 * @return
	 */
    public static String longestPalindromeDP2(String s) {
        int N = s.length();
        if (N<=1) return s;
        
        boolean[][] dp = new boolean[N][N];
        //all substring of length 1 are palindromes
        int maxLength = 1;
        int i=0;
        while (i<N) dp[i][i++] = true;
        
        //check substrings of length 2
        int palindromeStart = 0;
		for (i=0; i<N-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                palindromeStart = i;
                maxLength = 2;
            }
        }
        
        //check substrings of length 3 and up
        for (int len=3; len<=N; len++){
            //fix hte starting index, N-len is the last possible start index
            for (int start=0; start<=N-len; start++){
                //get the ending index of substring from starting index i and length k
                int end = start + len -1;
                //check substring from index start to index end iff [start+1] to [end-1] is a palindrome
                if (dp[start+1][end-1] && s.charAt(start) == s.charAt(end)){
                    dp[start][end] = true;
                    if (len > maxLength){
                        maxLength = len;
                        palindromeStart = start;
                    }
                }
            }
        }
        
        return s.substring(palindromeStart, palindromeStart + maxLength );
    }
	

}



