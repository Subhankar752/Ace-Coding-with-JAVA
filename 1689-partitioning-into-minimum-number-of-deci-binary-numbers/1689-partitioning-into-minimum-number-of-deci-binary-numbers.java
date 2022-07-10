class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for(char c : n.toCharArray()){
            int x = Character.getNumericValue(c);
            ans = Math.max(ans , x);
        }
        return ans;
    }
}