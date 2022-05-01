class Solution {
    public String removeDigit(String number, char digit) {
        String ans = "";
        int res = 0;
        int n = number.length();
        for(int i = 0 ; i < n ; i++){
            char ch = number.charAt(i);
            if(ch == digit){
                String temp = number.substring(0 , i) + number.substring(i + 1);
                System.out.println(temp + " " + ans);
                if(check(temp , ans)){
                    ans = temp;
                }
            }
        }
        return ans;
    }
    public boolean check(String temp , String ans){
        int n1 = temp.length();
        int n2 = ans.length();
        if(n1 > n2)
            return true;
        if(n1 < n2)
            return false;
        for(int i = 0 ; i < n1 ; i++){
            char c1 = temp.charAt(i);
            char c2 = ans.charAt(i);
            if(c1 > c2)
                return true;
            else if(c2 > c1)
                return false;
        }
        return false;
    }
}