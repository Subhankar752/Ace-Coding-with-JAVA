class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int len = queries.length;
        int mod = (int)1e9 + 7;
        
        int[] ans = new int[len];
        
        String s = Integer.toBinaryString(n);
        //System.out.println(s);
        ArrayList<Integer> list = new ArrayList<>();
        
        int x = s.length() - 1;
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            char c = s.charAt(i);
            
            if(c != '0'){
                list.add((int)Math.pow(2 , x - i));
            }
        }
        
        //System.out.println(list);
        
        int idx = 0;
        for(int[] i : queries){
            long val = 1;
            
            for(int j = i[0] ; j <= i[1] ; j++){
                val = (val % mod * list.get(j) % mod) % mod;
            }
            ans[idx] = (int)val;
            idx++;
        }
        
        return ans;
    }
    
}