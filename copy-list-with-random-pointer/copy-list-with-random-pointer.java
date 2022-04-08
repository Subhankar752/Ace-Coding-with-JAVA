/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node newHead = new Node(-1);
        Node curr = head;
        Node tempHead = newHead;
        while(curr != null)
        {
            Node tempNode = new Node(curr.val);
            tempHead.next = tempNode;
            tempHead = tempHead.next;
            map.put(curr,tempHead);
            curr = curr.next;
        }
        
        curr = head;
        tempHead = newHead.next;
        while(curr != null)
        {
            tempHead.random = map.get(curr.random);
            curr = curr.next;
            tempHead = tempHead.next;
        }
        
        return newHead.next;
    }
}