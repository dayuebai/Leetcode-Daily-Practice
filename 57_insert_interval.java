class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> newIntervals = new ArrayList<>();
        int l = intervals.length, i = 0, minStart = newInterval[0], maxEnd = newInterval[1];
        
        while (i < l && intervals[i][1] < minStart) {
            newIntervals.add(intervals[i++]);
        }
        while (i < l && intervals[i][0] <= maxEnd) {
            minStart = Math.min(minStart, intervals[i][0]);
            maxEnd = Math.max(maxEnd, intervals[i][1]);
            ++i;
        }
        newIntervals.add(new int[]{minStart, maxEnd});
        
        while (i < l) {
            newIntervals.add(intervals[i++]);
        }
        return newIntervals.toArray(new int[newIntervals.size()][]);
    }
}
