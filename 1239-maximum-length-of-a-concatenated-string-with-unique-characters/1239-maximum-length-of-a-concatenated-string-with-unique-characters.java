class Solution {
    public int maxLength(List<String> arr) {
        return util(0,arr, "");
    }
    public int util(int i,List<String> arr, String curr) {
        if(i == arr.size()) return 0;
        int take = 0, notTake = 0;
        notTake = util(i+1, arr, curr);
        if(check(getCharArray(curr+arr.get(i)))) take = util(i+1, arr, curr+arr.get(i))+arr.get(i).length();
           
           return Math.max(take, notTake);
    }

    public boolean check(int[] ch) {
        for(int i = 0;i< 26;i++){
            if(ch[i] >1) return false;
        }
        return true;
    }

    public int[] getCharArray(String str) {
        int temp[] = new int[26];
        for(char ch : str.toCharArray()){
            temp[ch-'a']++;
        }
        return temp;
    }

}