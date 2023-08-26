class Solution {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> ind = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            ind.add(i);
        }
        
        Collections.sort(ind, (x, y) -> Integer.compare(positions[x], positions[y]));
        Stack<Integer> s = new Stack<>();
        
        for (int x : ind) {
            if (directions.charAt(x) == 'L') {
                while (!s.empty()) {
                    int y = s.peek();
                    if (healths[x] == healths[y]) {
                        healths[x] = 0;
                        healths[y] = 0;
                        s.pop();
                        break;
                    }
                    if (healths[x] > healths[y]) {
                        healths[x]--;
                        healths[y] = 0;
                        s.pop();
                    } else {
                        healths[x] = 0;
                        healths[y]--;
                        break;
                    }
                }
            } else {
                s.push(x);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int x : healths) {
            if (x != 0) {
                result.add(x);
            }
        }
        
        return result;
    }
}
