class Solution {
   class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        
        for(int i = 0 ; i < n ; i++){
            if(map.get(arr[i]) == null)
                map.put(arr[i] , 1);
            else
                map.put(arr[i] , map.get(arr[i]) + 1);
        }
        
        int x = n / 2;
        int size = 0;
        int count = 0;
        ArrayList<Pair> a = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            int key = m.getKey();
            int val = m.getValue();
            a.add(new Pair(key , val));
        }
        
        Collections.sort(a , (aa , bb) -> bb.b - aa.b);
        
        for(int i = 0 ; i < a.size() ; i++){
            int val = a.get(i).b;
            size += val;
            count++;
            if(size >= x)
                break;
        }
        
        
        return count;
    }
}