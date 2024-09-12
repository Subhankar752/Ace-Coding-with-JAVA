class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] stampArr = stamp.toCharArray();
        char[] targetArr = target.toCharArray();
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[targetArr.length];
        int starCount = 0;
        
        while (starCount < targetArr.length) {
            boolean didReplace = false;
            for (int index = 0; index <= targetArr.length - stampArr.length; index++) {
                if (!isVisited[index] && canReplace(targetArr, index, stampArr)) {
                    starCount = applyReplacement(targetArr, index, stampArr.length, starCount);
                    didReplace = true;
                    isVisited[index] = true;
                    result.add(index);
                    if (starCount == targetArr.length) {
                        break;
                    }
                }
            }
            
            if (!didReplace) {
                return new int[0];
            }
        }
        
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(result.size() - i - 1);
        }
        return resultArray;
    }
    
    private boolean canReplace(char[] targetArr, int position, char[] stampArr) {
        for (int i = 0; i < stampArr.length; i++) {
            if (targetArr[i + position] != '*' && targetArr[i + position] != stampArr[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int applyReplacement(char[] targetArr, int position, int stampLength, int starCount) {
        for (int i = 0; i < stampLength; i++) {
            if (targetArr[i + position] != '*') {
                targetArr[i + position] = '*';
                starCount++;
            }
        }
        return starCount;
    }
}
