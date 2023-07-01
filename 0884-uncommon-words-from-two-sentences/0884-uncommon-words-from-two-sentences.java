class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        
        for (String w : (A + " " + B).split(" "))
            count.put(w, count.getOrDefault(w, 0) + 1);
        
        ArrayList<String> res = new ArrayList<>();
        
        for (String w : count.keySet())
            if (count.get(w) == 1)
                res.add(w);
        
        return res.toArray(new String[0]);
    }
}