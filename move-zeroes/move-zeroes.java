class Solution {
    public void moveZeroes(int[] nums) {
        // ArrayList<Integer> a=new ArrayList<>();
        // int zero=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i] == 0)
        //         zero++;
        //     else
        //         a.add(nums[i]);
        // }
        // for(int i=0;i<zero;i++)
        //     a.add(0);
        // for(int i=0;i<nums.length;i++)
        //     nums[i]=a.get(i);
        int n = nums.length;
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }
    }
    
}