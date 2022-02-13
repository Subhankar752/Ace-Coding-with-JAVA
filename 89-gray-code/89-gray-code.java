class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList();
        res.add(0);
        for(int i=1;i<=n;i++){
            int count = res.size()-1;
            int add = (int)Math.pow(2,i-1);
            while(count>=0)
                   res.add(add+res.get(count--));
            }
     return res;
    }
}