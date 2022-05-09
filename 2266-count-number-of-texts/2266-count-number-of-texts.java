class Solution {
    public int countTexts(String pressedKeys) {
        int[] memo=new int[pressedKeys.length()];
        
        return dfs(pressedKeys,memo,0);
    }
    
    public int dfs(String pk,int[] memo,int index){
        if(index==pk.length())  //if end of string is reached that is one permutation
            return 1;
        
        if(memo[index]!=0)      //if countof permutations for that index is already calculated
            return memo[index];
        
        int count=0;
        for(int i=0;i<4;i++){   //max we need to go four index forward
            //for only button 7 and 9 we have 4 charcters
            if(pk.charAt(index)!='7' && pk.charAt(index)!='9' && i==3)  
                break;
            
            if(index+i>=pk.length())    //if end index goes out of bounds
                break;
              
            if(i!=0){  
                //if adjacent characters are not same
                if(pk.charAt(index+i)!=pk.charAt(index+i-1))    
                    break;
            }
            
            count+=dfs(pk,memo,index+i+1);  //recursive call for remaining string
            count%=1000000007;
                
        }
        
        memo[index]=count;  //store the calculated value for this index
        return count;
    }
}