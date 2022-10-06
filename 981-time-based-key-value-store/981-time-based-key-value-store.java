class TimeMap {

    Map<String,List<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        
        String ans = "";
        if(list != null && list.size() > 0){
            
            int s = 0;
            int e = list.size() - 1;
            
            while(s <= e){
                int m = s + (e-s)/2;
                
                Pair p = list.get(m);
                
                if(p.timestamp <= timestamp){
                    ans = p.val;
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }
        
        return ans;
    }
    
    class Pair{
        String val;
        int timestamp;
        
        public Pair(String v, int t){
            this.val = v;
            this.timestamp = t;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */