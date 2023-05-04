class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();
        int n = senate.length();
        
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R') qr.offer(i);
            else qd.offer(i);
        }
        
        while(!qr.isEmpty() && !qd.isEmpty()){
            int curr_r = qr.poll();
            int curr_d = qd.poll();
        
            if(curr_r<curr_d){ 
                qr.offer(curr_r+n); 
            }else{
                qd.offer(curr_d+n);
            }   
        }
        return qr.size()>qd.size()?"Radiant":"Dire";
    }
}