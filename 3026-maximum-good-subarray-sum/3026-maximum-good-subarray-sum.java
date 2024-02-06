class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long l[] = new long[nums.length];
        long sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            l[i]=sum;
        }

        Map<Integer,Integer> mp = new HashMap<>();
        long ans =Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){

            int x1 = nums[i]+k, x2 = nums[i]-k;
            if(mp.containsKey(x1) && x1 != nums[i]){
                int ind = mp.get(x1);
                long tmpmax =Long.MIN_VALUE;
                if(ind==0){
                    tmpmax= l[i];
                } else{
                    tmpmax=l[i]-l[ind-1];
                }
                ans = Math.max(tmpmax,ans);
            }

            if(mp.containsKey(x2) && x2!=nums[i]){
                int ind = mp.get(x2);
                long tmpmax =Long.MIN_VALUE;
                if(ind==0){
                    tmpmax= l[i];
                } else{
                    tmpmax=l[i]-l[ind-1];
                }
                ans = Math.max(tmpmax,ans);
            }

            if(mp.containsKey(nums[i])){
                int tmp = mp.get(nums[i]);
                if(l[i]<l[tmp]){
                   mp.put(nums[i],i);
                }
            } else{
                mp.put(nums[i],i);
            }
        }
        return  ans==Long.MIN_VALUE ? 0 : ans;
    }
}