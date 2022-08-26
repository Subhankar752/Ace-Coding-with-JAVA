class Solution {
    public void generate(Set<Integer> set , char[] p , int ind){
        if(ind == p.length - 1){
            String s = new String(p);
            set.add(Integer.parseInt(s));
        }
        
        for(int i = ind ; i < p.length ; i++){
            if(ind == 0 && p[i] == '0') continue;
            swap(p , ind ,i);
            generate(set , p , ind + 1);
            swap(p , ind , i);
        }
    }
    public void swap(char[] p , int a , int b){
        char hold = p[a];
        p[a] = p[b];
        p[b] = hold;
    }
    public boolean check(int i){
        int pow = (int) Math.floor(Math.log(i) / Math.log(2));
        if((int)Math.pow(2 , pow) == i) return true;
        return false;
    }
    public boolean reorderedPowerOf2(int n) {
        char[] p = String.valueOf(n).toCharArray();
        
        Set<Integer> set = new HashSet<Integer>();
        generate(set , p , 0);
        
        for(int i : set){
            if(check(i)) return true;
        }
        
        return false;
    }
}