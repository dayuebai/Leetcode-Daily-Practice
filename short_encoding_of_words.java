class Solution {
    
    class TrieNode {
        
        public boolean isWord = true;
        public TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root = new TrieNode();
    
    public int minimumLengthEncoding(String[] words) {
        
        Arrays.sort(words, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        
        int minL = 0;
        
        for (String w : words) {    
            if (!isPrefix(w)) {
                insertWord(w);
                minL += w.length() + 1;
            }
        }
        
        return minL;
    }
    
    private void insertWord(String s) {
        TrieNode p = root;
        int l = s.length();
        
        for (int i = l-1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            
            if (p.children[idx] == null) {
                p.children[idx] = new TrieNode();
            }
            p = p.children[idx];
        }
        p.isWord = true;
    }
    
    private boolean isPrefix(String s) {
        TrieNode p = root;
        int l = s.length();
        
        for (int i = l-1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            
            if (p.children[idx] == null) {
                return false;
            }
            p = p.children[idx];
        }
        return true;
    }

}


