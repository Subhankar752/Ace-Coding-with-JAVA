class NumberContainers {
    
    HashMap<Integer , Integer> map;
    HashMap<Integer , TreeSet<Integer>> ind;
    
    public NumberContainers() {
        
        map = new HashMap<>();
        ind = new HashMap<>();
    
    }
    
    public void change(int index, int number) {
        if(map.containsKey(index)){
            int val = map.get(index);
            map.put(index , number);
            TreeSet<Integer> l = ind.get(val);
            l.remove(Integer.valueOf(index));
        }
        else{
            map.put(index , number);
        }
        
        if(ind.containsKey(number)){
           // PriorityQueue<Integer> list = ind.get(number);
            TreeSet <Integer> list = ind.get(number);
            list.add(index);
            ind.put(number , list);
        }
        else{
            TreeSet<Integer> list = new TreeSet<>();
            //ArrayList<Integer> list = new ArrayList<>();
            list.add(index);
            ind.put(number , list);
        }
    }
    
    public int find(int number) {
        if(ind.containsKey(number)){
           // PriorityQueue<Integer> list = ind.get(number);
           // return list.peek();
            //ArrayList<Integer> x = ind.get(number);
            //if(x.size() == 0)
               // return -1;
           // Collections.sort(x);
           // return x.get(0);
            TreeSet<Integer> ts = ind.get(number);
            if(ts.size() == 0)
                return -1;
            return ts.first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */