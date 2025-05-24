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
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=i; j<n; j++){
                if(nums[i] == nums[j]) count++;
            }

            if(count>n/2) return nums[i];
        }
        return ans;
    }
}



2. Better approach : using hashing

 class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int ans = Integer.MIN_VALUE;

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // put the elements, count into map
        for(int num : nums){
           if(freqMap.containsKey(num)){
            freqMap.put(num, freqMap.get(num)+1);
           }else{
            freqMap.put(num,1);
           }
        }

        // traverse and found num that appear more than n/2 times
        for(int num : nums){
            if(freqMap.get(num) > n/2) return num;
        }
        return ans;
    }
}


3. Optimal Approach 

class Solution {
    public int majorityElement(int[] nums) {
        // using Moove's voting algorithm
        int n = nums.length;
        int count = 0, elem = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(count ==0){
                elem = nums[i];
                count = 1;
            } else if(elem == nums[i]){
                count++;
            } else {
                count--;
            }
        }
        return elem;
    }
}
