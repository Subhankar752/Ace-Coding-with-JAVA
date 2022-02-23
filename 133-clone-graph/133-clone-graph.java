/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
   Map<Node,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        dfs(node);
        return map.get(node);
    }
    
    private void dfs(Node curr){
        if(map.containsKey(curr)) return;
        map.put(curr, new Node(curr.val));
        for (Node next: curr.neighbors){
            dfs(next);
            map.get(curr).neighbors.add(map.get(next));
        }   
    }
}