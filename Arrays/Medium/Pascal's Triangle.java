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
  // variant : 1
  // it will find the num at given row & col place in pascal's triangle
    private int pascalTriangle(int r, int c){
        int element = (int)nCr(r-1, c-1);
    }

    private int nCr(int n, int r){
        int result = 1;
        for(int i=0; i<r; i++){
            result = result * (n-i);
            result = (result/(i+1));
        }
        return result;
    }

    public void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
    }

// Variant : 2
// Given the row number n. Print the n-th row of Pascal’s triangle.
1. Brute force 
  
    private void pascalTriangle(int n){
        for(int c=1; c<=n; c++){
            System.out.print(nCr(n-1, c-1) + " ")
        }
        System.out.println();
    }

    private int nCr(int n, int r){
        int result = 1;
        for(int i=0; i<r; i++){
            result = result * (n-i);
            result = (result/(i+1));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        pascalTriangle(n);
    }

2. Better/optimal approach 

// Given the row number n. Print the n-th row of Pascal’s triangle.
    private void pascalTriangle(int n){
        int ans = 1;
        System.out.print(ans + " "); // printing first element

        // printing rest elements
        for(int i=1; i<n; i++){
            ans = ans * (n-i);
            ans = ans/i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        pascalTriangle(n);
    }
