class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder result = new StringBuilder();
        int[] ltr = new int[dominoes.length()]; 
        int[] rtl = new int[dominoes.length()];
        

        for (int i = 1; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == '.' 
                && (dominoes.charAt(i - 1) == 'R' || ltr[i - 1] > 0)) {
                
                ltr[i] = ltr[i - 1] + 1;
            }
            
        }
        
        
        for (int i = dominoes.length() - 2; i >= 0; i--) {
            if (dominoes.charAt(i) == '.' 
                && (dominoes.charAt(i + 1) == 'L' || rtl[i + 1] > 0)) {
                
                rtl[i] = rtl[i + 1] + 1;
            }
        }
        
        
        for(int i = 0; i < dominoes.length(); i++) {
            if (ltr[i] == rtl[i]) {
                result.append(String.valueOf(dominoes.charAt(i)));
            } else if (ltr[i] == 0 || rtl[i] == 0) {
                if (ltr[i] == 0) {
                    result.append("L");
                } else {
                    result.append("R");
                }
            } else {
                if (ltr[i] < rtl[i]) {
                    result.append("R");
                } else {
                    result.append("L");
                }
            }
        }
        
        return result.toString();
    }
}