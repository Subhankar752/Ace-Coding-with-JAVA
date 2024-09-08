class Solution {

    public String convertDateToBinary(String date) {
        String[] d = date.split("-");
        String ans = "";

        for (String i : d) {
            ans = ans + Integer.toBinaryString(Integer.parseInt(i)) + "-";
        }

        return ans.substring(0, ans.length() - 1);
    }
}
