Problem statement 

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Solution :

1. Brute force 

  class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int maxCount = 0, ans = Integer.MIN_VALUE;

        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            int count = 0;
            int current = nums[i];
            for(int j=i; j<n; j++){
                if(nums[i] == nums[j]) count++;
            }

            if(count>maxCount){
                maxCount = count;
                ans = current;
            }
        }
        return ans;
    }
}
