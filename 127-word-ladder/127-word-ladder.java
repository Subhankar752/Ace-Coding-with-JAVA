class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         HashSet<String> set = new HashSet();
        for(String word: wordList){
            set.add(word);
        }
        if(! set.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level=1;
        while(! q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String current_word = q.poll();
                char[] word_chars = current_word.toCharArray();
                for(int j=0;j<word_chars.length;j++){
            char original_char = word_chars[j];
              for(char c='a';c<='z';c++){
                  if(word_chars[j] == c)
                  {
                      continue;
                  }
                  word_chars[j] = c;
                  String new_word = String.valueOf(word_chars);
                  if(new_word.equals(endWord)){
                      return level+1;
                  }
                  if(set.contains(new_word)){
                      q.offer(new_word);
                      set.remove(new_word);
                      System.out.println(new_word);
                      System.out.println(level);
                  }
              }      
                    word_chars[j] = original_char;
                    
                }
            }
            level++;
        }
        return 0;
    }
}