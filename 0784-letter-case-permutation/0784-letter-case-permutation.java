class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        generate(s.toCharArray(), 0);
        return ans;
    }

    public void generate(char[] arr, int idx) {
        if (idx == arr.length) {
            ans.add(new String(arr));
            return;
        }

        if (Character.isDigit(arr[idx])) {
            generate(arr, idx + 1);
            return;
        }

        arr[idx] = Character.toLowerCase(arr[idx]);
        generate(arr, idx + 1);

        arr[idx] = Character.toUpperCase(arr[idx]);
        generate(arr, idx + 1);
    }
}