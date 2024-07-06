class Solution {
    Set<String> set = new HashSet<String>();
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<String>();
    Stack<String> stack = new Stack<String>();

    public List<String> braceExpansionII(String expression) {
        stack.push(expression);
        iter_dfs();
        Collections.sort(res);
        return res;
    }

    private void iter_dfs() {
        while (!stack.isEmpty()) {
            String str = stack.pop();
            if (str.indexOf('{') == -1) {
                if (!set.contains(str)) {
                    res.add(str);
                    set.add(str);
                }
                continue;
            }

            int i = 0, l = 0, r = 0;
            while (str.charAt(i) != '}') {
                if (str.charAt(i++) == '{') l = i - 1;
            }
            r = i;

            String before = str.substring(0, l);
            String after = str.substring(r + 1, str.length());
            String[] args = str.substring(l + 1, r).split(",");

            for (String s : args) {
                sb.setLength(0);
                stack.push(sb.append(before).append(s).append(after).toString());
            }
        }
    }
}
