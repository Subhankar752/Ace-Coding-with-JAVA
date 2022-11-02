class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        int sum = 0;
        long p = n;
        while(p > 0){
            int r = (int)(p % 10);
            sum += r;
            p = p / 10;
        }
        
        if(sum <= target)
            return 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(sum > target){
            int rem = (int)(n % 10);
            
            if(rem == 0){
                n = n / 10;
                list.add(0);
                continue;
            }
            
            int x = 10 - rem;
            //System.out.println(sum);
            list.add(x);
            
            n += x;
            n = n / 10;
            sum = findSum(n);
        }
        
        Collections.reverse(list);
        long ans = 0;
        
        for(int i : list){
            ans = ans * 10 + i;    
        }
        
        return ans;
    }
    public int findSum(long n){
        int s = 0;
        while(n > 0){
            int r = (int)(n % 10);
            s += r;
            n = n / 10;
        }
        
        return s;
    }
}