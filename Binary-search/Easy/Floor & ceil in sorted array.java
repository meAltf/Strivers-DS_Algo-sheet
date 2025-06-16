Problem statement :

Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor of x is the largest element in 
  the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x. 
  If no floor or ceil exists, output -1.


Examples:
Input : nums =[3, 4, 4, 7, 8, 10], x= 5

Output: 4 7

Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

Input : nums =[3, 4, 4, 7, 8, 10], x= 8

Output: 8 8

Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.

Solution :

1. Optimal Approach :

class Solution {

    private int getFloor(int[] nums, int x){
        int start = 0, end = nums.length-1;
        int ans = Integer.MIN_VALUE;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] <= x){
                ans = Math.max(ans, nums[mid]);
                start = mid+1;
            } 
            else end = mid-1;
        }
        return ans;
    }

    private int getCeil(int[] nums, int x){
        int start = 0, end = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] >= x){
                ans = Math.min(ans, nums[mid]);
                end = mid-1;
            }
            else start = mid+1;
        }
        return ans;
    }

    public int[] getFloorAndCeil(int[] nums, int x) {
       int floor = 0;
       int ceil = nums.length;

       floor = getFloor(nums, x);
       ceil = getCeil(nums, x);

       int[] arr = {floor, ceil};
       return arr;
    }
}
