class Solution {
    public boolean isPowerOfThree(int n) {
        // 3^19 = 1162261467, 3^20 is larger than 2^31 - 1
        return ( n>0 &&  1162261467 % n==0);
    }
}
