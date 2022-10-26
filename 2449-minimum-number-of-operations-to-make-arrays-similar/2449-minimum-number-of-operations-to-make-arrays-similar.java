class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        int j = 0;
        List<Integer> evenNum = new ArrayList<>();
        List<Integer> event = new ArrayList<>();
        List<Integer> oddNum = new ArrayList<>();
        List<Integer> oddt = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 == 0){
                evenNum.add(nums[i]);
            }
            else{
                oddNum.add(nums[i]);
            }
            
            if(target[i] % 2 == 0){
                event.add(target[i]);
            }
            else{
                oddt.add(target[i]);
            }
        }
        
        Collections.sort(evenNum);
        Collections.sort(oddNum);
        Collections.sort(event);
        Collections.sort(oddt);
        
        long r1 = helper(evenNum , event);
        long r2 = helper(oddNum , oddt);
        
        return (r1 + r2) / 2;
    }
    
    long helper(List<Integer> l ,List<Integer> t){
        long add = 0;
        
        for(int i = 0 ; i < l.size() ; i++){
            add += (Math.abs(l.get(i) - t.get(i)) / 2);
        }
        
        return add;
    }
}