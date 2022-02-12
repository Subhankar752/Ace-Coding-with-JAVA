class Solution {
         public class Pair{
        int a;
        int b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int x=nums[i];
            if(map.get(x) == null){
                map.put(x,1);
            }
            else{
                map.put(x,map.get(x)+1);
            }
        }
        ArrayList<Pair> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int key=m.getKey();
            int val=m.getValue();
            ans.add(new Pair(key,val));
        }
        Collections.sort(ans , (aa,bb) -> bb.b - aa.b);
        int a=0;
        int[] res=new int[k];
        while(k-->0){
            res[a] = ans.get(a).a;
            a++;
        }
        return res;
    }
}