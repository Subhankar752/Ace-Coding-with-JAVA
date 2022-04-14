class Solution {
    public int[] twoSum(int[] numbers, int target) {
         int first = -1;
        int second = -1;
        int i=0; 
        int j=numbers.length-1;
        while(i<j){
            if(numbers[i] + numbers[j] == target){
                first = i+1;
                second = j+1;
                break;
            }else if(numbers[i] + numbers[j] < target)
                i++;
            else
                j--;
        }
        return new int[]{first, second};
    }
}