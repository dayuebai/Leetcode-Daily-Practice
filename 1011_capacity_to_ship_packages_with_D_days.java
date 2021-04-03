class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            int d = 1;
            int tmp = mid;
            for (int i = 0; i < weights.length; i++) {
                if (tmp >= weights[i]) {
                    tmp = tmp - weights[i];
                } else {
                    ++d;
                    tmp = mid - weights[i];
                }
            }
            
            if (d <= D)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
