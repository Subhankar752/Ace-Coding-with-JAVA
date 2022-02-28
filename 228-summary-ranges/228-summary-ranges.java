class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res= new ArrayList<String>();
        
        int i=0 , n=nums.length;
        while(i < n)
        {
            int start , end;
            
            start = nums[i];            
            while(i + 1 < n && nums[i + 1] == nums[i] + 1) 
                i++;
            end = nums[i];
            
            if(start == end)
                res.add(start + "");
            else
                res.add( start + "->" + end );
            
            i++;          
        }
        
        return res;
    }
}