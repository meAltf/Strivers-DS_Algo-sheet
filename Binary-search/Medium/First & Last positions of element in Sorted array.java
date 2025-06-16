Problem statement :

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Solution : 
1. Brute force :

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, second = -1;

        for(int i=0; i<nums.length; i++){
            if(target == nums[i]){
                if(first == -1 && second == -1){
                    first = i;
                    second = i;
                } else second = i;
            }
        }
        int[] ans = {first, second};
        return ans;
    }
}

2. Optimal approach | Using lowerBound & upperBound

 class Solution {

    private static int lowerBoundBinary(int[] nums, int x) {
       int length = nums.length;
       int start = 0, end = length-1;
       int ans = length;
       
       while(start <= end){
            int mid = start + (end-start)/2;
            if (nums[mid] >= x) {
                ans = mid;
                end = mid-1;
            } else start = mid+1;
       }
       return ans;
    }

    private int upperBound(int[] nums, int x) {
        int length = nums.length;
        int start = 0, end = length-1;
        int ans = length;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] > x){
                ans = mid;
                end = mid-1;
            } else start = mid+1;
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        // edge case
        int n = nums.length;
        int lowerB = lowerBoundBinary(nums, target);
        if(lowerB == n || nums[lowerB] != target) return new int[]{-1,-1};
        return new int[]{lowerB, upperBound(nums, target)-1};
    }
}
