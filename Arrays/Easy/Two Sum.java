PROBLEM: 

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


SOLUTION 

1. Brute -force :

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];

        for(int i=0; i<nums.length; i++){
            for(int j = 1; j<nums.length; j++){
                if(i != j && nums[i] + nums[j] == target){
                    temp[0] = i;
                    temp[1] = j;
                    break;
                }
            }
        }
        return temp;
    }
}


2. Better Approach - Using HashMap

 import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i< nums.length; i++){
            int element = nums[i];
            int needed = target - element;
            if(map.containsKey(needed) && i != map.get(needed)){
                temp[0] = map.get(needed);
                temp[1] = i;
                break;
            }
        }

        return temp;
    }
}
