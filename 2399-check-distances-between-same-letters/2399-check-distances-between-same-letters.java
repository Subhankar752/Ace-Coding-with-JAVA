class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character , List<Integer>> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                List<Integer> list = map.get(c);
                list.add(i);
                map.put(c , list);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c , list);
            }
        }
        
        for(Map.Entry<Character , List<Integer>> m : map.entrySet()){
            char c = m.getKey();
            List<Integer> val = m.getValue();
            
            int a = val.get(0);
            int b = val.get(1);
            int dif = b - a - 1;
            
            int idx = c - 97;
            int value = distance[idx];
            if(value != dif)
                return false;
        }
        
        return true;
    }
}