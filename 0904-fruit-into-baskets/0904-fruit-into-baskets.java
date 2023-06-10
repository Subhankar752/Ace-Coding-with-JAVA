class Solution {

    public int totalFruit(int[] fruits) {
        int ans = 0;

        int i = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {
            if (map.containsKey(fruits[j])) {
                map.put(fruits[j], map.get(fruits[j]) + 1);
            } else {
                map.put(fruits[j], 1);
            }

            while (map.size() > 2) {
                int val = map.get(fruits[i]);
                val--;
                
                map.put(fruits[i] , val);
                if (val == 0) map.remove(fruits[i]);
                
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}
