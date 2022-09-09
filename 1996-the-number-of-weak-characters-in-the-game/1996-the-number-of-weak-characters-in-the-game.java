class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties , (a , b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int n = properties.length , max = Integer.MIN_VALUE , res = 0;
        
        // for(int[] a : properties){
        //     for(int i : a)
        //         System.out.print(i + " ");
        //     System.out.println();
        // }
        
        for(int i = 0 ; i < n ; i++){
            if(properties[i][1] < max) 
                res++;
            max = Math.max(max , properties[i][1]);
        }
        return res;
    }
}