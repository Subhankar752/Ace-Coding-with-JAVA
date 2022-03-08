class Solution {
    public int firstUniqChar(String s) {
        int [] firstAppearIndex = new int [26]; 
        Arrays.fill(firstAppearIndex,-1); // not seen
      
        
        for(int i = 0 ; i < s.length(); i++){
            
            char c = s.charAt(i);
            int pos = c - 'a';
            
            if( firstAppearIndex[pos] == -1 ){ //seeing first time
                
                firstAppearIndex[pos] = i; // i = the pos of this unique char in the string
            }else {
                //already seen, this char is of no interest any more
                //so set this to Integer.MAX_VALUE
                firstAppearIndex[pos] = Integer.MAX_VALUE;
            }
        }
        
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0 ; i < 26; i++){
            
            //IMP otherwise the return value will be always -1
            // use AND !, if its || then return value wil be -1 !
            //if(firstAppearIndex[i] != -1 && firstAppearIndex[i] != Integer.MAX_VALUE){
            
            //keep it simple, MAX_VALUE will be ignored anyway
            if(firstAppearIndex[i] != -1 ){
                
                minIndex = Math.min(minIndex, firstAppearIndex[i]);    
            }
            
        }
        // if minIndex is equal to MAX_VALUE, then there are no unique chars
        return minIndex == Integer.MAX_VALUE? -1: minIndex;
    }
}