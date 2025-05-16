Problem: Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.


Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
  
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Brute force : 

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n; // handle case where k>n
        int[] temp = new int[n];

        // placing last k elements of the original array at the beginning of the temp array.
        for(int i=0; i<k; i++){
            temp[i] = nums[n-k+i];
        }

        // placing remaining elements from start to end of the original array after the last K elements.
        for(int i=0; i<n-k; i++){
            temp[k+i] = nums[i];
        }

        // Now copy temp array to nums
        for(int i=0; i<n; i++){
            nums[i] = temp[i];
        }
    }
}



Optimal approach :

class Solution {
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        // handle case wher k>n
        k = k % n;

        // reverse the entire array
        reverse(nums, 0, n-1);

        // reverse the remaining k elements
        reverse(nums, 0, k-1);

        // reverse the remaining n-k elements
        reverse(nums, k, n-1);
    }
}
