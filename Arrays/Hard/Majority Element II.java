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

2. Better approach : using Hashing

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freqNum = new HashMap<>();

        for(int num : nums){
            if(freqNum.containsKey(num)){
                freqNum.put(num, freqNum.get(num)+1);
            }else{
                freqNum.put(num, 1);
            }
        }

        Set<Integer> result = new HashSet<>();
        for(int num : nums){
            if(freqNum.get(num) > n/3) result.add(num);
        }

        List<Integer> finalResult = new ArrayList<>();
        for(int num : result) finalResult.add(num);

        return finalResult;
        
    }
}

3. Brute force : optimized

 class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(result.size() == 0 || result.get(0) != nums[i]){
                int count =0;
                for(int j = 0; j<n; j++){
                    if(nums[i] == nums[j]) count++;
                }
                if(count > n/3) result.add(nums[i]);
            }
            if(result.size() == 2) break;
        }
        return result;
    }
}

4. Optimal approach :

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Optimal approach | Voote's moove algorithm
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        int count1 =0, count2=0, element1=Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(count1 == 0 && element2 != nums[i]){
                element1 = nums[i];
                count1=1;
            } else if (count2 == 0 && element1 != nums[i]){
                element2 = nums[i];
                count2 = 1;
            } else if(element1 == nums[i]){
                count1++;
            } else if(element2 == nums[i]){
                count2++;
            } else{
                count1--;
                count2--;
            }
        }
        // check is that really those elements appears more than n/2 times
        count1=0;
        count2=0;
        for(int i=0; i<n; i++){
            if(nums[i] == element1) count1++;
            if(nums[i] == element2) count2++;
        }

        if(count1 > n/3) result.add(element1);
        if(count2 > n/3) result.add(element2);

        return result;
    }
}
