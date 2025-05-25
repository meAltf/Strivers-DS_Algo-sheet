Problem statement

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

solution :

1. Brute force : if matrix contains only 1 & 0 

  class Solution {
    private void setRowZeroes(int[][] arr, int n, int m, int i){

        for(int k=0; k<m; k++){
            if(arr[i][k] != 0){
                arr[i][k] = Integer.MIN_VALUE + 1;
            }
        }
    }

    private void setColZeroes(int[][] arr, int n, int m, int j){
        for(int k=0; k<n; k++){
            if(arr[k][j] != 0){
                arr[k][j] = Integer.MIN_VALUE + 1;
            }
        }
    }

    private void convertToZero(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == Integer.MIN_VALUE + 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        // Brute force :
        if(matrix.length == 0 || matrix == null) return;

        int row = matrix.length, col = matrix[0].length;

        for(int i=0;i<row; i++){
            for(int j=0;j<col; j++){
                if(matrix[i][j] == 0){
                    setRowZeroes(matrix, row, col, i);
                    setColZeroes(matrix, row, col, j);
                }
            }
        }
        convertToZero(matrix);
    }
}
