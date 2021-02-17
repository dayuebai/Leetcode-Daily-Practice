class Solution {
    private List<String> ans = new ArrayList<String>();
    
    public List<String> generateParenthesis(int n) {

        char[] cur = new char[n * 2];
        
        dfs(cur, 0, 0);
        
        return ans;
    }

    private void dfs(char[] cur, int idx, int balance) {
        if (idx == cur.length) {
            if (balance == 0) {
                ans.add(new String(cur));
            }
            return;
        }
        
        if (balance < 0) {
            return;
        }
        
        cur[idx] = '(';
        dfs(cur, idx + 1, balance + 1);
        
        cur[idx] = ')';
        dfs(cur, idx + 1, balance - 1);
    }
}
