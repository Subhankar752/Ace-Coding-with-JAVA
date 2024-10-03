class Solution {

    public boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        Map<Character, Integer> vowels = new HashMap<>();
        int consonantCount = 0;
        long result = 0;

        int[] nextConsonant = new int[n];
        int lastConsonant = n;
        for (int i = n - 1; i >= 0; i--) {
            nextConsonant[i] = lastConsonant;
            if (!isVowel(word.charAt(i))) {
                lastConsonant = i;
            }
        }

        int left = 0, right = 0;
        while (right < n) {
            if (isVowel(word.charAt(right))) {
                vowels.put(word.charAt(right), vowels.getOrDefault(word.charAt(right), 0) + 1);
            } else {
                consonantCount++;
            }

            while (left <= right && consonantCount > k) {
                if (isVowel(word.charAt(left))) {
                    vowels.put(word.charAt(left), vowels.get(word.charAt(left)) - 1);
                    if (vowels.get(word.charAt(left)) == 0) {
                        vowels.remove(word.charAt(left));
                    }
                } else {
                    consonantCount--;
                }
                left++;
            }

            while (left < right && vowels.size() == 5 && consonantCount == k) {
                result += (nextConsonant[right] - right);
                if (isVowel(word.charAt(left))) {
                    vowels.put(word.charAt(left), vowels.get(word.charAt(left)) - 1);
                    if (vowels.get(word.charAt(left)) == 0) {
                        vowels.remove(word.charAt(left));
                    }
                } else {
                    consonantCount--;
                }
                left++;
            }

            right++;
        }

        return result;
    }
}
