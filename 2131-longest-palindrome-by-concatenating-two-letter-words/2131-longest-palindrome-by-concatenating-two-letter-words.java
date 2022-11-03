class Solution {
    public int longestPalindrome(String[] words) {
        int ans = 0;
        boolean flag = false;
        HashMap<String , Integer> map = new HashMap<>();
        HashMap<String , Integer> c = new HashMap<>();
        
        for(String s : words){
            StringBuilder sb = new StringBuilder(s);
            sb = sb.reverse();
            String temp = sb.toString();
            if(temp.equals(s)){
                if(c.containsKey(s)){
                    c.put(s , c.get(s) + 1);
                }
                else{
                    c.put(s , 1);
                }
            }
            else{
                if(map.containsKey(s)){
                    map.put(s , map.get(s) + 1);
                }
                else{
                    map.put(s , 1);
                }
            }
        }
        
        for(Map.Entry<String , Integer> m : map.entrySet()){
            String key = m.getKey();
            int val = m.getValue();
            StringBuilder sb = new StringBuilder(key);
            sb = sb.reverse();
            String temp = sb.toString();
            if(map.containsKey(temp)){
                //map.remove(key);
                int val2 = map.get(temp);
                int min = Math.min(val , val2);
                ans += (min * 2);
                //map.remove(temp);
            }
        }
        
        int max = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        for(Map.Entry<String , Integer> m : c.entrySet()){
            int val = m.getValue();
            list1.add(val);
        }
        Collections.sort(list1 , Collections.reverseOrder());
        for(int i : list1)
            System.out.print(i + " ");
        for(int i : list1){
            if(i%2 != 0){
                if(flag == false){
                max += i;
                flag = true;
                }
                else{
                    max += i - 1;
                }
            }
            else{
                max += i;
            }
            
        }
        max = max * 2;
        return ans + max;
    }
}