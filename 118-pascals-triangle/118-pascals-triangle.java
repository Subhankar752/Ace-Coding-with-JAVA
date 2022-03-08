class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> fi=new ArrayList<>();
        List<Integer> x1=new ArrayList<>();
        x1.add(1);
        fi.add(x1);
        if(n == 1)
            return fi;
        for(int i=1;i<n;i++){
            List<Integer> li = new ArrayList<>();
            li.add(1);
            for(int g = 0 ; g < fi.get(i-1).size() - 1 ; g++){
                int x = fi.get(i-1).get(g) + fi.get(i-1).get(g+1);
                li.add(x);
            }
            li.add(1);
            fi.add(li);
        }
        return fi;
    }
}