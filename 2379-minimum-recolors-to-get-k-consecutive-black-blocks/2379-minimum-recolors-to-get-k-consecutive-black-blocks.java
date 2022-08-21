class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = 0;
        int n = blocks.length();
        
        for(int i = 0 ; i < k ; i++){
            char ch = blocks.charAt(i);
            if(ch == 'W')
                ans++;
        }
        //System.out.println(ans);
        
        int res = ans;
        
        for(int i = k ; i < n ; i++){
            char ch1 = blocks.charAt(i);
            char ch2 = blocks.charAt(i - k);
            
            if(ch1 == 'W'){
                ans++;
            }
            
            if(ch2 == 'W')
                ans--;
            
            //System.out.println(ans);
            res = Math.min(res , ans);
        }
        
        return res;
    }
}