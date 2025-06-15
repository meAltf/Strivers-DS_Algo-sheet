Problem statement :

Given a sorted array of nums and an integer x, write a program to find the lower bound of x. The lower bound algorithm finds the first 
or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.

If no such index is found, return the size of the array.


Examples:
Input : nums= [1,2,2,3], x = 2

Output:1

Explanation: Index 1 is the smallest index such that arr[1] >= x.

Input : nums= [3,5,8,15,19], x = 9

Output: 3

Explanation: Index 3 is the smallest index such that arr[3] >= x.


Solution :
1. Linear search :

private static int lowerBound(int[] nums, int x) {
       int len = nums.length;
       int start = 0, end = len-1;

       for(int i=0; i<len; i++){
           if(nums[i] >= x) return i;
       }
       return -1;
    }

2. Binary seach :

private static int lowerBoundBinary(int[] nums, int x) {
       int length = nums.length;
       int start = 0, end = length-1;
       int ans = length;
       
       while(start <= end){
        int mid = start + (end-start)/2;
        if (nums[mid] >= x) {
            ans = mid;
            end = mid-1;
        } else start = mid+1;
       }
       return ans;
}
