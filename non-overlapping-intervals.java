// O(NlogN) sorting, greedy algorithm
class Solution {
    
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int counter = 1, min = intervals[0][0], max = intervals[0][1];
        
        for (int[] interval : intervals) {
            if (interval[0] >= max) {
                max = interval[1];
                ++counter;
            } 
        }
        
        return intervals.length - counter;
    }
}
