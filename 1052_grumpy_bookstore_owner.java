class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int base = 0, maxAdd = 0, curAdd = 0, left = 0, right = 0, l = customers.length;
        while (right < l) {
            base += customers[right] * (grumpy[right] - 1) * (-1);
            if (right - left < X) {
                curAdd += customers[right] * grumpy[right];
            } else {
                curAdd = curAdd + customers[right] * grumpy[right] - customers[left] * grumpy[left];
                ++left;
            }
            maxAdd = Math.max(maxAdd, curAdd);
            ++right;
        }
        return base + maxAdd;
    }
}
