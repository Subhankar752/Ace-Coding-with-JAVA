class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashSet<Character> h=new HashSet<>();
        Queue<Character> q=new LinkedList<>();
        int temp=0;
        int max=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(h.contains(ch)){
                while(q.peek() != ch){
                    char v=q.remove();
                    h.remove(v);
                }
                q.remove();
                q.add(ch);
                
            }
            else{
                h.add(ch);
                q.add(ch);
            }
            temp=q.size();
            max=Math.max(max,temp);
        }
        return max;
        
        // int n=s.length();
        // if(s.length() ==0 )
        //     return 0;
        // int ans=1;
        // String temp="";
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(j==n-1){
        //             temp=s.substring(i);
        //         }
        //         else{
        //             temp=s.substring(i,j+1);
        //         }
        //         if(check(temp) == true){
        //             ans=Math.max(ans , temp.length());
        //         }
        //     }
        // }
        // return ans;
        
    }
    // public boolean check(String st){
    //     HashSet<Character> h=new HashSet<>();
    //     int n=st.length();
    //     for(int i=0;i<n;i++){
    //         char ch=st.charAt(i);
    //         h.add(ch);
    //     }
    //     return (h.size() == n);
    // }
}