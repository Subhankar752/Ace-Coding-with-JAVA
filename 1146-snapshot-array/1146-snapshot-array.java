class SnapshotArray {
    private TreeMap<Integer, Integer>[] maps;
    private int snapIdx;

    public SnapshotArray(int length) {
        maps = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            maps[i] = new TreeMap<>();
            maps[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = maps[index];
        map.put(snapIdx, val);
    }
    
    public int snap() {
        return snapIdx++;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = maps[index];
        return map.floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */