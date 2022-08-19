class Solution {
    public boolean isPossible(int[] nums) {
        // This hashmap tells us about whether a number in num is available for a job or not
        HashMap<Integer,Integer> avaibilityMap = new HashMap<>();
        
        // This hashmap tells a number (say x), if there is a job vacancy for them
        HashMap<Integer,Integer> wantMap = new HashMap<>();
        
        // We store the count of every num in nums into avaibilityMap. Basically, a number's count is the avaibility of it.
        for(int i : nums){
            avaibilityMap.put(i, avaibilityMap.getOrDefault(i,0)+1);
        }
        
        // We iterate through each number in the nums array. Remember the story ? So, treat them like a person.
        for(int i=0;i<nums.length;i++){
            // First we check if our current num/person is available. If it is not we just continue with next num/person
            if(avaibilityMap.get(nums[i])<=0){
                continue;
            }
            
            // If the person is available, first we check if there is a job vacancy for him/her. Basically, is someone looking for him/her?
            else if(wantMap.getOrDefault(nums[i],0)>0){
                // Yes, someone is looking, so we decrease the avaibility count of that number
                avaibilityMap.put(nums[i], avaibilityMap.getOrDefault(nums[i],0)-1);
                
                // we also decrease its count from the job vacancy space / wantMap
                wantMap.put(nums[i], wantMap.getOrDefault(nums[i],0)-1);
                
                // Then as a goodwill, he/she will also create a job vacancy for (num[i]+1) in job vacancy space / wantMap, as we need consecutive numbers only
                wantMap.put(nums[i]+1, wantMap.getOrDefault(nums[i]+1,0)+1);
            }
            
            // Ooh, we are here means nums[i] was not able to find a job.
            // so, nums[i] tries to start his/her own company by checking avaibility of his/her friends i.e. (nums[i]+1) and (nums[i]+2)
            else if(avaibilityMap.getOrDefault(nums[i],0)>0 && avaibilityMap.getOrDefault(nums[i]+1,0)>0 && avaibilityMap.getOrDefault(nums[i]+2,0)>0){
                
                // Yay! both 2 friends are available. Let's start a company.
                // So we decrease the avaibility count of nums[i], (nums[i]+1) and (nums[i]+2) from the 
                // avaibilityMap
                avaibilityMap.put(nums[i], avaibilityMap.getOrDefault(nums[i],0)-1);
                avaibilityMap.put(nums[i]+1, avaibilityMap.getOrDefault(nums[i]+1,0)-1);
                avaibilityMap.put(nums[i]+2, avaibilityMap.getOrDefault(nums[i]+2,0)-1);
                
                // Also, as a goodwill, we create a new job vacancy for (nums[i]+3), as we need consecutive numbers only
                wantMap.put(nums[i]+3, wantMap.getOrDefault(nums[i]+3,0)+1);
            }
            
            // Bad luck case, nums[i] not able to start his/her company, so just return false
            else{
                return false;
            }
        }
        
        // All good till here so we return true
        return true;
    }
}