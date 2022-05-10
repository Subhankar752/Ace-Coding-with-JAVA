class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    combination(ans, new ArrayList<Integer>(), k, 1, n , 0);
    return ans;
}

private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n , int sum) {
	if (comb.size() == k && n == sum) {
		List<Integer> li = new ArrayList<Integer>(comb);
        Collections.sort(li);
        if(!ans.contains(li))
		ans.add(li);
		return;
	}
    if(comb.size() >= k || sum >= n)
        return;
	for (int i = 1; i <= 9; i++) {
        if(comb.contains(i))
            continue;
		comb.add(i);
        sum += i;
		combination(ans, comb, k, i+1, n , sum);
		comb.remove(comb.size() - 1);
        sum -= i;
	}
}
}