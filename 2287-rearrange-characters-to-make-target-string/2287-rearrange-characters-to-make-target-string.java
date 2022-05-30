class Solution {
    public int rearrangeCharacters(String s, String t) {
        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character , Integer> map2 = new HashMap<>();
        for(char c : s.toCharArray()){
            if(map1.containsKey(c)){
                map1.put(c , map1.get(c) + 1);
            }
            else{
                map1.put(c , 1);
            }
        }
        for(char c : t.toCharArray()){
            if(map2.containsKey(c)){
                map2.put(c , map2.get(c) + 1);
            }
            else{
                map2.put(c , 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(char c : t.toCharArray()){
            int val1 = map2.get(c);
            int val2 = 0;
            if(map1.containsKey(c))
                val2 = map1.get(c);
            int rem = val2 / val1;
            ans = Math.min(ans , rem);
        }
        return ans;
    }
}