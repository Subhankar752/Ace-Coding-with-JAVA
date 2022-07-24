class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String , Integer> map = new HashMap<>();
        for(int[] i : grid){
            String temp = "";
            for(int j : i){
                temp += j + "-";
            }
            if(map.containsKey(temp)){
                map.put(temp , map.get(temp) + 1);
            }
            else{
                map.put(temp , 1);
            }
        }
        int ans = 0;
        int n = grid.length;
        for(int i = 0 ; i < n ; i++){
            String temp = "";
            for(int j = 0 ; j < n ; j++){
                temp += grid[j][i] + "-";
            }
            if(map.containsKey(temp)){
                ans += map.get(temp);
            }
        }
        return ans;
    }
}