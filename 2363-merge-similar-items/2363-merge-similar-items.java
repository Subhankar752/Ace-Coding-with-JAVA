class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        
        TreeMap<Integer , Integer> map = new TreeMap<>();
        
        for(int[] i : items1){
            
            int u = i[0];
            int v = i[1];
        
            if(map.containsKey(u)){
                map.put(u , map.get(u) + v);
            }
            else{
                map.put(u , v);
            }
        }
        
        for(int[] i : items2){
            
            int u = i[0];
            int v = i[1];
        
            if(map.containsKey(u)){
                map.put(u , map.get(u) + v);
            }
            else{
                map.put(u , v);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            
            List<Integer> temp = new ArrayList<>();
            int key = m.getKey();
            int value = m.getValue();
            
            temp.add(key);
            temp.add(value);
            ans.add(temp);
        }
        
        return ans;
    }
}