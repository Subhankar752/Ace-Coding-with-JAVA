class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            map.put(c , i);
        }
        int max = 0;
        int prev = -1;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            max = Math.max(max , map.get(ch));
           // System.out.println(max);
            if(max == i){
                int len = max - prev;
                prev = max;
                max = 0;
                ans.add(len);
            }
        }
        return ans;
    }
}