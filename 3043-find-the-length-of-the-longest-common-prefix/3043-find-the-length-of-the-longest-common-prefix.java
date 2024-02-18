class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> hs = new HashSet<>();

        for (int i : arr1) {
            String str = Integer.toString(i);
            StringBuilder pre = new StringBuilder();

            for (Character ch : str.toCharArray()) {
                pre.append(ch);
                hs.add(Integer.parseInt(pre.toString()));
            }
        }

        int ans = 0;

        for (int i : arr2) {
            String str = Integer.toString(i);
            StringBuilder pre = new StringBuilder();

            for (Character ch : str.toCharArray()) {
                pre.append(ch);
                if (hs.contains(Integer.parseInt(pre.toString()))) {
                    ans = Math.max(ans, pre.length());
                }
            }
        }

        return ans;
    }
}
