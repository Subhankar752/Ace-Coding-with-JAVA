class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums)
            hs.add(i);
        ArrayList<Integer> a = new ArrayList<>();
        for(int i : hs)
            a.add(i);
        Collections.sort(a , Collections.reverseOrder());
        if(a.size() < 3){
            return a.get(0);
        }
        return a.get(2);
    }
}