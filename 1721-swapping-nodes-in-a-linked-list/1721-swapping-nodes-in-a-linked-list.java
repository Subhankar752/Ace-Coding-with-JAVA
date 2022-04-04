/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null)
        return null;
        
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        for(int i = 1 ; i < k ; i++){
            ptr2 = ptr2.next;
            if(ptr2 == null)
                return null;
        }
        
        ListNode f = ptr2;
        while(ptr2.next != null)
        {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        int t = f.val;
        f.val = ptr1.val;
        ptr1.val = t;
        
        return head;
    }
}