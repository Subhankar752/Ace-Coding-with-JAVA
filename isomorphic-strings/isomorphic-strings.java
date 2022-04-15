class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character , Character> map = new HashMap<>();
        int n = s.length();
        
        for(int i = 0 ; i < n ; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(!map.containsKey(ch1)){
                map.put(ch1 , ch2);
            }
            else{
                char x = map.get(ch1);
                if( x != ch2)
                    return false;
                
            }
        }
        
        String s1="";
        
        for(Map.Entry<Character , Character> m : map.entrySet()){
            s1 += m.getValue();
        }
        
        int n1 = s1.length();
        HashSet<Character> h = new HashSet<>();
        for(int i = 0 ; i < n1 ; i++)
            h.add(s1.charAt(i));
        return n1 == h.size();
    }
}