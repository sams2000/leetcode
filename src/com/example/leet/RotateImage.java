package com.example.leet;

/**
 * You are given an n x n 2D matrix representing an image. Rotate the image by
 * 90 degrees (clockwise). Follow up: Could you do this in-place? this algorithm
 * is O(NxN), which is the best we can do since any algorithm much touch all n x
 * n elements
 * 
 * @author bin zhou
 * @since 2016-02-07
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
        
        System.out.println("Before rotation: " );
        displayMatrix(matrix);
        
        rotate(matrix);
        
        System.out.println("After rotation: " );
        displayMatrix(matrix);
    }
    
    private static void displayMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println(";");
        }        
    }

    /**
     * rotate in place
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        if (N == 0)
            return ;

        for (int layer = 0; layer < N / 2; layer++) {
            for (int j = layer; j < N - 1 - layer; j++) {//first element to last element in this layer

                // save top
                int top = matrix[layer][j];
                // move left -> top
                matrix[layer][j] = matrix[N - 1 - j][layer];
                // move bottom -> left
                matrix[N - 1 - j][layer] = matrix[N - 1 - layer][N - 1 - j];
                // move right -> bottom
                matrix[N - 1 - layer][N - 1 - j] = matrix[j][N - 1 - layer];
                // move top -> right
                matrix[j][N - 1 - layer] = top;
            }
        }
    }
}
