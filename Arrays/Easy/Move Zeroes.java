Problem: Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.


Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

  
Example 2:

Input: nums = [0]
Output: [0]

Solution:

1- Two pointer approach:

class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0, end = 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[start] == 0 && nums[end] != 0){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end++;
            } else if (nums[start] != 0){
                 start++;
                 if(start == end) end++;
            } else {
                end++;
            }
        }
    }
}


2- Through array pass :


class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, k = 0;

        // shift non-zero elements first
        for(int num: nums){
            if(num != 0) nums[k++] = num;
        }
        
        // rest of the field filled with zero
        while(k < n){
            nums[k++] = 0;
        }
    }
}
