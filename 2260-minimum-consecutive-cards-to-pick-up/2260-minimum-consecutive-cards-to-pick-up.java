class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < cards.length ; i++){
            int val = cards[i];
            if(map.containsKey(val)){
                int temp = 1 + i - map.get(val);
                ans = Math.min(ans , temp);
            }
            map.put(val , i);
        }
        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
}