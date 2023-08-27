class Solution {
    public boolean canCross(int[] stones) {
        Boolean [][] memo = new Boolean[stones.length+1][stones.length+1];
        return recursion(0,1,stones,memo);
    }
    public boolean recursion(int i, int jump, int[] stones,Boolean [][] memo){
        if(i>=stones.length){
            return false;
        }
        if(i==stones.length-1){
            return true;
        }
        if(memo[i][jump]!=null){
            return memo[i][jump];
        }
        int nextPossibleStone = stones[i]+jump;
        int index = Arrays.binarySearch(stones,nextPossibleStone);
        if(index>i){
            boolean jump1 = recursion(index,jump-1,stones,memo);
            boolean jump2 = recursion(index,jump,stones,memo);
            boolean jump3 = recursion(index,jump+1,stones,memo);
            return memo[i][jump] = jump1||jump2||jump3;
        }
        return false;
    }
}