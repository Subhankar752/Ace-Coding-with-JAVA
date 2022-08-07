class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long ans = 1L;
        int n = tasks.length;
        
        HashMap<Integer , Long> map = new HashMap<>();
        
        for(int i = 0 ; i < tasks.length ; i++){
            if(map.containsKey(tasks[i])){
                long dif = ans - map.get(tasks[i]) - 1;
                if(dif >= space){
                    map.put(tasks[i] , ans);
                }
                else{
                    ans = map.get(tasks[i]) + space + 1;
                    map.put(tasks[i] , map.get(tasks[i]) + space + 1);
                }
            }
            else{
                map.put(tasks[i] , ans);
            }
            ans++;
        }
        long max = Integer.MIN_VALUE;
        for(Map.Entry<Integer , Long> m : map.entrySet()){
            max = Math.max(max , m.getValue());
        }
        return max;
    }
}