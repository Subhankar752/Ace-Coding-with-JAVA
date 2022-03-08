class Solution {
    public List<Integer> getRow(int n) {
        List<List<Integer>> fi = new ArrayList<>();
        List<Integer> x1 = new ArrayList<>();
        x1.add(1);
        fi.add(x1);
        if(n == 0)
            return x1;
        for(int i = 1 ; i < n + 1 ; i++){
            List<Integer> li = new ArrayList<>();
            li.add(1);
            for(int g = 0 ; g < fi.get(i-1).size() - 1 ; g++){
                int x = fi.get(i-1).get(g) + fi.get(i-1).get(g+1);
                li.add(x);
            }
            li.add(1);
            fi.add(li);
        }
        return fi.get(n);
    }
}