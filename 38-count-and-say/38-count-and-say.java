class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        if(n==2)
            return "11";
        String temp="11";
        for(int i=3;i<=n;i++){
            temp+="#";
            int len=temp.length();
            String ans="";
            int c=1;
            char[] arr=temp.toCharArray();
            for(int j=0;j<len-1;j++){
                if(arr[j] == arr[j+1]){
                    c++;
                }
                else{
                    ans+=Integer.toString(c);
                    ans+=arr[j];
                    c=1;
                }
            }
            temp=ans;
        }
        return temp;
    }
}