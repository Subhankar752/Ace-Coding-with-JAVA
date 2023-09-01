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
        Node a = p;
        Node b = q;
        
        while(a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        
        return a;
    }
}