class MyHashMap {
    int[] a;
    public MyHashMap() {
        a = new int[10000000];
    }
    
    public void put(int key, int value) {
        a[key] = value + 1;
    }
    
    public int get(int key) {
        return a[key] - 1;
    }
    
    public void remove(int key) {
        a[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */