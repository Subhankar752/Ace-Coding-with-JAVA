class Solution {
   int mod=(int) Math.pow(10,9)+7;
    public int numberOfWays(int startPos, int endPos, int k) {
        
        HashMap<Integer,Integer> dp=new HashMap<>();
        
        return Sol(startPos,endPos,k,dp);
   
        
    }
    
    public int Sol(int startPos,int endPos,int k,HashMap<Integer,Integer> dp ){
        
         if(Math.abs(endPos-startPos)>k) return 0;
             
    if(startPos==endPos && k==0){
        return 1;
    }
    if(dp.containsKey(startPos*10000+k*10)){
        return dp.get(startPos*10000+k*10);
    }
        
        if(k==0){
            return 0;
        }
        
        
        int left=Sol(startPos-1,endPos,k-1,dp);
        int right=Sol(startPos+1,endPos,k-1,dp);
        
        int res= (left%mod+right%mod)%mod;
        dp.put(startPos*10000+k*10,res);
        return res;
    }
}