class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        
        for(int i = 0 ; i < 32 ; i++){
            int x = (a >> i) & 1;
            int y = (b >> i) & 1;
            int z = (c >> i) & 1;
            System.out.println(a + " " + b + " " + c);
            int xor = x | y;
            
            if(xor == z)
                continue;
            
            ans++;
            
            if(x == 1 && y == 1)
                ans++;
        }
        
        return ans;
    }
}