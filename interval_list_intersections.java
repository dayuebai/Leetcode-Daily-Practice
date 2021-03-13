class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }
        
        ArrayList<int[]> intersection = new ArrayList<>();
        int i = 0, j = 0, l1 = firstList.length, l2 = secondList.length;
        while (i < l1 && j < l2) {
            int startMax = Math.max(firstList[i][0], secondList[j][0]);
            int endMin = Math.min(firstList[i][1], secondList[j][1]);
            
            if (startMax <= endMin) {
                intersection.add(new int[]{startMax, endMin});
            }
            
            if (firstList[i][1] == endMin) {
                ++i;
            }
            if (secondList[j][1] == endMin) {
                ++j;
            }
        }
        
        
        return intersection.toArray(new int[intersection.size()][]);
    }
}
