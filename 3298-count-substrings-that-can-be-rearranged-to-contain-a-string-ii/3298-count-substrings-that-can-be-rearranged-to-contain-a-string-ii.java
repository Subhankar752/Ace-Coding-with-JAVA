class Solution {

    public long validSubstringCount(String word1, String word2) {
        long res = 0;
        int[][] mpp = new int[26][2]; 
        int l = 0, r = 0;
        int n = word1.length();
        int m = word2.length();
        int size = 0;

        for (char ch : word2.toCharArray()) {
            mpp[ch - 'a'][1]++;
        }

        while (r < n) {
            while (size == m && l <= r) {
                res += (n - r + 1);
                mpp[word1.charAt(l) - 'a'][0]--;
                if (mpp[word1.charAt(l) - 'a'][1] > 0 && mpp[word1.charAt(l) - 'a'][0] < mpp[word1.charAt(l) - 'a'][1]) {
                    size--;
                }
                l++;
            }
            
            if (mpp[word1.charAt(r) - 'a'][1] > 0 && mpp[word1.charAt(r) - 'a'][0] < mpp[word1.charAt(r) - 'a'][1]) {
                size++;
            }
            mpp[word1.charAt(r) - 'a'][0]++;
            r++;
        }

        while (size == m && l <= r) {
            res += (n - r + 1);
            mpp[word1.charAt(l) - 'a'][0]--;
            if (mpp[word1.charAt(l) - 'a'][1] > 0 && mpp[word1.charAt(l) - 'a'][0] < mpp[word1.charAt(l) - 'a'][1]) {
                size--;
            }
            l++;
        }

        return res;
    }
}
