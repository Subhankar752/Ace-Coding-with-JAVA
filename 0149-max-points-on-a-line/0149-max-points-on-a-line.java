class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;
        int ans = 0;
        
        for (int i = 0 ; i < n ; i++){
            Map<Double,Integer> hm = new HashMap<>();
            for (int j = 0 ; j < n ; j++){
              if(i != j){
             double k = (double)(points[j][1] - points[i][1]) / (double)(points[j][0] - points[i][0]);
               if(hm.containsKey(k)){
                        hm.put(k , hm.get(k) + 1);
                    }else{
                        hm.put(k , 2);
                    }
                    ans = Math.max(ans , hm.get(k));
              }
            }
        }
        
        return ans;
    }
}