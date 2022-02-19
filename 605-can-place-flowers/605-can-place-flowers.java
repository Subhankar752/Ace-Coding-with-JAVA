class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int N = n;
        n = flowerbed.length;
        boolean[] res = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(flowerbed[i] == 1){
                res[i] = true;
                if(i - 1 >= 0)
                    res[i - 1] = true;
                if(i + 1 < n)
                    res[i + 1] = true;
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++)
            System.out.print(res[i] + " ");
        for(int i = 0 ; i < n ; i++){
            if(res[i] == false)
                count++;
        }
        int temp = 0;
        for(int i = 0 ; i < n ; i++){
            if(res[i] == false){
                temp++;
            }
            else{
                if(temp > 1)
                {
                    count -= temp/2;
                }
                temp = 0;
            }
        }
        
        if(temp > 1)
                {
                    count -= temp/2;
                }
        
        if(count >= N)
            return true;
        return false;
    }
}