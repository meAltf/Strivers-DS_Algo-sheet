Problem statement

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]


Solution :
1. Brute force :

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<nums.length; i++){
            int count = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[i] == nums[j]) count++;
            }
            if(count > n/3) ans.add(nums[i]);
        }

        // return list not set
        List<Integer> result = new ArrayList<>();
        for(int num : ans){
            result.add(num);
        }

        return result;
    }
}
