class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int l = 1;
        int r = (int)Math.pow(10,6);
        
        while (l < r) {
            int m = l + (r - l) / 2;
            
            if (sum(nums, m) <= threshold) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private int sum(int[] nums, int d) {
        int sum = 0;
        
        for (int n : nums) {
            sum += (n + (d - 1)) / d;
        }
        
        return sum;
    }
}
