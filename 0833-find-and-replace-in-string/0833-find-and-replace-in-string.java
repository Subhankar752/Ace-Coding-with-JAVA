class Solution {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        String output = "";
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < indices.length; k++) {
            map.put(indices[k], k);
        }
        while (i < s.length()) {
            
            if (map.containsKey(i) && s.substring(indices[map.get(i)], indices[map.get(i)] + sources[map.get(i)].length()).equals(sources[map.get(i)])) {
                output += targets[map.get(i)];
                i += sources[map.get(i)].length();
            } else {
                output += s.charAt(i);
                i++;
            }
        }
        return output;
    }
}
