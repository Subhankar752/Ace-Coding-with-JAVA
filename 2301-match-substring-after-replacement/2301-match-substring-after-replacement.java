class Solution {
    HashMap<Character , HashSet<Character>> map;
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        map = new HashMap<>();
        for(char[] c : mappings){
            if(map.containsKey(c[0])){
                HashSet<Character> hs = map.get(c[0]);
                hs.add(c[1]);
                map.put(c[0] , hs);
            }
            else{
                HashSet<Character> hs = new HashSet<>();
                hs.add(c[1]);
                map.put(c[0] , hs);
            }
        }
        int n = s.length();
        int m = sub.length();
        for(int i = 0 ; i <= n - m ; i++){
            if(check(s , sub , i) == true)
                return true;
        }
        return false;
    }
    public boolean check(String s1 , String s2 , int idx){
        for(int i = 0 ; i < s2.length() ; i++){
            char c1 = s1.charAt(idx);
            char c2 = s2.charAt(i);
            if(c1 == c2 || (map.containsKey(c2) && map.get(c2).contains(c1)))
                idx++;
            else
                return false;
        }
        return true;
    }
}