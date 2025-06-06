problem:

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3


Solution : 

1. Brute force :

  class Solution {
    private boolean search(int[] arr, int x){
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] == x) return true;
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
      if(nums.length == 0) return 0;

      int largest = 1;
      int n = nums.length;

      for(int i=0; i<n; i++){
        int x = nums[i];
        int count = 1;

    // go & search until sequece persist
        while(search(nums, x+1) == true){
            count++;
            x+=1;
        }
        largest = Math.max(count, largest);
      }
      return largest;
    }
}


2. Better Approach :

class Solution {

    public int longestConsecutive(int[] nums) {
      int n = nums.length;
      if(n == 0) return 0;
      int lastSmallest = Integer.MIN_VALUE;
      int cnt = 0;
      int largest = 1;

      Arrays.sort(nums);
      for(int i=0; i<nums.length; i++){

        if(nums[i]-1 == lastSmallest){
            cnt++;
            lastSmallest = nums[i];
        } else if(nums[i] != lastSmallest) {
            lastSmallest = nums[i];
            cnt = 1;
        }
        largest = Math.max(cnt, largest);
      }
      return largest;
    }
}



