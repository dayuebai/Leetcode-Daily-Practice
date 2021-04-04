class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Set<Integer>> logMap = new HashMap<>();
        for (int[] l : logs) {
            if (!logMap.containsKey(l[0])) {
                logMap.put(l[0], new HashSet<Integer>());
            }
            logMap.get(l[0]).add(l[1]);
        }
        
        for (Integer id : logMap.keySet()) {
            ++ans[logMap.get(id).size()-1];
        }
        return ans;
    }
}
