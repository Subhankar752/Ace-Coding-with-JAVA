class Solution {
    public int triangularSum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums)
            list.add(i);
        while(list.size() != 1){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < list.size() - 1 ; i++){
                int val = list.get(i) + list.get(i + 1);
                val = val % 10;
                temp.add(val);
            }
            list = temp;
        }
        return list.get(0);
    }
}