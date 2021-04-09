class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> l = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        for (int n : nums2) {
            if (set.contains(n)) {
                l.add(n);
            }
        }
        
        int[] intersection = new int[l.size()];
        int i = 0;
        for (Integer n : l) {
            intersection[i++] = n;
        }
        return intersection;
    }
}
