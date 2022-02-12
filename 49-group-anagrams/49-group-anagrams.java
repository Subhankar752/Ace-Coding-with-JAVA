class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String temp=new String(ch);
            if(map.containsKey(temp)){
                List<String> list=map.get(temp);
                list.add(s);
                map.put(temp,list);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(temp,list);  
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,List<String>> m:map.entrySet()){
            List<String> val=m.getValue();
            ans.add(val);
        }
        return ans;
    }
}