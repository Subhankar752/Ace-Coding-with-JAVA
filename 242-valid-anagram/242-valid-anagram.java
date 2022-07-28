class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        String ss=new String(s1);
        String tt=new String(t1);
        return (ss.equals(tt));
    }
}