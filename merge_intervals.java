// My solution, time: O(NlogN)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
    
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0])
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);
    }
}


// Discussion solution
// class Solution {
// 	public int[][] merge(int[][] intervals) {
// 		if (intervals.length <= 1)
// 			return intervals;

// 		// Sort by ascending starting point
// 		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

// 		List<int[]> result = new ArrayList<>();
// 		int[] newInterval = intervals[0];
// 		result.add(newInterval);
// 		for (int[] interval : intervals) {
// 			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
// 				newInterval[1] = Math.max(newInterval[1], interval[1]);
// 			else {                             // Disjoint intervals, add the new interval to the list
// 				newInterval = interval;
// 				result.add(newInterval);
// 			}
// 		}

// 		return result.toArray(new int[result.size()][]);
// 	}
// }
