class Solution {
    
    class Pair{
        String a;
        int b;
        Pair(String a , int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        HashMap<Integer , ArrayList<Pair>> map = new HashMap<>();
        for(int ind = 0 ; ind < nums.length ; ind++){
           
            String ii = nums[ind];
            int n = ii.length();
            
            for(int i = 0 ; i < n ; i++){
               
                String st = ii.substring(i);
                int len = st.length();
                
                if(map.containsKey(len)){
                    ArrayList<Pair> list = map.get(len);
                    Pair p = new Pair(st , ind);
                    list.add(p);
                    map.put(len , list);
                }
                else{
                    ArrayList<Pair> list = new ArrayList<>();
                    Pair p = new Pair(st , ind);
                    list.add(p);
                    map.put(len , list);
                }
            }
        }
        
        int n = queries.length;
        int[] ans = new int[n];
        int idx = 0;
        
        for(int[] i : queries){
            int k = i[0];
            int trim = i[1];
            ArrayList<Pair> list = map.get(trim);
            Collections.sort(list , (aa , bb) -> aa.a.compareTo(bb.a));
            int res = list.get(k - 1).b;
            ans[idx++] = res;
        }
        
        return ans;
    }
}