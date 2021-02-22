class Trie {
    class TrieNode {
       public boolean isWord = false;
       public TrieNode[] children;

       public TrieNode() {
           children = new TrieNode[26];
       }
    }
    private TrieNode root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        
        for (int i = 0; i < word.length(); i++) {
            int idx = (int) (word.charAt(i) - 'a');
            
            if (p.children[idx] == null) {
                p.children[idx] = new TrieNode();
            }
            p = p.children[idx];
        }
        p.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = find(word);
        return p != null && p.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }
    
    public TrieNode find (String word) {
        TrieNode p = root;
        
        for (int i = 0; i < word.length(); i++) {
            int idx = (int) (word.charAt(i) - 'a');
            
            if (p.children[idx] == null) {
                return null;
            }
            p = p.children[idx];
        }
        return p;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
