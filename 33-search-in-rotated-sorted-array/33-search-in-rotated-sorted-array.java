class Solution {
    public int search(int[] arr, int key) {
//         int l=0,r= nums.length-1, mid =0;
//     while(l <= r){
//         mid = (l+r)/2;
//         if(nums[mid] == target) return mid;
        
//         // check which part is sorted
//         if(nums[l] <= nums[mid]){
//             if(target >= nums[l]&& target < nums[mid]){
//                 r = mid-1;
//             }else{
//                 l= mid+1;
//             }
//         }else {
//             if(target >= nums[mid] && target<= nums[r]){
//                 l = mid+1;
//             }else{
//                 r = mid-1;
//             }
//         }
//     }
    
//     return -1;
         int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i = 0 ; i < arr.length ; i++){
            if(min > arr[i]){
                min = arr[i];
                minIdx = i;
            }
        }
        System.out.println(minIdx);
        int ans = -1;
        
        int x = solve(arr , 0 , minIdx - 1 , key);
        if(x != -1){
            return x;
        }
        x = solve(arr , minIdx , arr.length - 1 , key);
        if(x != -1){
            return x;
        }
        
        return ans;
    }
    public int solve(int[] a , int l , int r , int x){
        while(l <= r){
            int mid = l + (r - l) / 2;
            
            if(a[mid] == x){
                return mid;
            }
            else if(a[mid] > x){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }
}