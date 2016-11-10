package com.example.leet;
/**
 * Given a sequence of n numbers A1,A2...An, give an algorithm which checks whether 
 * there exists a subset of A whose sum of All number is K
 * 
 * @author bin zhou
 * @since 2016-02-07
 */

public class SubsetSumDP {
	public static void main(String[] args){
		int[] a = {7, 1, 3, 34, 4, 2};
		
		System.out.println("subsetSum(a, 6) \n Expected true: " + subsetSum(a, 6));
		
		System.out.println("subsetSum1(a, 6) \n Expected true: " + subsetSum1(a, 6));

		System.out.println("subsetSum(a, 14) \n Expected true: " + subsetSum(a, 14));
        
        System.out.println("subsetSum1(a, 14) \n Expected true: " + subsetSum1(a, 14));
	}

	/**
	 * DP to resolve with extra row and extra column 
	 * @param input
	 * @param k
	 * @return
	 */
	public static boolean subsetSum(int[] input, int k){
        if(input==null ||input.length==0)
            return false;
        
        boolean dp[][]=new boolean[k+1][input.length+1]; //boolean array, default is false
        
        //set dp[0][0] = true;
        for(int j =0;j<=input.length;j++)
            dp[0][j]= true;
        for(int i =1;i<=k;i++)
            dp[i][0]= false;
        
        for(int i =1; i<=k; i++){
            for(int j =1; j<=input.length; j++){
                if (i == input[j-1]){
                    //one element is enough
                    dp[i][j] = true;
                } else if (i > input[j-1]){
                    //including or excluding element input[j-1]
                    dp[i][j] = dp[i][j-1] || dp[i-input[j-1]][j-1];
                } else {
                    //excluding element input[j-1]
                    dp[i][j] = dp[i][j-1];
                }
                
            }
        }
        
        displayDPMatrix(dp);
        
        return dp[k][input.length];
    }
	
	/**
	 * DP to resolve with extra row(when k == 0) ONLY 
	 * @param input
	 * @param k
	 * @return
	 */
	public static boolean subsetSum1(int[] input, int k){
	    if (input == null || input.length == 0)
	        return false;
	    
	    boolean dp[][] = new boolean[k+1][input.length];
	    
	    //make sure all dp[0][j] = true for the case of target is 0 for no element
	    for (int j=0; j<input.length; j++){
	        dp[0][j] = true;
	    }
	    for (int i=1; i<=k; i++){
	        if (i==input[0]){
	            dp[i][0] = true;
	        }
	    }
	    
	    for (int i=1; i<=k; i++){
	        for (int j=1; j<input.length; j++){
	            if (i == input[j]){
	                dp[i][j] = true;
	            } else if (i>input[j]){
	                dp[i][j] = dp[i][j-1] || dp[i-input[j]][j-1];
	            } else {
	                dp[i][j] = dp[i][j-1];
	            }
	        }
	    }
	    
	    
	    displayDPMatrix(dp);
        
	    return dp[k][input.length-1];
	}
	
	/**
     * print out dp matrix
     * @param dp
     */
    private static void displayDPMatrix(boolean[][] dp){     
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }
    }
	
}





