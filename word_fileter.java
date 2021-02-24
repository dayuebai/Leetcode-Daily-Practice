class WordFilter {
    
    private HashMap<String, ArrayList<Integer>> mapPre = new HashMap<>();
    private HashMap<String, ArrayList<Integer>> mapSuf = new HashMap<>();
    
    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String prefix = words[i].substring(0, j);
                String suffix = words[i].substring(j);
                
                if (!mapPre.containsKey(prefix)) {
                    mapPre.put(prefix, new ArrayList<Integer>());
                }
                mapPre.get(prefix).add(i);
                
                if (!mapSuf.containsKey(suffix)) {
                    mapSuf.put(suffix, new ArrayList<Integer>());
                }
                mapSuf.get(suffix).add(i);
            }
            
        }   
    }
    
    public int f(String prefix, String suffix) {
        if (!mapPre.containsKey(prefix) || !mapSuf.containsKey(suffix)) {
            return -1;
        }
        
        ArrayList<Integer> pre = mapPre.get(prefix), suf = mapSuf.get(suffix);
        
        int m = pre.size() - 1, n = suf.size() - 1;
        while (m >= 0 && n >= 0) {
            if (pre.get(m) < suf.get(n)) {
                --n;
            } else if (pre.get(m) > suf.get(n)) {
                --m;
            } else {
                return pre.get(m);
            }
        }
        
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
