package com.example.leet;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
    Follow up:
    Did you use extra space?
    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?

 * @author bin zhou
 * @since 2/4/2013
 */
public class SetMatrixZeroes{
    public static void main(String[] args){
        // TODO Auto-generated method stub
        int[][] inMatrix = new int[][]{{0, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("After rotation: " );
        
        setZeroes(inMatrix);
        for (int i=0; i<inMatrix.length; i++){
            for (int j=0; j<inMatrix[i].length; j++){
                System.out.print(inMatrix[i][j]);
            }
             System.out.println(";" );
        }
    }	
	
	public static void setZeroes(int[][] matrix) {
		boolean firstRowZero = false;
		boolean firstColZero = false;

		// check whether there exists 0 in first column
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}

		// check whether there exists 0 in first row
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			}
		}

		// set first row element and first column element to 0 if [i][j] element
		// is 0, this time needs to start to check from index 1 only since index 0 
		// has been checked above
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				// if element [i][j] is zero, set first element of such row and
				// such column to zero
				if (matrix[i][j] == 0) {
					if (matrix[i][0] != 0) {
						matrix[i][0] = 0;
					}
					if (matrix[0][j] != 0) {
						matrix[0][j] = 0;
					}
				}
			}
		}

		// second loop to set all rows from second row
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (matrix[i][j] != 0) {
						matrix[i][j] = 0;
					}
				}
			}
		}

		// loop to set all columns from second column
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < matrix.length; i++) {
					if (matrix[i][j] != 0) {
						matrix[i][j] = 0;
					}
				}
			}
		}

		// if 0 in first row, set all first row elements to 0
		if (firstRowZero) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		// if 0 in first column, set all first column elements to 0
		if (firstColZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

	}
    
}



