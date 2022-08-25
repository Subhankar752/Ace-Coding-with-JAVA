class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        int[] b = new int[26];
        
        for(char c : ransomNote.toCharArray()){
            a[c - 97]++;
        }
        for(char c : magazine.toCharArray()){
            b[c - 97]++;
        }
        
        for(int i = 0 ; i < 26 ; i++){
            int v1 = a[i];
            int v2 = b[i];
            
            if(v1 > v2)
                return false;
        }
        return true;
        
    }
}