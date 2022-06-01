class Solution {
    
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int[] i : roads){
            int u = i[0];
            int v = i[1];
            if(map.containsKey(u)){
                map.put(u , map.get(u) + 1);   
            }
            else{
                map.put(u , 1);
            }
            if(map.containsKey(v)){
                map.put(v , map.get(v) + 1);   
            }
            else{
                map.put(v , 1);
            }
        }
        ArrayList<Pair> list = new ArrayList<>();
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            int key = m.getKey();
            int value = m.getValue();
            list.add(new Pair(key , value));
        }
        Collections.sort(list , (aa , bb) -> bb.b - aa.b);
        int[] val = new int[n];
        int x = n;
        for(Pair p : list){
            int key = p.a;
            val[key] = x--;
        }
        long ans = 0;
        for(int[] i : roads){
            int u = val[i[0]];
            int v = val[i[1]];
            ans += u + v;
        }
        return ans;
    }
}