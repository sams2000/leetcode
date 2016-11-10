package com.example.leet;

import java.util.ArrayList;
import java.util.List;
/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



    Given an integer n, return all distinct solutions to the n-queens puzzle.
    
    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
    
    For example,
    There exist two distinct solutions to the 4-queens puzzle:
    
    [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],
    
     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
 * @author bzhou3
 *
 */
public class NQueens {

	public static void main(String[] args) {
	    List<List<String>> result = solveNQueens(8);

		int count = 1;
		for (List<String> sol : result){
			for (String s : sol)
				System.out.println(s);
			System.out.println("***********************solution " + count++);
		}
	}

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();  
        //initialize one row, each element record the COLUMN position of queen for each row
		int[] loc = new int[n];  
        solveNQueensHelper(result, loc, 0, n);  
        return result;  
    }    
    
    public static void solveNQueensHelper(List<List<String>> result, int[] loc, int curRow, int n){  
        //when it finishes last row 
    	if(curRow==n)   
    	    addSolution(result,loc,n);  
        else{  
            for(int i=0;i<n;i++){  
                loc[curRow] = i;  
                if(isValid(loc,curRow))  
                    solveNQueensHelper(result,loc,curRow+1,n);  
            }  
        }  
    }  
    
    public static boolean isValid(int[] loc, int curRow){  
        for(int i=0;i<curRow;i++){  
        	//check no queen conflicts, each COLUMN and each diagonal line
            if(loc[i]==loc[curRow]||Math.abs(loc[i]-loc[curRow])==(curRow-i))  
                return false;  
        }  
        return true;  
    }  
      
    public static void addSolution(List<List<String>> result, int[] loc, int n){
        List<String> sol= new ArrayList<String>();
        for (int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++){
                if (loc[i] == j){
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            sol.add(sb.toString());
        }
        
        result.add(sol);
    }
}


