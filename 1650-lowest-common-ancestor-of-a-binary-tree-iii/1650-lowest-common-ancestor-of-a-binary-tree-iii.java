/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        while(p != null) {
            s1.push(p);
            p = p.parent;
        }
        
        while(q != null) {
            s2.push(q);
            q = q.parent;
        }
        Node res = null;
        while(!s1.isEmpty() && !s2.isEmpty()) {
            Node a = s1.pop();
            Node b = s2.pop();
            
            if(a == b)
                res = a;;
        }
        
        return res;
//         Node a = p;
//         Node b = q;
        
//         while(a != b) {
//             a = a == null ? q : a.parent;
//             b = b == null ? p : b.parent;
//         }
        
//         return a;
    }
}