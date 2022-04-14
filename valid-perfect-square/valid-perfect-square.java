class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while(start <= end){
            long mid = start+(end-start)/2;
            long squaredMid = mid * mid;
            if(squaredMid == num)
                return true;
            else if(squaredMid > num){
                end =(int) mid -1;
            }else if(squaredMid < num){
                start = (int)mid+1;
            }
        }
        return false;
    }
}