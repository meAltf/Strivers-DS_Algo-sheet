Problem statement 

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
  with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Solution :

1. Brute force : using sorting

  class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

2. Better approach 

class Solution {
    public void sortColors(int[] nums) {
        //Arrays.sort(nums);
        int red=0, white=0, blue=0, n=nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] == 0) red++;
            if(nums[i] == 1) white++;
            if(nums[i] == 2) blue++;
        }

        int i=0;
        int[] temp = new int[n];
        while(red-- > 0) temp[i++] = 0;
        while(white-- > 0) temp[i++] = 1;
        while(blue-- > 0) temp[i++] = 2;

        for(int k=0; k<n; k++){
            nums[k] = temp[k];
        }
    }
} 


3. Optimal Approach : Dutch National Flag Algorithm


  class Solution {

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        //Arrays.sort(nums);
        // Dutch National Flag Algorithm
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;

        for(int i=0; i<n; i++){
            if(nums[mid] == 0){
                swap(mid, low, nums);
                low++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            } else{
                swap(mid,high, nums);
                high--;
            }
        }
    }
} 
