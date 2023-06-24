class Solution {

    public int hIndex(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;
        
        while (lo <= hi) {
            
            int med = (hi + lo) / 2;
        
            if (citations[med] == len - med) {
                return len - med;
            } else if (citations[med] < len - med) {
                lo = med + 1;
            } else {
                hi = med - 1;
            }
        }
        
        return len - lo;
    }
}
