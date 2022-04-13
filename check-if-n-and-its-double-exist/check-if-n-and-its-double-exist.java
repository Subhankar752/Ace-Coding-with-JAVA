class Solution {
    public boolean checkIfExist(int[] arr) {
       HashSet hs = new HashSet();
        for(int i: arr){
            if (hs.contains(i*2) || (i%2==0 && hs.contains(i/2))){
                return true;
            } else {
                hs.add(i);
            }
        }
        return false;
    }
}