class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int[] i : matches){
            int v = i[1];
            if(map.containsKey(v) == true){
                map.put(v , map.get(v) + 1);
            }
            else{
                map.put(v , 1);
            }
        }
        HashSet<Integer> win = new HashSet<>();
        HashSet<Integer> lose = new HashSet<>();
        for(int[] i : matches){
            int u = i[0];
            int v = i[1];
            if(!map.containsKey(u)){
                win.add(u);
            }
            else if(map.get(u) == 1){
                lose.add(u);
            }
            if(!map.containsKey(v)){
                win.add(v);
            }
            else if(map.get(v) == 1){
                lose.add(v);
            }
            
        }
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int i : win)
            a.add(i);
        for(int i : lose)
            b.add(i);
        Collections.sort(a);
        Collections.sort(b);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(a);
        ans.add(b);
        return ans;
    }
}