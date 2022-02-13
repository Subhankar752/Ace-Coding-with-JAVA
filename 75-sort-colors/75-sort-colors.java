class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int one=0;
        int two=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 0)
                zero++;
            else if(nums[i] == 1)
                one++;
            else
                two++;
        }
        int k=0;
        for(int i=0;i<zero;i++)
            nums[k++]=0;
        for(int i=0;i<one;i++)
            nums[k++]=1;
        for(int i=0;i<two;i++)
            nums[k++]=2;
    }
}