class Solution {
    public boolean validMountainArray(int[] arr) {
        int peak = 0;
        int n = arr.length;
        if(n == 1)
            return false;
        
        for(int i = 1 ; i < n - 1 ; i++){
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                peak++;
            if(arr[i] < arr[i - 1] && arr[i] < arr[i + 1])
                return false;
            if(arr[i] == arr[i - 1] || arr[i] == arr[i + 1])
                return false;
        }
        if(peak == 1)
            return true;
        return false;
    }
}