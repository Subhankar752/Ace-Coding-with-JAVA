class Solution {

    public int maxRepOpt1(String text) {
        int[] counter = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            counter[text.charAt(i) - 'a']++;
        }
        Map<Character, Integer> window = new HashMap<>();
        int max = 0;
        int l = 0;
        for (int r = 0; r < text.length(); r++) {
            char c = text.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (invalid(counter, window)) {
                char k = text.charAt(l);
                int count = window.get(k) - 1;
                if (count == 0) {
                    window.remove(k);
                } else {
                    window.put(k, count);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    boolean invalid(int[] counter, Map<Character, Integer> window) {
        if (window.size() <= 1) {
            return false;
        }
        if (window.size() > 2) {
            return true;
        }
        // only two characters
        Iterator<Character> it = window.keySet().iterator();
        char a = it.next();
        char b = it.next();
        int s1 = window.get(a);
        int s2 = window.get(b);
        return (s1 != 1 || counter[b - 'a'] <= s2) && (s2 != 1 || counter[a - 'a'] <= s1);
    }
}
