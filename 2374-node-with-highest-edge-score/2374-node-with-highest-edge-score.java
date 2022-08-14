class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer , Long> map = new HashMap<>();
        for(int i = 0 ; i < edges.length ; i++){
            long u = i;
            int v = edges[i];
            if(map.containsKey(v)){
                long x = map.get(v);
                x += u;
                map.put(v , x);
            }
            else{
                map.put(v , u);
            }
        }
        
        // for(Map.Entry<Integer , Integer> m : map.entrySet()){
        //     int key = m.getKey();
        //     int val = m.getValue();
        //     System.out.println(key + " " + val);
        // }
        
        long ans = Integer.MIN_VALUE;
        int res = 0;
        for(int i = 0 ; i < edges.length ; i++){
            if(map.containsKey(i)){
                if(ans < map.get(i)){
                    ans = map.get(i);
                    res = i;
                }
            }
        }
        return res;
    }
}