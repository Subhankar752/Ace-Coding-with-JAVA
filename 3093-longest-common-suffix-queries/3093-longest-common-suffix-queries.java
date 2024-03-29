class Solution {

    class Node {
        Node[] childs;
        boolean isEnd;
        int index;
        int length;

        public Node() {
            childs = new Node[26];
            isEnd = false;
            index = -1;
            length = Integer.MAX_VALUE;
        }
    }

    Node root;
    int minIndex;

    public int[] stringIndices(String[] words, String[] query) {
        root = new Node();

        int len = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.length() < len) {
                minIndex = i;
                len = s.length();
            }
        }

        buildTrie(words);
        int[] ans = new int[query.length];
        int k = 0;

        for (String q : query) {
            StringBuilder qq = new StringBuilder(q);
            qq = qq.reverse();

            String temp = qq.toString();
            ans[k++] = find(temp);
        }

        return ans;
    }

    public int find(String temp) {
        Node cur = root;
        int index = minIndex;

        for (char c : temp.toCharArray()) {
            if (cur.childs[c - 'a'] == null) {
                return index;
            }
            cur = cur.childs[c - 'a'];
            index = cur.index;
        }

        return index;
    }

    public void buildTrie(String[] s) {
        for (int ii = 0; ii < s.length; ii++) {
            String st = s[ii];
            StringBuilder sb = new StringBuilder(st);
            sb = sb.reverse();

            String temp = sb.toString();
            Node cur = root;

            for (int i = 0; i < temp.length(); i++) {
                char ch = temp.charAt(i);

                if (cur.childs[ch - 'a'] == null) {
                    cur.childs[ch - 'a'] = new Node();
                    cur.childs[ch - 'a'].index = ii;
                    cur.childs[ch - 'a'].length = temp.length();
                } else {
                    if (temp.length() < cur.childs[ch - 'a'].length) {
                        cur.childs[ch - 'a'].length = temp.length();
                        cur.childs[ch - 'a'].index = ii;
                    } else if (temp.length() == cur.childs[ch - 'a'].length && ii < cur.childs[ch - 'a'].index) {
                        cur.childs[ch - 'a'].length = temp.length();
                        cur.childs[ch - 'a'].index = ii;
                    }
                }
                cur = cur.childs[ch - 'a'];
                
            }

            cur.isEnd = true;
        }
    }
}
