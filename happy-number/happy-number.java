class Solution {
    public boolean isHappy(int n) {
        Map<Integer , Integer> map = new HashMap<>();
        while(n != 1) { 
            int sum = 0;
            while(n!=0){
                sum += Math.pow((n%10),2);
                n = n/10;
            }
            n = sum;
            int count = map.getOrDefault(n, 0);
            if(count != 0) {
                return false;
            }else {
                map.put(n, 1);
}
}
return true;
    }
}