class Solution {
//     List<List<Integer>> res = new ArrayList<>();
//     LinkedList<Integer> tmp = new LinkedList<>();
//     public List<List<Integer>> combine(int n, int k) {
//         back(n,k,1);
//         return res;
//     }
    
//     public void back(int n,int k, int start){
//         if(tmp.size() == k){
//             res.add(new ArrayList<>(tmp));
//             return;
//         }
        
//         for(int i = start;i<=n-(k-tmp.size())+1;i++){
//             tmp.add(i);
//             back(n,k,i+1);
//             tmp.removeLast();
//         }
//     }
// }
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++){
            a[i] = i + 1;
        }
        solve(a , k , n , new ArrayList<Integer>() , 0);
        // List<List<Integer>> res = new ArrayList<>();
        // for(List<Integer> i : ans){
        //     Collections.sort(i);
        //     if(res.contains(i))
        //         continue;
        //     res.add(i);
        // }
        return ans;
    }
    public void solve(int[] a , int k , int n , ArrayList<Integer> temp , int idx){
        
        if(temp.size() > k)
            return;
        
        if(temp.size() == k){
            // List<Integer> x = temp;
            // Collections.sort(x);
            // if(!ans.contains(x))
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = idx ; i < n ; i++){
            // if(temp.contains(a[i]))
            //     continue;
            temp.add(a[i]);
            solve(a , k , n , temp , i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}