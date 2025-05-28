Problem statement

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals
  that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Solution :

1. Brute Force :

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;
        
        // sort the whole intervals | 2D array
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });

        List<int[]> merged = new ArrayList<>();

        // Brute force
        for(int i=0; i<n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!merged.isEmpty() && end <= merged.get(merged.size()-1)[1]){
                continue;
            }

            for(int j=i+1; j<n; j++){
                if(intervals[j][0] <= end){
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            } 
            merged.add(new int[]{start, end});          
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

2. Optimal Approach :

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;
        
        // 1. sort the whole intervals | 2D array
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });

        List<int[]> merged = new ArrayList<>();
        // 2. take an intial interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                // Overlapping: update end
                end = Math.max(end, intervals[i][1]);
            } else {
                // No overlap: add previous and reset start/end
                merged.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        // Add the last interval
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);
        
    }
}
