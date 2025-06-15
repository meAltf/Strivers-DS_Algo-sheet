Problem statement :

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, 
return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Solution :
1. Brute Force :

  class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target) return i;
            if(nums[i] > target) return i;
        }
        return ans;
    }
}

2. Optimal approach :

class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        int start = 0, end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target) return mid;

            else if(nums[mid] > target){
                ans = mid;
                end = mid-1;
            } else start = mid+1;
        }
        return ans;
    }
}
