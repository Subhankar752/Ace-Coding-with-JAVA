class Solution {
    public int minimizeXor(int num1, int num2) {
        int bin1[] = new int[32];
        
        String s1 = Integer.toBinaryString(num1);
        String s2 = Integer.toBinaryString(num2);
        
        StringBuilder g = new StringBuilder();
        g.append(s1).reverse();
        
        
        for(int i = 0 ; i < s1.length() ; i++)
        {
            bin1[i] = (g.charAt(i) == '0' ? 0 : 1);
        }
        
         int one = 0;
         for(int i = 0 ; i < s2.length() ; i++)
         {
             if(s2.charAt(i) == '1')
                 one++;
         }
        
        int newn = 0;
        int n[] = new int[32];
        for(int i = 31 ; i >= 0 ; i--)
        {
            if(bin1[i] == 1 && one > 0)
            {
                n[i] = 1;
                one--;
            }
            
            if(one == 0)
                break;
        }
        
        if(one > 0)
        {
            for(int i = 0 ; i < 32 ; i++)
            {
                if(bin1[i] == 0 && one > 0)
                {
                    n[i] = 1;
                    one--;
                }
                
                if(one == 0)
                break;
            }
        }
        
        for(int i = 0 ; i < 32 ; i++)
        {
            if(n[i] == 1)
            newn += Math.pow(2 , i);
        }
         
        return newn;
    }
}