class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i] , list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i] , list);
            }
        }
        
        for(Map.Entry<Integer , ArrayList<Integer>> m : map.entrySet()){
            ArrayList<Integer> list = m.getValue();
            Collections.sort(list);
            for(int i = 0 ; i < list.size() - 1 ; i++)
            { int a = list.get(i);
                int b = list.get(i + 1);
                if(Math.abs(a - b) <= k)
                    return true;
            }
        }
        
        return false;
    }
}