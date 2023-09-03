class Solution {
    public int maxEnvelopes(int[][] envelopes) {
         Arrays.sort(envelopes,new EnvelopeComparator());
         return LIS(envelopes);
    }
    
    private int LIS(int[][] arr){
          int ans=0;
          int[] minele=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int val=arr[i][1];
            int lo=0, hi=ans;
            
            while(lo<hi){
                int mid=(lo + hi)/2;
                if(minele[mid]<val){
                    lo=mid+1;
                }else{
                    hi=mid;
                }
            }
            minele[lo]=val;
            
            if(lo==ans){
                ans++;
            }
        }
        return ans;
    }
    
    public class EnvelopeComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] one,int[] two){
            if(one[0]==two[0]) return two[1]-one[1];
            return one[0]-two[0];
        }
    }
}