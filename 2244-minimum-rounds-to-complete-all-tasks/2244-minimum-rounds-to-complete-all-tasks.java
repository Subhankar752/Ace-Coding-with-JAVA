class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public int minimumRounds(int[] tasks) {
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i : tasks){
            if(map.containsKey(i)){
                map.put(i , map.get(i) + 1);
            }
            else{
                map.put(i , 1);
            }
        }
        
        int ans = 0;
        boolean flag = false;
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            int key = m.getKey();
            int value = m.getValue();
            if(value >= 2){
                ans += (value/3);
                if(value % 3 != 0)
                    ans++;
            } 
            else
            {
                flag = true;
                break;
            }
        }
        if(flag)
            return -1;
        
        return ans;
    }
}