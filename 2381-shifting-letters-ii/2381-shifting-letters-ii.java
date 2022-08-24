class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] a = new int[(int)1e5];
        
        for(int[] i : shifts){
           
            int start = i[0];
            int end = i[1];
            int val = i[2];
           
            if(val == 1){
                a[start] += 1;
                a[end + 1] -= 1;
            }
            else{
                a[start] -= 1;
                a[end + 1] += 1;
            }
            
        }
        a[0] = a[0] % 26;
        for(int i = 1 ; i < 1e5 ; i++){
            a[i] += a[i - 1];
            a[i] = a[i] % 26;
        }
        
        String ans = "";
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
           
            int val = a[i];
            int x = (int)ch;
            x += val;
            // System.out.println(x);
           if(x < 97)
                x += 26;
            
            if(x > 122)
                x -= 26;
            
            char res = (char)x;
            ans += res;
            
        }
        
        return ans;
    }
}