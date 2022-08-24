class Solution {
    char[] ch;
    public int secondsToRemoveOccurrences(String s) {
//         int ans = 0;
//         int n = s.length();
        
//         int sum = 0;
//         for(int i = n - 1 ; i >= 0 ; i--){
//             char ch = s.charAt(i);
//             if(ch == '1'){
//                 sum++;
//             }
//             else{
//                 ans = Math.max(ans , sum);
//             }
//         }
        
//         return ans;
        int ans = 0;
        ch = s.toCharArray();
        
        while(true){
            int x = solve(ch);
            
            if(x == 0)
                break;
            else
                ans++;
        }
        
        return ans;
    }
    public int solve(char[] ch){
        int res = 0;
        int i = 0;
        while(i < ch.length - 1){
            char c1 = ch[i];
            char c2 = ch[i + 1];
            
            if(c1 == '0' && c2 == '1'){
                ch[i] = '1';
                ch[i + 1] = '0';
                res++;
                i += 2;
            }
            else{
                i++;
            }
        }
       // System.out.println(res);
        return res;
    }
}