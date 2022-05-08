class Solution {
    public String largestGoodInteger(String num) {
        ArrayList<String> list = new ArrayList<>();
        list.add("999");
        list.add("888");
        list.add("777");
        list.add("666");
        list.add("555");
        list.add("444");
        list.add("333");
        list.add("222");
        list.add("111");
        list.add("000");
        for(int i = 0 ; i < list.size() ; i++){
            String temp = list.get(i);
            if(num.indexOf(temp) != -1)
                return temp;
        }
        return "";
    }
}