class WordDictionary {
    class TrieNode {
       public boolean isWord = false;
       public TrieNode[] children;

       public TrieNode() {
           children = new TrieNode[26];
       }
    }
    
    private TrieNode root = null;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode t = root;
        
        for (int i = 0; i < word.length(); i++) {
            int idx = (int) (word.charAt(i) - 'a');
            
            if (t.children[idx] == null) {
                t.children[idx] = new TrieNode();
            }
            t = t.children[idx];
        }
        t.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    
    private boolean dfs(TrieNode t, String word, int d) {
        if (d == word.length()) {
            return t.isWord;
        }
    
        if (word.charAt(d) != '.') {
            int idx = (int) word.charAt(d) - 'a';
            return t.children[idx] != null && dfs(t.children[idx], word, d+1);
        } else {
            for (int j = 0; j < 26; j++) {
                if (t.children[j] != null && dfs(t.children[j], word, d+1)) {
                    return true;
                }
            }
            return false;
        }
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
