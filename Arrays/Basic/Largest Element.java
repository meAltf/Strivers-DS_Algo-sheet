Q- Given an array of integers nums, return the value of the largest element in the array

Examples:
Input: nums = [3, 3, 6, 1]
Output: 6
Explanation: The largest element in array is 6


Input: nums = [3, 3, 0, 99, -40]
Output: 99
Explanation: The largest element in array is 99

Solution:

class Solution {
    public int largestElement(int[] nums) {
    if (nums == null || nums.length == 0) {
        throw new IllegalArgumentException("Array must not be null or empty");
    }
    int largestNum = Integer.MIN_VALUE;
    for (int num : nums) {
        if (num > largestNum) {
            largestNum = num;
        }
    }
    return largestNum;
  }
}
