class Solution {
   Map<List<List<Integer>>, Integer> map = new HashMap<>();
    public int maxScore(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        map = new HashMap<>();
        List<Integer> input = new ArrayList<>();
        for(int n : nums){
            input.add(n);
        }
        
        return max(input, 1);
        
    }
    
    
    public int max(List<Integer> input, int ind){
        
        if(input.size()==0) return 0;
        Collections.sort(input);
        
        if(map.containsKey(getList(ind, input))) return map.get(getList(ind, input));
        
        int maxValue = 1;
        for(int i = 1;i<input.size();i++){
            for(int j = 0;j<i;j++){
                int one = input.remove(j);
                int two = input.remove(i-1);
                maxValue = Math.max(maxValue, gcd(one, two) * ind + max(input, ind+1));
                input.add(i-1, two);
                input.add(j, one);
            }
        }
        
        map.put(getList(ind, input), maxValue);
        return maxValue;
        
    }
    
    int gcd(int a, int b){
        if(b == 0) return 1;
        if(a%b == 0) return b;
        return gcd(b, a%b);
    }
                                           
    List<List<Integer>> getList(int ind, List<Integer> in){
        return new ArrayList()
        {
            {
                add(new ArrayList(){{add(ind);
            }
        }); 
        add(in);
        }
    };
    }
}