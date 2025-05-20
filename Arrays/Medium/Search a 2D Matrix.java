PROBlem :

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Solution : 

1. Brute-force:

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
}

2. Better approach : using Binary search

 class Solution {
    private boolean searchFun(int[] nums, int target){
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid]== target) return true;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
 
    public boolean searchMatrix(int[][] matrix, int target) {
        // Now, need to solve it in O(log(m*n))
        int m = matrix.length;

        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] <= target && target <= matrix[i][matrix[i].length-1]){
               return searchFun(matrix[i], target);
            }
        }
        return false;
        
    }
}


3. Optimal Approach : flatten 2D array into 1D using divide & module operator

public boolean searchMatrix(int[][] matrix, int target) {
        // Now, need to solve it in O(log(m*n))
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = (m*n)-1;

        // check for empty matrix or empty row
        if (m == 0 || matrix[0].length == 0) return false; 

        while(low <= high){
            int mid = (low+high)/2;

            int row = mid/n, col = mid%n; // remember this

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
