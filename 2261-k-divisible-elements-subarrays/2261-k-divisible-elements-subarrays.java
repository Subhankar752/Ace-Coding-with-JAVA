class Solution {
    public int countDistinct(int[] nums, int k, int p) {
//         int ans = 0;
//         int n = nums.length;
//         ArrayList<ArrayList<Integer>> fin = new ArrayList<>();
        
//         for(int i = 0 ; i < n ; i++){
//             ArrayList<Integer> list = new ArrayList<>();
//             for(int j = i ; j < n ; j++){
//                 list.add(nums[j]);
//                 if(!fin.contains(list))
//                     fin.add(new ArrayList<>(list));
//             }
//         }
        
//         for(ArrayList<Integer> i : fin){
//             int c = 0;
//             for(int j : i){
//                 if(j % p == 0)
//                     c++;
//             }
//             if(c <= k)
//                 ans++;
//         }
//         return ans;
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int t = 0;
            for (int j = i; j < n ; j++) {
                sb.append(nums[j] + ",");
                if(nums[j] % p == 0){
                    t++;
                }
                if(t > k){
                    break;
                }
                
                set.add(sb.toString());
            }
        }

        return set.size();
    }
}