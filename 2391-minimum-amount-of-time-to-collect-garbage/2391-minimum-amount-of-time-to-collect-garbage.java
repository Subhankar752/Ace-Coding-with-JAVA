class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        
        int m = -1;
        int p = -1;
        int g = -1;
        
        int n = garbage.length;
        
        for(int i = 0 ; i < n ; i++){
            String st = garbage[i];
            
            for(char c : st.toCharArray()){
                if(c == 'M'){
                    m = i;
                }
                else if(c == 'P'){
                    p = i;
                }
                else if(c == 'G'){
                    g = i;
                }
            }
        }
        
        ans += solve(travel , garbage , m , 'M');
        ans += solve(travel , garbage , p , 'P');
        ans += solve(travel , garbage , g , 'G');
        
        return ans;
    }
    
    public int solve(int[] travel , String[] garbage , int idx , char c){
        int ans = 0;
        
        for(int i = 0 ; i <= idx ; i++){
            if(i > 0){
                ans += travel[i - 1];
            }
            
            String temp = garbage[i];
            for(char ch : temp.toCharArray()){
                if(ch == c)
                    ans++;
            }
        }
        
        return ans;
    }
}