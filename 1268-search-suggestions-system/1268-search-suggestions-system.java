class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int n = searchWord.length();
        Arrays.sort(products);
        String temp = "";
        for(int i = 0 ; i < n ; i++){
            temp += searchWord.charAt(i);
            List<String> cur = solve(temp , products);
            ans.add(cur);
        }
        return ans;
    }
    public List<String> solve(String temp , String[] arr){
        List<String> ans = new ArrayList<>();
        for(String i : arr){
            if(i.startsWith(temp) && ans.size() < 3)
                ans.add(i);
        }
        return ans;
    }
}