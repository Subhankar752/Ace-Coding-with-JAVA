class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        long sum = 0;
        Map<Integer , Integer> map = new HashMap<>();
        
        for(int ele : basket1)
            map.put(ele , map.getOrDefault(ele , 0) + 1);
        
        for(int ele : basket2)
            map.put(ele , map.getOrDefault(ele , 0) - 1);
        
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        for(int key : map.keySet()){
            min = Math.min(min , key);
            int x = Math.abs(map.get(key));
            if(x == 0)
                continue;
            if(x % 2 != 0) 
                return -1;
            for(int i = 0 ; i < x / 2 ; i++)
                list.add(key);
        }
            
        Collections.sort(list);
        
        if(list.size() % 2 != 0)  
            return -1;
        
        for(int i = list.size() / 2 - 1 ; i >= 0 ; i--){
                if(list.get(i) > 2 * min)
                    sum += 2 * min;
                else 
                    sum += list.get(i);
        }
        
        return sum;
    }
}