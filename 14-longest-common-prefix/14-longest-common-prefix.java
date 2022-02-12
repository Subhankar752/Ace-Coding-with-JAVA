class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prev=strs[0];
        String ans="";
        int n=strs.length;
        for(String cur:strs){
            int n1=prev.length();
            int n2=cur.length();
            int i=0;
            int j=0;
            ans="";
            while(i<n1 && j<n2){
                if(prev.charAt(i) == cur.charAt(j)){
                    ans+=prev.charAt(i);
                }
                else{
                    break;
                }
                i++;
                j++;
            }
            if(ans=="")
                return "";
            prev=ans;
        }
        return prev;
    }
}