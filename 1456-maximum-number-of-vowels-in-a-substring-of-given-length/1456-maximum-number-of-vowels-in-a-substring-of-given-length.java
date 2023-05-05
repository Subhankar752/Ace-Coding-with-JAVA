class Solution {
    public int maxVowels(String s, int k) {
        int[] maxans = new int[1];
         String ref = "aeiou";
         int count = 0;
        
        for(int i = 0 ; i < k ; i++){
             if(ref.contains(s.charAt(i) + "")){
                count++;
            } 
        }
        
        maxans[0] = count;
        int back = 0;
        
        for(int i = k ; i < s.length() ; i++) {
                
             if(ref.contains(s.charAt(i) + "")) {
                count++;
            } 
            
            if(ref.contains(s.charAt(back)+"")){
                count--;  
            }
            
            back++;
             
            if(count > maxans[0])
                maxans[0] = count;
        }

        return maxans[0];

    }
}