class Solution {
    public int numSubseq(int[] nums, int target) {
        int p=1000000007;
        long ans=0;
        Arrays.sort(nums);
        int start=0,end=nums.length-1;
        while(start<=end){
            int sum=nums[start]+nums[end];
            if(sum>target){
                end--;
                continue;
            }else{
                ans=ans%p+fastExpo(2,end-start,p);
                start++;
            }
        }
        return (int)(ans%p);
    }

    private int fastExpo(int a,int n,int p){
        if(n==0) return 1;
        long pow=fastExpo(a,n/2,p)%p;
        long prod=(pow*pow)%p;
        if(n%2==0){
            return (int) prod;
        }else{
            return (int)((prod*a)%p);
        }
    }
}