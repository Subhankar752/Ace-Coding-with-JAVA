class Solution {

    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        
        int ans = 0;
        String s1 = Integer.toBinaryString(k);
        String s2 = Integer.toBinaryString(xor);

        int n1 = s1.length();
        int n2 = s2.length();

        int i = n1 - 1;
        int j = n2 - 1;

        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (c1 != c2) {
                    ans++;
                }

                i--;
                j--;
            } else if (i >= 0) {
                char c1 = s1.charAt(i);
                if (c1 == '1') {
                    ans++;
                }
                i--;
            } else {
                char c2 = s2.charAt(j);
                if (c2 == '1') {
                    ans++;
                }
                j--;
            }
        }

        return ans;
    }
}
