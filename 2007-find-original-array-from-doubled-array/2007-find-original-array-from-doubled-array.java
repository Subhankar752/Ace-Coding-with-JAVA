class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2 == 1)
            return new int[]{};
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Double , Integer> map = new HashMap<>();
        Arrays.sort(changed);
        for(int i = 0 ; i < n ; i++){
            double temp = (double)changed[i];
            double x = temp/2.0;
            if(map.containsKey(x) == true){
                int val = map.get(x);
                ans.add((int)x);
                val = val - 1;
                if(val <= 0){
                    map.remove(x);
                }
                else
                    map.put(x , val);
            }
            else{
               if(map.containsKey(temp) == true) 
                   map.put(temp , map.get(temp) + 1);
                else
                    map.put(temp , 1);
            }
        }
        if(map.size() > 0)
            return new int[]{};
        int[] res = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++)
            res[i] = ans.get(i);
        return res;
    }
}