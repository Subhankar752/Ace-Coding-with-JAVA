class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character , Integer> m1 = new HashMap<>();
        HashMap<Character , Integer> m2 = new HashMap<>();
        for(char c : s.toCharArray()){
            if(m1.containsKey(c)){
                m1.put(c , m1.get(c) + 1);
            }
            else{
                m1.put(c , 1);
            }
        }
        for(char c : t.toCharArray()){
            if(m2.containsKey(c)){
                m2.put(c , m2.get(c) + 1);
            }
            else{
                m2.put(c , 1);
            }
        }
        int ans = 0;
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            int x = m1.get(ch) != null ? m1.get(ch) : 0;
            int y = m2.get(ch) != null ? m2.get(ch) : 0;
            ans += Math.abs(x - y);
        }
        return ans;
    }
}