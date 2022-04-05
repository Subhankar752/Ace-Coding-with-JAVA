class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        int len = s.length();
        
        for (int i = 0; i < len; i++) 
            arr[i] = (int) (s.charAt(i) - '0');
        
        // get the first decreasing element from the right
        int i = len-1;
        while (i > 0 && arr[i-1] >= arr[i]) 
            i--;
        
        // if all elements are in decreasing order from left
        // it's the greatest combination, we can't get a greater combination
        
        if (i == 0)
            return -1;
        
        int pivot = i;
        
        // find the first greater from the right
        i = len-1;
        while (i >= 0 && arr[i] <= arr[pivot-1])
            i--;
        
        // swap the with first decreasing with first greater
        int temp = arr[pivot-1];
        arr[pivot-1] = arr[i];
        arr[i] = temp;
        
        // reverse all elements starting from pivot
        i = len-1;
        while (pivot < i) {
            temp = arr[pivot];
            arr[pivot] = arr[i];
            arr[i] = temp;
            
            pivot++;
            i--;
        }
        
        // convert back to integer 
        long ans = 0;
        for (int a: arr) {
            ans = ans*10 + a;
        }
            
        if (ans > Integer.MAX_VALUE)
            return -1;
        return (int) ans;

    }
}