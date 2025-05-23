Problem statement 

Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Solution

1. Brute force

class Solution {
    public int maxSubArray(int[] nums) {
        // subarray with largest sum
        int maxSum = Integer.MIN_VALUE, n = nums.length;
        
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum+= nums[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}


2. Better Approach

 class Solution {
    public int maxSubArray(int[] nums) {
        // subarray with largest sum
        int maxSum = Integer.MIN_VALUE, n = nums.length;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum+=nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}


3. Optimal approach : kadane's algorithm


 class Solution {
    public int maxSubArray(int[] nums) {
        // subarray with largest sum
        int maxSum = Integer.MIN_VALUE, n = nums.length;
        int sum = 0;

        for(int i=0; i<n; i++){
            sum+=nums[i];
            //if(sum > maxSum) maxSum = sum;
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}
