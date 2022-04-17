class Solution {
    public String reverseWords(String s) {
        ArrayList<String> str = new ArrayList<>();
        String temp = "";
        s = s.trim();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                if(temp.length() != 0)
                {
                    str.add(temp);
                    temp = "";
                }
            }
            else{
                temp = temp + ch;
            }
        }
        if(temp.length() != 0)
            str.add(temp);
        
        for(String i : str)
            System.out.println(i);
        
        
        String res = " ";
        for( int i = str.size() - 1; i >= 0; i--){
            res +=str.get(i) + " ";
        }
        return res.trim();
    }
}