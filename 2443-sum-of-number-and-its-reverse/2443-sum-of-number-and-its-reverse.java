class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        int len = 0;
        
        if(num == 0)
            return true;
        
        for(int i = num/2 ; i <= num ; i++){
            int v1 = i;
            int v2 = rev(i);
            if(v1 + v2 == num)
                return true;
        }
        
        return false;
        
    }
    public int rev(int n){
        String s = Integer.toString(n);
        char[] ch = s.toCharArray();
        
        int i = 0;
        int j = s.length() - 1;
        
        String ans = "";
        
        while(i <= j){
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
            i++;
            j--;
        }
        
        return Integer.parseInt(new String(ch));
    }
}