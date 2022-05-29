class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        
        for (int i=0; i<n; i++)
            for (char c: words[i].toCharArray())
                masks[i] |= (1 << (c - 'a'));
        
        int largest = 0;
        for (int i=0; i<n; i++) 
            for (int j=0; j<n; j++) 
                if (i != j && (masks[i] & masks[j]) == 0) 
					largest = Math.max(largest, words[i].length() * words[j].length());
        
        return largest;
    }
}