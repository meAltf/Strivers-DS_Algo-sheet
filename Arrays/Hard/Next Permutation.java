Problem statement

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. 
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, 
then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, 
the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
  
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
  
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]



Solution 

1. optimal approach :

class Solution {

    private void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int index = -1, n = nums.length;

        // find the break point
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        // edge case | if index = -1 after traversal then it's the last permutation of that array, so reverse the array
        if(index == -1){
            reverse(nums, 0, n-1);
            return;
        }

        // need to find someone greater than nums[index] but smallest one
        for(int i=n-1; i>index; i--){
            if(nums[i] > nums[index]){
                swap(nums, i, index);
                break;
            }
        }

        // put rest of the elements in sorted order to keep it smaller | reverse after index to last element
        reverse(nums, index+1, n-1);
    }
}
