class Solution {
    public String minimizeResult(String expression) {
        String[] st = expression.split("\\+");
        String s1 = st[0];
        String s2 = st[1];
        int n1 = s1.length();
        int n2 = s2.length();
        String ans = "";
        int min = Integer.MAX_VALUE;
        
        for(int i = n1 - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j < n2 ; j++){
                int x = 1;
                int y = 0;
                int z = 1;
                String a = s1.substring(0 , i);
                if(a.length() > 0){
                    x = Integer.parseInt(a);
                }
                int b = Integer.parseInt(s1.substring(i));
                int d = Integer.parseInt(s2.substring(0 , j + 1));
                String c = s2.substring(j + 1);
                if(c.length() > 0){
                    z = Integer.parseInt(c);
                }
                int sum = x * (b + d) * z;
                if(sum < min){
                    min = sum;
                    ans = s1.substring(0 , i) + "(" + s1.substring(i) + "+" + s2.substring(0 , j + 1) + ")" + s2.substring(j + 1);
                }
            }
        }
        
        return ans;
    }
}