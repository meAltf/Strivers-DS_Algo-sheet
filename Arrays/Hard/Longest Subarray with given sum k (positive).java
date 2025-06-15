Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

Examples

Example 1:
Input Format: N = 3, k = 5, array[] = {2,3,5}
Result: 2
Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

Example 2:
Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
Result: 3
Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.


Solution :

1. Brute Force : 

private static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        int largest = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int sum = 0;
                int count = 0;
                for(int K=i; K<=j; K++){
                    sum+=nums[K];
                    count++;
                }

                if(sum==k){
                    largest = Math.max(count, largest);
                }
            }
        }
        return largest;
    }

2. Better approach :

private static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        int largest = 0;
        
        for(int i=0; i<n; i++){
            int sum = 0;
            int count = 0;
            for(int j=i; j<n; j++){
                sum+=nums[j];
                count++;
                
                if(sum == k) largest = Math.max(count, largest);
            }
        }
        return largest;
    }

3. Better using two pointer approach

private static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        int left = 0, right = 0;
        int largest = 0;
        int sum = nums[0];
        
        while(right < n){
            while(sum > k && left <= right){
                sum -= nums[left];
                left++;
            }
            if(sum == k){
                largest = Math.max(right-left+1, largest);
            }
            right++;
            if(right < n) sum+=nums[right];
        }
        return largest;
    }

4. Optimal approach using Hashing

private static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int maxLen = 0;
        
        Map<Integer, Integer> preSumMap = new HashMap<>();
        
        for(int i=0; i<n; i++){
            sum+=nums[i];
            
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }
            
            // calculate sum of remaining part
            int rem = sum-k;
            
            //calculate the length and update the maxLen
            if(preSumMap.containsKey(sum)){
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            
            // finally, update the map checking the conditions
            if (!preSumMap.containsKey(sum)){
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
