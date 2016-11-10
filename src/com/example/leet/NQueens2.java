package com.example.leet;

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * @author Bin Zhou
 * 
 */
public class NQueens2 {
    public int count = 0;
    
	public static void main(String[] args) {
	    int n = 8;
	    System.out.println("Total solutions for " + n + " queens: " + new NQueens2().totalNQueens(n));
	}

    public int totalNQueens(int n) {
        int[] loc = new int[n];
        
        dfs(loc, 0, n);
        
        return count;
    }
    
    public void dfs(int[] loc, int curRow, int n){
        if (curRow == n){
            count ++;
        } else {
            for (int i=0; i<n; i++){
                loc[curRow] = i;
                if (isValid(loc, curRow)){
                    dfs(loc, curRow+1, n);
                }
            }
        }
    }
    
    public boolean isValid(int[] loc, int curRow){
        for (int i=0; i<curRow; i++){
            if (loc[i] == loc[curRow] || Math.abs(loc[i] - loc[curRow]) == (curRow-i)){
                return false;
            }
        }
        return true;
    }
}


