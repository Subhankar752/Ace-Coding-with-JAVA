class Solution {
    public char kthCharacter(long k, int[] operations) {
        // Base case: if k is 1, return 'a'
        if (k == 1) {
            return 'a';
        }

        int n = operations.length; // Length of the operations array
        int opType = 0; // To store the operation type (0 or 1)
        long len = 1; // Start with length 1 (initial 'a')
        long newK = k; // To store the adjusted k value

        // Determine the operation type by traversing the operations array
        for (int i = 0; i < n; i++) {
            len *= 2; // Double the length
            if (len >= k) { // Check if the length has surpassed k
                opType = operations[i]; // Get the current operation type
                newK = k - len / 2; // Adjust k for the recursive call
                break;
            }
        }

        // Recursive call to find the character before the operation is applied
        char res = kthCharacter(newK, operations);

        // If operation type is 0, return the result as is
        if (opType == 0) 
            return res;

        // If operation type is 1, transform the character
        if (res == 'z') 
            return 'a';

        return (char) (res + 1); // Increment character by 1
    }
}