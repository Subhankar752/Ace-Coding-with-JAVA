class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char arr[] = s.toCharArray();
        int n = s.length();
        int diff[] = new int[n + 1];
        
        for(int shift[] : shifts){
            int a = shift[0];
            int b = shift[1];
            int d = shift[2] == 1 ? 1 : -1;
        
            diff[a] += d;
            diff[b + 1] -= d;
        }
        
        diff[0] %= 26;
        
        for(int i = 1 ; i < n + 1 ; i++){
            diff[i] += diff[i - 1];
            diff[i] %= 26;
        }
        
        for(int i = 0 ; i < n ; i++){
            int ind = arr[i] + diff[i];
            if(ind < 97)
                ind += 26;
            if(ind > 122)
                ind -= 26;
            arr[i] = (char)ind;
        }
        return new String(arr);
    }
}