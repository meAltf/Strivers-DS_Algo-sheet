Problem statement 

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
  
Example 2:

Input: numRows = 1
Output: [[1]]


Solution
1. Brute force 

  // it will find the num at given row & col place in pascal's triangle
    findNum(row-1, col-1, nums);
    private int findNum(int row, int col, int[] nums){
        int n = nums.length;
        int result = 1;
        for(int i=0; i<n; i++){
            result = result * (n-i);
            result = (result/(i+1));
        }
        return result;
    }
