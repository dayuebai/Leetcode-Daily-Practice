class Solution {
    public String truncateSentence(String s, int k) {
        String[] sArr = s.split("\\s+");
        String ans = "";
        
        for (int i = 0; i < k-1; i++) {
            ans += sArr[i] + " ";
        }
        ans += sArr[k-1];
        return ans;
    }
}
