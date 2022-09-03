class Solution {
    public String largestPalindromic(String num) {
        int[] arr = new int[10];
        
        for(char ch : num.toCharArray()) {
            arr[ch - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 9 ; i >= 0 ; i--) {
            if(i == 0) {
                if(sb.length() > 0) {
                    while(arr[i] > 1) {
                        sb.append(i);
                        arr[i] -= 2;
                    }
                }
            } else {
                while(arr[i] > 1) {
                    sb.append(i);
                    arr[i] -= 2;
                }
            }
        }
        
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        String str = "";
        for(int i = 9 ; i >= 0 ; i--) {
            if(arr[i] > 0) {
                str = String.valueOf(i);
                break;
            }
        }
        
        return str1 + str + str2;
    
    }
}