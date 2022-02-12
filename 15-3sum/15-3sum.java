class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> h=new HashSet<>();
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                if(nums[i] + nums[j] +nums[k] == 0){
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    h.add(l);
                    j++;
                    k--;
                }
                else if(nums[i] + nums[j] +nums[k] < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(List<Integer> x:h)
            ans.add(x);
        return ans;
    }
}