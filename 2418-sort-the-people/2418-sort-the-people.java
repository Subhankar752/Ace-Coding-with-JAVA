class Solution {
    
    class Pair{
        int height;
        String name;
        Pair(int height , String name){
            this.height = height;
            this.name = name;
        }
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Pair[] p = new Pair[n];
        
        for(int i = 0 ; i < n ; i++){
            p[i] = new Pair(heights[i] , names[i]);    
        }
        
        Arrays.sort(p , (aa , bb) -> bb.height - aa.height);
        
        String[] ans = new String[n];
        
        for(int i = 0 ; i < n ; i++){
            ans[i] = p[i].name;
        }
        
        return ans;
    }
}