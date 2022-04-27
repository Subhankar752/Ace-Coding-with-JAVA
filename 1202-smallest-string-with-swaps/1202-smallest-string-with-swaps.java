class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    boolean[] vis;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        vis = new boolean[n];
        for(int i = 0 ; i < n ; i++)
            list.add(new ArrayList<>());
        
        for(List<Integer> p : pairs){
            int u = p.get(0);
            int v = p.get(1);
            list.get(u).add(v);
            list.get(v).add(u);
        }
        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(i+"->");
        //     System.out.println(list.get(i));
        // }
        char[] ans = new char[n];
        HashMap<Integer , Character> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
             char ch = s.charAt(i);
            map.put(i , ch);
        }
        ArrayList<Integer> pq = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                pq = new ArrayList<>();
                dfs(i , pq);
            Collections.sort(pq);
            ArrayList<Character> l = new ArrayList<>();
            for(int m : pq){
                l.add(map.get(m));
            }
            Collections.sort(l);
            for(int m = 0 ; m < pq.size() ; m++){
                ans[pq.get(m)] = l.get(m);
                // System.out.println(pq.get(m) + " " + l.get(m));
            }
            }
        }
        return new String(ans);
    }
    public void dfs(int i , ArrayList<Integer> hs){
        vis[i] = true;
        hs.add(i);
        for(int ele : list.get(i)){
            if(!vis[ele])
                dfs(ele , hs);
        }
    }
}