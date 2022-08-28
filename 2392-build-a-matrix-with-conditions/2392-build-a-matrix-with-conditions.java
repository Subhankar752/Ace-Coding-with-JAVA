class Solution {
    ArrayList<Integer> row;
    ArrayList<Integer> col;
    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        row = new ArrayList<>();
        col = new ArrayList<>();
        
        kahn(rowConditions , k , '1');
        kahn(colConditions , k , '0');
        
        int[][] ans = new int[k][k];
        
        if(row.size() != k || col.size() != k)
            return new int[0][0];
        
        int[] colIndex = new int[k + 1];
        
        for(int i = 0 ; i < col.size() ; i++)
        {
            colIndex[col.get(i)] = i;
        }
        
        
        for(int i = 0 ; i < k ; i++)
        {
            int colInd = colIndex[row.get(i)];
            ans[i][colInd] = row.get(i);
        }
        
        return ans;
    }
    
    public void kahn(int[][] a , int k, char c){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i <= k ; i++)
            adj.add(new ArrayList<>());
        
        int[] in = new int[k + 1];
        
        for(int[] i : a){
            int u = i[0];
            int v = i[1];
            
            adj.get(u).add(v);
            in[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1 ; i < k + 1 ; i++){
            if(in[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int temp = q.remove();
           
            if(c == '1')
                row.add(temp);
            else
                col.add(temp);
            
            for(int i : adj.get(temp)){
                in[i]--;
                if(in[i] == 0)
                    q.add(i);
            }
        }
    }
}