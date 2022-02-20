class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if(finalSum % 2 != 0)
            return ans;
        long val = 2L;
        long sum = 0L;
        while(sum < finalSum){
            sum += val;
            ans.add(val);
            val += 2;
        }
        if(sum == finalSum)
            return ans;
        long x = ans.get(ans.size() - 1);
        ans.remove(ans.size() - 1);
        sum -= x;
        long y = finalSum - sum;
        long z = ans.get(ans.size() - 1);
        ans.remove(ans.size() - 1);
        z = z + y;
        ans.add(z);
        return ans;
    }
}