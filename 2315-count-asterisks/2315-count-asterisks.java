class Solution {
    
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public int countAsterisks(String s) {
        ArrayList<Integer> pairs = new ArrayList<>();
       
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '|')
                pairs.add(i);
        }
        
        ArrayList<Pair> list = new ArrayList<>();
        
        for(int i = 0 ; i < pairs.size() ; i += 2){
            int a = pairs.get(i);
            int b = pairs.get(i + 1);
            list.add(new Pair(a , b));
        }
        
        int ans = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '*'){
                if(solve(i , list) == true)
                    ans++;
            }
        }
        
        return ans;
    }
    
    public boolean solve(int i , ArrayList<Pair> list){
        
        for(Pair p : list){
            int a = p.a;
            int b = p.b;
            if(i > a && i < b)
                return false;
        }
        
        return true;
    }
}