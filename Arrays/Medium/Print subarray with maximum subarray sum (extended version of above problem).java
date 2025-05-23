Problem statement 

Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

Examples
Example 1:

Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 

Output: 6 

Explanation: [4,-1,2,1] has the largest sum = 6. 

Examples 2: 

Input: arr = [1] 

Output: 1 

Explanation: Array has only one element and which is giving positive sum of 1. 




Solution 
1. Optimal approach

class Solution {
    public int maxSubArray(int[] nums) {
        // subarray with largest sum
        int maxSum = Integer.MIN_VALUE, n = nums.length;
        int sum = 0;

        int start = 0;
        int startIndex=-1, endIndex=-1;

        for(int i=0; i<n; i++){

            // to keep track of startingIndex & endingIndex for largest sum subarray
            if(sum == 0) start = i; // starting index

            sum+=nums[i];
            if(sum > maxSum){
                maxSum = sum;

                startIndex = start;
                endIndex = i;

            }
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}
