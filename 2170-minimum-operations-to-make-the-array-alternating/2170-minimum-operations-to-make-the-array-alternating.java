class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    public int minimumOperations(int[] nums) {
        HashMap<Integer , Integer> odd = new HashMap<>();
        HashMap<Integer , Integer> even = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(i % 2 == 0){
                if(even.containsKey(nums[i])){
                    even.put(nums[i] , even.get(nums[i]) + 1);
                }
                else{
                    even.put(nums[i] , 1);
                }
            }
            else{
                if(odd.containsKey(nums[i])){
                    odd.put(nums[i] , odd.get(nums[i]) + 1);
                }
                else{
                    odd.put(nums[i] , 1);
                }
            }
        }
        int maxFreqOdd = 0;
        int maxFreqEven = 0;
        int itemEven = -1;
        int itemOdd = -1;
        for(Map.Entry<Integer , Integer> m : even.entrySet()){
            int key = m.getKey();
            int val = m.getValue();
            if(val > maxFreqEven){
                maxFreqEven = val;
                itemEven = key;
            }
        }
        for(Map.Entry<Integer , Integer> m : odd.entrySet()){
            int key = m.getKey();
            int val = m.getValue();
            if(val > maxFreqOdd){
                maxFreqOdd = val;
                itemOdd = key;
            }
        }
        if(itemEven != itemOdd){
            int ans = 0;
            for(int i = 0 ; i < nums.length ; i++){
                if(i % 2 == 0){
                    if(nums[i] != itemEven)
                        ans++;
                }
                else{
                    if(nums[i] != itemOdd)
                        ans++;
                }
            }
            return ans;
        }
        else{
            ArrayList<Pair> evenList = new ArrayList<>();
            ArrayList<Pair> oddList = new ArrayList<>();
            for(Map.Entry<Integer , Integer> m : even.entrySet()){
                int key = m.getKey();
                int val = m.getValue();
                evenList.add(new Pair(key , val));
            }
            for(Map.Entry<Integer , Integer> m : odd.entrySet()){
                int key = m.getKey();
                int val = m.getValue();
                oddList.add(new Pair(key , val));
            }
            Collections.sort(evenList , (aa , bb) -> bb.b - aa.b);
            Collections.sort(oddList , (aa , bb) -> bb.b - aa.b);
            int ans1 = 0;
            int res = 0;
            int or = itemEven;
            if(evenList.size() > 1)
                itemEven = evenList.get(1).a;
            else
                itemEven = itemOdd + 1;
            for(int i = 0 ; i < nums.length ; i++){
                if(i % 2 == 0){
                    if(nums[i] != itemEven)
                        ans1++;
                }
                else{
                    if(nums[i] != itemOdd)
                        ans1++;
                }
            }
            itemEven = or;
            if(oddList.size() > 1)
                itemOdd = oddList.get(1).a;
            else
                itemOdd = itemEven + 1;
            
            int ans2 = 0;
            for(int i = 0 ; i < nums.length ; i++){
                if(i % 2 == 0){
                    if(nums[i] != itemEven)
                        ans2++;
                }
                else{
                    if(nums[i] != itemOdd)
                        ans2++;
                }
            }
            return Math.min(ans1 , ans2);
        }
    }
}