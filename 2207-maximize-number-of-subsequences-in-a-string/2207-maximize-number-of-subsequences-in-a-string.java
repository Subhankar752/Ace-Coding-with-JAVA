class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        // long left = 0;
        // long right = 0;
        // char c1 = pattern.charAt(0);
        // char c2 = pattern.charAt(1);
        // String l1 = c1 + text;
        // String l2 = text + c2;
        // for(int i = 0 ; i < l1.length() ; i++){
        //     char ch = l1.charAt(i);
        //     if(ch == c1)
        //         left++;
        //     if(ch == c2)
        //         right++;
        // }
        // long temp1 = (left) * right;
        // left = 0L;
        // right = 0L;
        // for(int i = 0 ; i < l2.length() ; i++){
        //     char ch = l2.charAt(i);
        //     if(ch == c1)
        //         left++;
        //     if(ch == c2)
        //         right++;
        // }
        // long temp2 = left * (right);
        // return Math.max(temp1 , temp2);
        // choice1: place p0 at the start
        long choice1 = 0;
        int countOfP0 = 1;
        for (int i = 0; i < text.length(); i++)
        {
            // if p1 found, it can be paired with all the p0's found till now
            if (text.charAt(i) == pattern.charAt(1)) choice1 += countOfP0;
            if (text.charAt(i) == pattern.charAt(0)) countOfP0++;
        }
        
        // choice2: place p1 at the end
        long choice2 = 0;
        int countOfP1 = 1;
        for (int i = text.length() - 1; i >= 0; i--) 
        {
            // if p0 found, it can be paired with all the p1's found till now 
            if (text.charAt(i) == pattern.charAt(0)) choice2 += countOfP1;
            if (text.charAt(i) == pattern.charAt(1)) countOfP1++;
        }
        
        return Math.max(choice1, choice2);
    }
}