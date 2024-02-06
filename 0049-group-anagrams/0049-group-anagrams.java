class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String temp = new String(chs);

            List<String> list;
            if (map.containsKey(temp)) {
                list = map.get(temp);
            } else {
                list = new ArrayList<>();
            }

            list.add(s);
            map.put(temp, list);
        }

        for (Map.Entry<String, List<String>> m : map.entrySet()) {
            List<String> val = m.getValue();
            ans.add(val);
        }

        return ans;
    }
}
