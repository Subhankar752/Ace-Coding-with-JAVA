class Encrypter {
    HashMap<Character , String> map = new HashMap<>();
    HashMap<String , Integer> freq = new HashMap<>();
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        map = new HashMap<>();
        freq = new HashMap<>();
        for(int i = 0 ; i < keys.length ; i++){
            map.put(keys[i] , values[i]);
        }
        for(String s : dictionary){
            String x = encrypt(s);
            if(freq.containsKey(x)){
                freq.put(x , freq.get(x) + 1);
            }
            else{
                freq.put(x , 1);
            }
        }
    }
    
    public String encrypt(String word1) {
        String ans = "";
        for(char c : word1.toCharArray()){
            ans += map.get(c);
        }
        return ans;
    }
    
    public int decrypt(String word2) {
        if(freq.containsKey(word2)){
            return freq.get(word2);
        }
        else{
            return 0;
        }
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */