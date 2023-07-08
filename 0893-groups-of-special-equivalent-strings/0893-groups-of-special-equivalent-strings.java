class Solution {

    public int numSpecialEquivGroups(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            StringBuilder sortedString = new StringBuilder();
            StringBuilder evenList = new StringBuilder();
            StringBuilder oddList = new StringBuilder();
            
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    evenList.append(word.charAt(i));
                } else {
                    oddList.append(word.charAt(i));
                }
            }
            
            char evenArray[] = evenList.toString().toCharArray();
            
            Arrays.sort(evenArray);
            sortedString.append(evenArray);
            
            char oddArray[] = oddList.toString().toCharArray();
            
            Arrays.sort(oddArray);
            
            sortedString.append(oddArray);
            list.add(sortedString.toString());
        }
        
        return (int) list.stream().distinct().count();
    }
}
