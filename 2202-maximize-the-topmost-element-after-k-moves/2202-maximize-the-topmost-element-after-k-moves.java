class Solution {
    public int maximumTop(int[] nums, int k) {
        int l=nums.length;
        if((l==0 && k>0) || (l==1 && k%2==1)){
            return -1;
}
        if(l==0){
            return 0;
}
        int max=0;
        for(int i=0;i<l && i<k-1 ;i++){
            max=Math.max(max,nums[i]);
}
        if(k<l){
            max=Math.max(max,nums[k]);
}
        return max;
    }
}