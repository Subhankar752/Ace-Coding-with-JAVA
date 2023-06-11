class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int n = firstList.length;
        int m = secondList.length;
        
        for(int i = 0 ; i < n ; i++){
            
            int a = firstList[i][0];
            int b = firstList[i][1];
            
            for(int j = 0 ; j < m ; j++){
                int start = secondList[j][0];
                int end = secondList[j][1];
                
                if(a <= end && b >= start){
                    int x = Math.max(a , start);
                    int y = Math.min(b , end);
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(x);
                    l.add(y);
                    list.add(l);
                }
            }
        }
        
        int size = list.size();
        
        int[][] ans = new int[size][2];
        
        for(int i = 0 ; i < size ; i++){
            int x = list.get(i).get(0);
            int y = list.get(i).get(1);
            
            ans[i][0] = x;
            ans[i][1] = y;
        }
        
        return ans;
    }
}