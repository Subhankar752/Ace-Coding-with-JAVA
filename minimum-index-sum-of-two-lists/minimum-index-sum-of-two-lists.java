class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < list1.length ; i++){
            map.put(list1[i] , i);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < list2.length ; i++){
            String temp = list2[i];
            if(map.containsKey(temp)){
                int val1 = map.get(temp);
                int sum = i + val1;
                min = Math.min(min , sum);
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0 ; i < list2.length ; i++){
            String temp = list2[i];
            if(map.containsKey(temp)){
                int sum = i + map.get(temp);
                if(sum == min){
                    ans.add(temp);
                }
            }
        }
        int n = ans.size();
        String[] res = new String[n];
        for(int i = 0 ; i < n ; i++)
            res[i] = ans.get(i);
        
        return res;
    }
}