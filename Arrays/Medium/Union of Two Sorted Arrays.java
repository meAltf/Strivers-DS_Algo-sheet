Problem Statement:
Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
The union of two arrays can be defined as the common and distinct elements in the two arrays.NOTE: Elements in the union should be in ascending order.

Examples

Example 1:
Input:
n = 5,m = 5.
arr1[] = {1,2,3,4,5}  
arr2[] = {2,3,4,4,5}
Output:
 {1,2,3,4,5}

Explanation: 
Common Elements in arr1 and arr2  are:  2,3,4,5
Distnict Elements in arr1 are : 1
Distnict Elemennts in arr2 are : No distinct elements.
Union of arr1 and arr2 is {1,2,3,4,5} 

Example 2:
Input:
n = 10,m = 7.
arr1[] = {1,2,3,4,5,6,7,8,9,10}
arr2[] = {2,3,4,4,5,11,12}
Output: {1,2,3,4,5,6,7,8,9,10,11,12}
Explanation: 
Common Elements in arr1 and arr2  are:  2,3,4,5
Distnict Elements in arr1 are : 1,6,7,8,9,10
Distnict Elemennts in arr2 are : 11,12
Union of arr1 and arr2 is {1,2,3,4,5,6,7,8,9,10,11,12}


Solution :

1. Brute-force approach :

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    
    public static int[] unionArray(int[] nums1, int[] nums2) {
       int m = nums1.length, n = nums2.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums1){
            map.put(num, 1);
        }

        for(int num : nums2){
            map.put(num, 1);
        }

        int[] result = new int[map.size()];
        int i=0;
        for(int key : map.keySet()){
            result[i++] = key;
        }
        return result;

    }
    
    public static void main(String[] args) {
        int n = 10, m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        int[] temp = unionArray(arr1, arr2);
        
        for(int num:temp){
            System.out.print(num + ",");
        }
    }
}
