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
