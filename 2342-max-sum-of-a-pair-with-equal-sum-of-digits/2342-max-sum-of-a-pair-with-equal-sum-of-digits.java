class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        
        for(int i : nums){
            int x = findSum(i);
            if(map.containsKey(x)){
                ArrayList<Integer> list = map.get(x);
                list.add(i);
                map.put(x , list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(x , list);
            }
        }
        
        int ans = -1;
        
        for(Map.Entry<Integer , ArrayList<Integer>> m : map.entrySet()){
            int key = m.getKey();
            ArrayList<Integer> list = m.getValue();
            if(list.size() < 2)
                continue;
            Collections.sort(list , Collections.reverseOrder());
            int val = list.get(0) + list.get(1);
            ans = Math.max(ans , val);
        }
        
        return ans;
    }
    
    public int findSum(int num){
        int ans = 0;
        while(num > 0){
            int r = num % 10;
            ans += r;
            num = num / 10;
        }
        return ans;
    }
}