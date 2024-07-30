public class Solution {
    public int brokenCalc(int startValue, int target) {
        int operations = 0;
        
        while (target > startValue) {
            if (target % 2 == 0) {
                target /= 2;  // Divide by 2 if the number is even
            } else {
                target += 1;  // Make the number even by adding 1
            }
            operations++;
        }
        
        // Add the difference between startValue and target
        return operations + (startValue - target);
    }
}
