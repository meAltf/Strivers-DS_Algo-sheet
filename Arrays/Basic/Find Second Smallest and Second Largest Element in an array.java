Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.

Examples

Example 1:
Input: [1,2,4,7,7,5]
Output: Second Smallest : 2
	      Second Largest : 5
Explanation: The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2

Example 2:
Input: [1]
Output: Second Smallest : -1
	      Second Largest : -1
Explanation: Since there is only one element in the array, it is the largest and smallest element present in the array. 
  There is no second largest or second smallest element present.


Solution: 
1- Brute-force :

private static int secondLargestNum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            largest = nums[n-1];
            if(largest != nums[n-2-i]){
             largest = nums[n-2-i];
             break;
            }
        }
        return largest;
    }

2- Better Approach :

private static int secLargBetterApp(int[] nums){
        // first traverse to find largest num
        int largest = nums[0];
        for(int num : nums){
            if(num > largest) largest = num;
        }
        System.out.println("first largest num: "+largest);
        
        // second traverse to find 2nd largest num
        int secLargest = Integer.MIN_VALUE;
        for(int num : nums){
            if(num > secLargest && num != largest) secLargest = num;
        }
        System.out.println("second largest num: "+largest);
        
        return secLargest;
    }


3- Optimal Approach :

private  static int findSecLargNum(int[] nums){
        int largest = nums[0], secondLargest = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
            } else if(nums[i] != largest && nums[i] > secondLargest){
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }
