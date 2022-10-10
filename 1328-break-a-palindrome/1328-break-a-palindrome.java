class Solution {
    public String breakPalindrome(String s) {
        int n = s.length();
        
        if(n == 1)
            return "";
        
        String temp = "";
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            System.out.println(ch);
            
            if(ch != 'a'){
                temp = s.substring(0 , i) + 'a' + s.substring(i + 1);
                break;
            }
        }
        
        if(temp.length() == 0){
            return s.substring(0 , n - 1) + 'b';
        }
        
        if(check(temp)){
            return s.substring(0 , n - 1) + 'b';
        }
        
        else{
            return temp;
        }
        
    }
    
    public boolean check(String s){
        String ans = "";
        for(char c : s.toCharArray()){
            ans = c + ans;
        }
        
        return (s.equals(ans));
    }
}