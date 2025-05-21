Problem statement :

Given an integer array nums, return a list of all the leaders in the array.



A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.


Examples:
Input: nums = [1, 2, 5, 3, 1, 2]

Output: [5, 3, 2]

Explanation: 2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]

  

Input: nums = [-3, 4, 5, 1, -4, -5]

Output: [5, 1, -4, -5]

Explanation: -5 is the rightmost element, -4 is the largest element in the index range [4, 5], 1 is the largest element in the index range [3, 5] and 5 is the largest element in the range [2, 5]



Solution 

1. Brute force -

class Solution {
    public ArrayList<Integer> leaders(int[] nums) {
        int[] temp = new int[nums.length];
        int start = 0;

        for(int i=0; i<nums.length; i++){
            boolean leader = true;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] > nums[i]){
                    leader = false;
                    break;
                }
            }

            if(leader){
                temp[start] = nums[i];
                start++;
            }
        }
        return temp;
    }
}


2. Optimal approach :

private static ArrayList<Integer> leaders(int[] nums) {
        int n= nums.length;
        ArrayList<Integer> ans= new ArrayList<>();
        
        // edge case
        if(nums.length == 0 || nums.length== 1) return ans;
        
        int max = nums[n-1];
        ans.add(nums[n-1]);
        
        for(int i=n-2; i>=0; i--){
            if(nums[i] > max){
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        
        // need to reverse the list
        // Collections.sort(ans, Collections.reverseOrder());
        Collections.reverse(ans);
        return ans;
    }
