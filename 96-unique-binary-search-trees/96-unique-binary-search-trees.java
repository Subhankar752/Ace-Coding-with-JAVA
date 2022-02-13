class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int numTrees(int n) {
        int res = 0;
        if(n <= 1)
            return 1;
        if(map.containsKey(n) == true)
            return map.get(n);
        for(int  i = 0 ; i < n ; i++)
            res += numTrees(i) * numTrees(n - i - 1);
        map.put(n , res);
        return res;
    }
}