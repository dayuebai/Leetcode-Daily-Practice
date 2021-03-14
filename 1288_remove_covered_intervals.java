// Time: O(nlogn) space: O(1)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        int remain = 1, c = 0, l = intervals.length;
        for (int i = 1; i < l; i++) {
            if (intervals[i][0] < intervals[c][0]) {
                ++remain;
                c = i;
            }
        }
        return remain;
    }
}
