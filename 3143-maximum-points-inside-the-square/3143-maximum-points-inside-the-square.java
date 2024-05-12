class Solution {

    public int maxPointsInsideSquare(int[][] points, String s) {
        Map<Integer, List<Character>> nm = new TreeMap<>();
        
        for (int i = 0; i < points.length; i++) {
            int val1 = points[i][0];
            int val2 = points[i][1];
            int val3 = Math.max(Math.abs(val1), Math.abs(val2));
        
            if (nm.containsKey(val3)) {
                List<Character> val = nm.get(val3);
                val.add(s.charAt(i));
                nm.put(val3, val);
            } else {
                List<Character> val = new ArrayList<>();
                val.add(s.charAt(i));
                nm.put(val3, val);
            }
        }
        
        Set<Character> kk = new HashSet<>();
        int count = 0;
        for (int i : nm.keySet()) {
            List<Character> val = nm.get(i);
            for (int j = 0; j < val.size(); j++) {
                if (kk.contains(val.get(j))) {
                    return count;
                }
                kk.add(val.get(j));
            }
            count += val.size();
        }
        
        return count;
    }
}
