class Solution {
    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
        int len=needle.length();
        if(len==0)
            return 0;
        int ans=-1;
        int n=haystack.length();
        for(int i=0; i<n-len+1; i++){
            String t=haystack.substring(i,i+len);
            if(t.equals(needle)==true)
            {
              ans=i;
                break;
            } 
        }
        return ans;
    }
}