class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String ans1 = "";
        String ans2 = "";
        
        for(String s : word1){
            ans1 += s;
        }
        for(String s : word2){
            ans2 += s;
        }
        
        if(ans1.equals(ans2))
            return true;
        
        return false;
    }
}