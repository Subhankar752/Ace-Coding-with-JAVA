class SmallestInfiniteSet {
    
    PriorityQueue<Integer> queue;
    int current;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();
        current = 1;
    }

    public int popSmallest() {
        int result = current;

        if (!queue.isEmpty() && queue.peek() < current)
            result = queue.poll();
        else
            current++;

        while (!queue.isEmpty() && queue.peek() == result)
            queue.poll();

        return result;
    }

    public void addBack(int num) {
        queue.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */