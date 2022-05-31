class Solution {
    public boolean digitCount(String num) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(char c : num.toCharArray()){
            int x = Character.getNumericValue(c);
            if(map.containsKey(x)){
                map.put(x , map.get(x) + 1);
            }
            else{
                map.put(x , 1);
            }
        }
        for(int i = 0 ; i < num.length() ; i++){
            int val = Character.getNumericValue(num.charAt(i));
            int x = 0;
            if(map.containsKey(i)){
                x = map.get(i);
            }
            if(x != val)
                return false;
        }
        return true;
    }
}