class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int i = 1, l = points.length, minArrow = 1, curEnd = points[0][1];
        
        while (i < l) {
            if (points[i][0] > curEnd) {
                ++minArrow;
                curEnd = points[i][1];
            }
            ++i;
        }
        
        return minArrow;
    }
}
