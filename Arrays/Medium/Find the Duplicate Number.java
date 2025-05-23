Problem statement 

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3



Solution 

1. Brute force 

class Solution {
    public int findDuplicate(int[] nums) {
        // duplicate find krna hai bc
        int n = nums.length;
        for(int i=0; i<n; i++){
            int elem = nums[i];
            for(int j=i+1; j<n; j++){
                if(elem == nums[j]) return elem; 
            }
        }
        return 0;
    }
}

2. Better approach 

 class Solution {
    public int findDuplicate(int[] nums) {
        // duplicate find krna hai bc
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(nums[i] == nums[i+1]) return nums[i];
        }
        return 0;
    }
}

3. Better approach : using hashing

 import java.util.HashMap;
class Solution {
    public int findDuplicate(int[] nums) {
        // duplicate find krna hai bc | use hashing
        int n = nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // putting in map
        for(int num : nums){
            if(freqMap.containsKey(num)){
                freqMap.put(num, freqMap.get(num)+1);
            }else{
                freqMap.put(num,1);
            }
        }

        // traversing over map to check duplicate
        for(int num : freqMap.keySet()){
            if(freqMap.get(num) >= 2) return num;
        }
        return 0;
    }
}
