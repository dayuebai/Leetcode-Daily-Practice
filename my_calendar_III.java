class MyCalendarThree {

    TreeMap<Integer, Integer> eventMap;
    
    public MyCalendarThree() {
        eventMap = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        eventMap.put(start, eventMap.getOrDefault(start, 0) + 1);
        eventMap.put(end, eventMap.getOrDefault(end, 0) - 1);
        
        int maxK = 0, curK = 0;
        
        for (int n: eventMap.values()) {
            curK += n;
            maxK = Math.max(maxK, curK);
        }
        
        return maxK;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

// class MyCalendarThree {

//     TreeMap<int[], Integer> eventMap;
    
//     public MyCalendarThree() {
//         eventMap = new TreeMap<>((a, b) -> {
//             if (a[0] != b[0]) {
//                 return a[0] - b[0];
//             } else {
//                 return a[1] - b[1];
//             }
//         });
//     }
    
//     public int book(int start, int end) {
//         int[] s = new int[]{start, 1}, e = new int[]{end, 0};
//         eventMap.put(s, eventMap.getOrDefault(s, 0) + 1);
//         eventMap.put(e, eventMap.getOrDefault(e, 0) + 1);
        
//         int maxK = 0, curK = 0;
        
//         for (int[] event : eventMap.keySet()) {
//             if (event[1] == 1) {
//                 curK += eventMap.get(event);
//                 maxK = Math.max(maxK, curK);
//             } else {
//                 curK -= eventMap.get(event);
//             }
//         }
        
//         return maxK;
//     }
// }

// /**
//  * Your MyCalendarThree object will be instantiated and called as such:
//  * MyCalendarThree obj = new MyCalendarThree();
//  * int param_1 = obj.book(start,end);
//  */


