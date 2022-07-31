class Solution {
    public int maximumGroups(int[] grades) {
        int i=1;
        while((i * (i+1))/2 <= grades.length) {
            i++;
        }
        return i-1;   
    }
}