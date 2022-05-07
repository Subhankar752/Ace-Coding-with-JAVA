class Solution {
   public static class Pair{
        char ch;
        int count;
        Pair(char ch,int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                st.push(new Pair(ch,1));
            }
            else{
                Pair p=st.peek();
                char ch1=p.ch;
                int co=p.count;
                if(ch==ch1){
                    st.push(new Pair(ch,co+1));
                }
                else
                    st.push(new Pair(ch,1));
            }
            Pair pp=st.peek();
            int c=pp.count;
            if(c==k){
                for(int j=0;j<k;j++){
                    st.pop();
                }
            }
        }
        
        String str="";
        while(!st.isEmpty()){
            Pair po=st.pop();
            char cc=po.ch;
            str=cc+str;
        }
        return str;
}
}