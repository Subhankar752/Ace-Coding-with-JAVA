class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] countSame = new int[7];
        for(int i = 0; i<tops.length; i++)
        {
            int ele1 = tops[i];
            int ele2 = bottoms[i];
            countA[ele1]++;
            countB[ele2]++;
            if(ele1==ele2) countSame[ele1]++;
        }

        for(int i = 1; i<countA.length; i++)
        {
            int sum = countA[i]+countB[i]-countSame[i];
            
            if(sum==tops.length) 
            {
                int ele = Math.max(countA[i], countB[i]);
                return tops.length-ele;
            }
        }
        return -1;
    }
}