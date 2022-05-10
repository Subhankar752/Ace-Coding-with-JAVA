class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    combination(ans, new ArrayList<Integer>(), k, 1, n , 0);
    return ans;
}

private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n , int sum) {
	if (comb.size() == k && n == sum) {
		List<Integer> li = new ArrayList<Integer>(comb);
		ans.add(li);
		return;
	}
    if(comb.size() >= k || sum >= n)
        return;
	for (int i = start; i <= 9; i++) {
		comb.add(i);
        sum += i;
		combination(ans, comb, k, i+1, n , sum);
		comb.remove(comb.size() - 1);
        sum -= i;
	}
}
}