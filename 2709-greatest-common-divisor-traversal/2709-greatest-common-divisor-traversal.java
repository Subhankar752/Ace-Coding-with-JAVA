class Solution {
    int limit=100001;
    public int findp(int[]par,int i){
        if(par[i]==i) return i;
        return par[i]=findp(par,par[i]);
    }
    public void unionn(int[]par,int[]rank,int i,int j){
        int p1=findp(par,i);
        int p2=findp(par,j);
        if(rank[p1]>rank[p2]){
            par[p2]=p1;
        }
        else if(rank[p1]>rank[p2]){
            par[p1]=p2;
        }
        else{
            par[p1]=p2;
            rank[p2]++;
        }
    }
    public List<Integer> getFactors(int num){
         List<Integer> res=new ArrayList<>();
         for(int i=2;i<=Math.sqrt(num);i++){
             if(num%i==0){
                 res.add(i);
                 res.add(num/i);
             }
         }
         return res;
    }
    public boolean canTraverseAllPairs(int[] nums) {
        int[]par=new int[limit];
        int[]rank=new int[limit];
        int n=nums.length;
        if(n==0) return true;
        for(int i=0;i<limit;i++) par[i]=i;
        for(int num:nums){
            List<Integer>list=getFactors(num);
            for(int val:list){
                unionn(par,rank,val,num);
            }
        }
        int p=findp(par,nums[0]);
        for(int num:nums){
            if(num==1 && n>1) return false;
            if(p!=findp(par,num)) return false;
        }
        return true;
        
    }
}