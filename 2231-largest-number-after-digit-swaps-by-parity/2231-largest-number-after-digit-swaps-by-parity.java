class Solution {
    public int largestInteger(int num) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        int x = num;
        
        while(x > 0){
            int r = x % 10;
            if(r % 2 == 0)
                even.add(r);
            else
                odd.add(r);
            x = x / 10;
        }
        
        Collections.sort(odd , Collections.reverseOrder());
        Collections.sort(even , Collections.reverseOrder());
        int i = 0;
        int j = 0;
        int ans = 0;
        String st = Integer.toString(num);
        for(char c : st.toCharArray()){
            int val = c - '0';
            if(val % 2 == 0){
                ans = ans * 10 + even.get(i++);
            }
            else{
                ans = ans * 10 + odd.get(j++);
            }
        }
        return ans;
    }
}