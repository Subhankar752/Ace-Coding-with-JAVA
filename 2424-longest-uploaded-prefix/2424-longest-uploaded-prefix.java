class LUPrefix {

    Set<Integer> set;
    int maxConsecutiveVideo = 0;
    
    public LUPrefix(int n) {
        set = new HashSet<>();
    }
    
    public void upload(int video) {
        set.add(video);
        while (set.contains(maxConsecutiveVideo + 1)) {
            maxConsecutiveVideo++;
        }
    }
    
    public int longest() {
        return maxConsecutiveVideo;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */