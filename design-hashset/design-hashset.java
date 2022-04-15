class MyHashSet {
    ArrayList<Integer> list = new ArrayList<>();
    public MyHashSet() {
        list = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!list.contains(key))
            list.add(key);
    }
    
    public void remove(int key) {
        if(list.contains(key)){
            list.remove(new Integer(key));
        }
    }
    
    public boolean contains(int key) {
        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */