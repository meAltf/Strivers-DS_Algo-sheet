Problem statement :

Given a sorted array of nums and an integer x, write a program to find the upper bound of x. The upper bound algorithm finds the 
first or the smallest index in a sorted array where the value at that index is greater than a given key i.e. x.

If no such index is found, return the size of the array.


Examples:
Input : n= 4, nums = [1,2,2,3], x = 2

Output:3

Explanation: Index 3 is the smallest index such that arr[3] > x.

Input : n = 5, nums = [3,5,8,15,19], x = 9

Output: 3

Explanation: Index 3 is the smallest index such that arr[3] > x.

Solution :

1. Brute force :

public int upperBound(int[] nums, int x) {
        int length = nums.length;

        for(int i=0; i<length; i++){
            if(nums[i] > x) return i;
        }
        return length;
}

2. Optimal approach :

private int upperBound(int[] nums, int x) {
        int length = nums.length;
        int start = 0, end = length-1;
        int ans = length;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] > x){
                ans = mid;
                end = mid-1;
            } else start = mid+1;
        }
        return ans;
    }


