Problem Statement: Given an array of N integers, left rotate the array by one place.

Example 1:
Input: N = 5, array[] = {1,2,3,4,5}
Output: 2,3,4,5,1
Explanation: 
Since all the elements in array will be shifted 
toward left by one so ‘2’ will now become the 
first index and and ‘1’ which was present at 
first index will be shifted at last.


Example 2:
Input: N = 1, array[] = {3}
Output: 3
Explanation: Here only element is present and so 
the element at first index will be shifted to 
last index which is also by the way the first index.


Solution:
1- Brute force:

class Main {
    private static int[] leftRotateByOne(int[] nums){
        int n = nums.length, firstEle = nums[0];
        int[] temp = new int[n];
        
        for(int i=0; i<=n-2; i++){
            temp[i] = nums[i+1];
        }
        temp[n-1] = firstEle;
        return temp;
    }
  
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {1,2,3,4,5};
        int[] resultArr = leftRotateByOne(arr);
        for(int i=0; i<resultArr.length; i++){
            System.out.print(resultArr[i]+ " ");
        }
    }
}
