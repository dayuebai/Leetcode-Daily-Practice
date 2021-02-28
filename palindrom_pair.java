class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> pairList = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
            set.add(words[i].length());
        }
        
        for (int i = 0; i < words.length; i++) {
            String w = words[i], rev = new StringBuilder(w).reverse().toString();
            int l = w.length();
            
            if (map.containsKey(rev) && map.get(rev) != i) {
                pairList.add(new ArrayList<>(List.of(i, map.get(rev))));
            }
            
            for (Integer n : set) {
                if (n < l) {
                    if (isValid(rev, 0, l - n - 1) && map.containsKey(rev.substring(l - n))) {
                        pairList.add(new ArrayList<>(List.of(i, map.get(rev.substring(l - n)))));
                    }
                    
                    if (isValid(rev, n, l-1) && map.containsKey(rev.substring(0, n))) {
                        pairList.add(new ArrayList<>(List.of(map.get(rev.substring(0, n)), i)));
                    }
                }
            }
        }
        
        return pairList;
    }
    
    private boolean isValid(String w, int l, int r) {
        while (l < r) {
            if (w.charAt(l++) != w.charAt(r--)) {
                return false;
            }
        }
        
        return true;
    }
}
