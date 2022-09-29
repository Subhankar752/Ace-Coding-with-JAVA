class Solution {
    class Pair{
        int key;
        ArrayList<Integer> values;
        Pair(int key , ArrayList<Integer> values){
            this.key=key;
            this.values=values;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((aa , bb) -> aa.key - bb.key);
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int val = Math.abs(arr[i] - x);
            if(map.get(val) == null){
                ArrayList<Integer> a=new ArrayList<>();
                a.add(arr[i]);
                map.put(val , a);
            }
            else{
                ArrayList<Integer> a=map.get(val);
                a.add(arr[i]);
                map.put(val , a);
            }
        }
        for(Map.Entry<Integer,ArrayList<Integer>> m:map.entrySet()){
            int key=m.getKey();
            ArrayList<Integer> a=m.getValue();
            pq.add(new Pair(key , a));
        }
        List<Integer> ans=new ArrayList<>();
        while(k-->0){
            Pair p=pq.remove();
            int key=p.key;
            ArrayList<Integer> val = p.values;
            if(val.size() == 1){
                ans.add(val.get(0));
            }
            else if(val.size() > 1){
                Collections.sort(val);
                int del = val.get(0);
                ans.add(del);
                val.remove(new Integer(del));
                pq.add(new Pair(key , val));
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
