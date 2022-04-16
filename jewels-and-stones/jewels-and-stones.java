class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Set setJ = new HashSet();
        char[] jarr = jewels.toCharArray();
        char[] sarr = stones.toCharArray();
        for (char j : jarr)
            setJ.add(j);
        for (char s : sarr)
            if (setJ.contains(s)) res++;
        return res;
    }
}