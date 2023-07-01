class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> count = new HashMap();
        
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
        
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    count.put(d, count.getOrDefault(d, 0) + n);
                }
            }
            
            count.put(s, count.getOrDefault(s, 0) + n);
        }

        List<String> res = new ArrayList();
        for (String d : count.keySet()) res.add(count.get(d) + " " + d);
        
        return res;
    }
}
