class Solution {
    
    class Pair {
        char a;
        int b;
        
        Pair(char a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((aa, bb) -> bb.b - aa.b);
        for(Map.Entry<Character, Integer> m : map.entrySet()) {
            char key = m.getKey();
            int value = m.getValue();
            pq.add(new Pair(key, value));
        }
        
        while(pq.size() > 1) {
            Pair x = pq.remove();
            Pair y = pq.remove();
            char c1 = x.a;
            char c2 = y.a;
            int v1 = x.b - 1;
            int v2 = y.b - 1;
            
            ans.append(c1);
            ans.append(c2);
            
            if (v1 > 0) {
                pq.add(new Pair(c1, v1));
            }
            if (v2 > 0) {
                pq.add(new Pair(c2, v2));
            }
        }
        
        if(pq.size() > 0) {
            Pair p = pq.remove();
            char ch = p.a;
            int val = p.b;
            
            if(val > 1) {
                return "";
            }
            
            ans.append(ch);
        }
        
        return ans.toString();
    }
}