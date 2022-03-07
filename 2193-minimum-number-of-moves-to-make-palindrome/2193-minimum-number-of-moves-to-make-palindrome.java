class Solution {
    public int minMovesToMakePalindrome(String str) {
        int n=str.length();
        char[] s=str.toCharArray();
        int lptr=0;
        int rptr=n-1;
        
        int res=0;
        while(lptr<rptr){
            int r=rptr;
            
            if(s[lptr]==s[r]){
                lptr++;
                rptr--;
                continue;
            }
            
            while(s[lptr]!=s[r]) r--;
            
            if(lptr==r){
                swap(s,lptr,lptr+1);
                res++;
            }
            else{
                while(r!=rptr){
                    swap(s,r,r+1);
                    r++;
                    res++;
                }
            }
        }
        return res;
    }
    
    public void swap(char[] s,int l,int r){
        char temp=s[l];
        s[l]=s[r];
        s[r]=temp;
    }
}