package com.example.leet;

/**
 * Function to solve sudoku board 
 * @author Bin Zhou
 * @since 2016-02-07
 */
public class SudokuSolver {

	public static void main(String[] args) {
	    //input sudoku board
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},	
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},	
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},	
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},	
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},	
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},	
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},	
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},	
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}	
				};
		
		solveSudoku(board);
		//expected output
    	/*	5,3,4,6,7,8,9,1,2,
    		6,7,2,1,9,5,3,4,8,
    		1,9,8,3,4,2,5,6,7,
    		8,5,9,7,6,1,4,2,3,
    		4,2,6,8,5,3,7,9,1,
    		7,1,3,9,2,4,8,5,6,
    		9,6,1,5,3,7,2,8,4,
    		2,8,7,4,1,9,6,3,5,
    		3,4,5,2,8,6,1,7,9,*/

        displayBoard(board);

	}

	/**
	 * DFS solution to list all possible choices 
	 * @param board
	 * @return
	 */
    public static void solveSudoku(char[][] board){
        helper(board);
    }
    
    public static boolean helper(char[][] board){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j] == '.'){
                    for (char k='1'; k<='9'; k++){
                        if (isValid(board, i, j, k)){
                            board[i][j] =k;
                            if(helper(board)){
                                return true;
                            } 
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isValid(char[][] board, int i, int j, char c){
        // check column
        for (int row=0; row<9; row++){
            if (board[row][j]==c){
                return false;
            }  
        }
        // check row
        for (int col=0; col<9; col++){
            if (board[i][col]==c){
                return false;
            }
        }
        // check block
        for(int row=i/3*3; row<i/3*3+3; row++){
            for (int col=j/3*3; col<j/3*3+3; col++){
                if (board[row][col]==c){
                    return false;
                }
            }
        }
       
        return true;
    }      

    private static void displayBoard(char[][] board) {
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }    
}