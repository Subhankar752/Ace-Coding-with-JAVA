class Solution {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> idx1 = new ArrayList<>();
        List<Integer> idx2 = new ArrayList<>();

        int alen = a.length();
        int blen = b.length();
        int n = s.length();

        for (int i = 0; i <= n - alen; i++) {
            String str = s.substring(i, i + alen);

            if (str.equals(a)) {
                idx1.add(i);
            }
        }

        for (int i = 0; i <= n - blen; i++) {
            String str = s.substring(i, i + blen);

            if (str.equals(b)) {
                idx2.add(i);
            }
        }

        for (int i : idx1) {
            for (int j : idx2) {
                if (Math.abs(i - j) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }

        return ans;
    }
}
