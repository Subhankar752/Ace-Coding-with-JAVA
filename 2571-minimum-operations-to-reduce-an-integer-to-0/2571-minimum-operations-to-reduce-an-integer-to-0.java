class Solution {
    public int minOperations(int n) {
    int c = 0;
      while(n > 0){
         c++;
          
         double x = Math.log(n) / Math.log(2);
          
         int prevPower = (int) Math.pow(2,(int) x);
         int nextPower = (int) Math.pow(2,(int) x + 1);
          
         int diff1 = n - prevPower;
         int diff2 = nextPower - n;
          
         if(diff1 < diff2) n = diff1;
         else n = diff2;
      }
        return c;
    }
}