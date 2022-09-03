class Solution {
   public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res= new ArrayList<Integer>();
        
        if(n==0)
            return new int[0];
        
        if(n==1)
            res.add(0);
        
        dfs(n, k, res, 0);
        int[] arr=new int[res.size()];
            
        for(int i=0; i< res.size(); i++){
            arr[i]= res.get(i);
        }
        
        return arr;
        
    }
    
    public void dfs(int n, int k, List<Integer> res, int num){
        
        //we found the number
        if(n==0){
            res.add(num);
            return;
        }
        
        
        for(int i=0;i< 10;i++){
            //we cannont have number that starts with 0 
            if(i==0 && num==0)
                continue;
            
            //if its the first digit we can add directly
            else if(i !=0 && num == 0){
                dfs( n-1, k, res, i);
            }
            else{
                //difference can be negative
                if( Math.abs((num%10) - i) == k)
                    dfs(n-1, k, res, (num*10 + i));
            }
        }
    }
}