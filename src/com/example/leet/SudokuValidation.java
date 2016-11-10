package com.example.leet;

/**
 * Validate sudoku board to check each column, each row, and each of the nine 3×3 sub-grids contains all of the digits from 1 to 9
 * @author bin zhou
 * @since 2016-02-07
 */
public class SudokuValidation {

	public static void main(String[] args) {
		//input sudoku board
		char[][] board = {
				{'.', '8', '7', '6', '5', '4', '3', '2', '1'},	
				{'2', '.', '.', '.', '.', '.', '.', '.', '.'},	
				{'3', '.', '.', '.', '.', '.', '.', '.', '.'},	
				{'4', '.', '.', '.', '.', '.', '.', '.', '.'},	
				{'5', '.', '.', '.', '.', '.', '.', '.', '.'},	
				{'6', '.', '.', '.', '.', '.', '.', '.', '.'},	
				{'7', '.', '.', '.', '.', '.', '.', '.', '.'},	
				{'8', '.', '.', '.', '.', '.', '.', '.', '.'},	
				{'9', '.', '.', '.', '.', '.', '.', '.', '.'}	
				};


		System.out.println("this is valid sudoku board? " + isValidSudokuBoard(board));
	}

   public static boolean isValidSudokuBoard(char[][] board) {       
       for (int row=0; row<9; row++){
           for (int col=0; col<9; col++){
               if (board[row][col] != '.' && !isValid(board, row, col)){
                   return false;
               }
           }
       }
       
       return true;
    }
    
    public static boolean isValid(char[][] board, int row, int col){
        //get char value in board
        char c = board[row][col];
        
        //check row
        for (int j=0; j<9; j++){
            if (j != col && board[row][j] == c)
                return false;
        }
        
        //check column
        for (int i=0; i<9; i++){
            if (i != row && board[i][col] == c)
                return false;
        }
        
        //check square
        for (int i=row/3*3; i<row/3*3+3; i++){
            for (int j=col/3*3; j<col/3*3+3; j++){
                if (i != row && j != col && board[i][j] == c)
                    return false;
            }
        }
        
        return true;
    }  
}
