class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        queue.offer(0);
        
        while(!queue.isEmpty()) {
            int index = queue.poll();
            List<Integer> keys = rooms.get(index);
            for(int key: keys) {
                if(!visited[key]) {
                    queue.offer(key);
                    visited[key] = true;
                }
            }
        }
        
        for(boolean currentVisit: visited) {
            if(!currentVisit) {
                return false;
            }
        }
        return true;
    }
}