class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
    int count = 0;
    
    HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
        
            int target = nums3[i]+ nums4[j];
            hashmap.put(target,hashmap.getOrDefault(target,0)+1);
        }
    }
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            int target = nums1[i]+nums2[j];
            
            int opptarget = Math.abs(target)==target ? -target : target * -1;
            
            if(hashmap.containsKey(opptarget)){
                count+= hashmap.get(opptarget);
            }
        }
    }
    
    return count;
    }
}