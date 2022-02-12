class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (aa , bb) -> aa[0] - bb[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(intervals[0][0] , intervals[0][1]));
        for(int i = 1 ; i < intervals.length ; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            int start = st.peek().a;
            int end = st.peek().b;
            if(start <= b && end >= a){
                st.pop();
                a = Math.min(a , start);
                b = Math.max(b , end);
                st.push(new Pair(a , b));
            }
            else{
                st.add(new Pair(a , b));
            }
        }
        int size = st.size();
        int[][] ans = new int[size][2];
        Stack<Pair> ss = new Stack<>();
        while(!st.isEmpty()){
            Pair p = st.pop();
            ss.push(p);
        }
        int ind = 0;
        while(!ss.isEmpty()){
            Pair p = ss.pop();
            int a = p.a;
            int b = p.b;
            ans[ind][0] = a;
            ans[ind][1] = b;
            ind++;
        }
        return ans;
    }
}