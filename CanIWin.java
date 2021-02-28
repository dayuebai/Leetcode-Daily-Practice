class Solution {
    private HashMap<String, Boolean> memo = new HashMap<>();
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        
        return canIWinFrom(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
    }
    
    private boolean canIWinFrom(int maxChoosableInteger, int desiredTotal, boolean[] chosen) {
        
        if (desiredTotal <= 0) {
            return false;
        }
        
        String chosenSerialization = Arrays.toString(chosen);
        if (memo.containsKey(chosenSerialization)) {
            return memo.get(chosenSerialization);
        }
        
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (chosen[i]) {
                continue;
            }
            
            chosen[i] = true;
            if (!canIWinFrom(maxChoosableInteger, desiredTotal - i, chosen)) {
                chosen[i] = false;
                memo.put(chosenSerialization, true);
                return true;
            }
            chosen[i] = false;
        }
        
        memo.put(chosenSerialization, false);
        return false;
        
    }
}
