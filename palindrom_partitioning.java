class Solution {
    private List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> partition(String s) {      
        List<String> cur = new ArrayList<>();
        dfs(s, 0, cur);
        
        return ans;
    }
    
    private void dfs(String s, int idx, List<String> cur) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        
        int l = s.length();
        for (int i = idx + 1; i <= l; i++) {
            
            String pre = s.substring(idx, i);      
            if (isPalindrome(pre)) {
                cur.add(pre);
                dfs(s, i, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start; --end;
        }
        
        return true;
    }
}
