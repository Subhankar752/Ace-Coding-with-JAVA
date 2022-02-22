class Solution {
    public int titleToNumber(String s) {
         long i=0, sum=0;
    for(int j=s.length()-1;j>=0;j--){
        long num = s.charAt(j) -'A';
        sum+= (num+1)* (Math.pow(26,i++));
    }
    return (int)sum;
    }
}