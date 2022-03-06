class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = n - 1 ; i >= 0 ; i--){
            if(st.isEmpty()){
                res.add(-1);
            }
            else if(st.peek() > nums2[i]){
                res.add(st.peek());
            }
            else{
                while(!st.isEmpty() && st.peek() <= nums2[i]){
                    st.pop();
                }
                if(st.isEmpty())
                    res.add(-1);
                else
                    res.add(st.peek());
            }
            st.push(nums2[i]);
        }
        
        int[] a = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i++){
            a[i] = res.get(res.size() - 1 -i);
        }
       // return a;
        int[] ans = new int[nums1.length];
        int k = 0;
        for(int i : nums1){
            int index = search(i , nums2);
            ans[k++] = a[index];
        }
        return ans;
    }
    public int search(int val , int[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == val)
                return i;
        }
        return -1;
    }
}