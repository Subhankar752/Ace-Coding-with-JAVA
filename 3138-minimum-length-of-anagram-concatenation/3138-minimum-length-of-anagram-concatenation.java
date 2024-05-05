class Solution {
    private int calculateGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return calculateGCD(b, a % b);
    }

    public int minAnagramLength(String s) {
        // Create a frequency count of characters in the given string
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find the greatest common divisor (GCD) of all character counts
        int commonDivisor = charCount.get(s.charAt(0)); // Initialize with the first character's count
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            commonDivisor = calculateGCD(commonDivisor, entry.getValue());
        }

        // Return the length of the string divided by the GCD
        return s.length() / commonDivisor;
    }
}