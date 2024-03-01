class Solution {

    public String maximumOddBinaryNumber(String s) {
        int one = -1;
        int zero = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                one++;
            } else {
                zero++;
            }
        }

        String ans = "";

        for (int i = 0; i < one; i++) {
            ans = ans + "1";
        }

        for (int i = 0; i < zero; i++) {
            ans = ans + "0";
        }

        return ans + "1";
    }
}
