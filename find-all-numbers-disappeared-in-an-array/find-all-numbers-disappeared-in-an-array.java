class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
    
    for(int i = 0; i < nums.length; i++){
        set.add(nums[i]);
    }

    List<Integer> list = new ArrayList<>();
    
    int n = nums.length;
    
    while(n != 0){
        if(!set.contains(n)){
            list.add(n);
        }
        n--;
    }
    return list;
    }
}