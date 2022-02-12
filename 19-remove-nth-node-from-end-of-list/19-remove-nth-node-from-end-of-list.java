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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        // if(head.next==null)
        //     return null;
        ListNode ptr1=head;
        ListNode ptr2=head;
        for(int i=1;i<n;i++){
            ptr2=ptr2.next;
            if(ptr2==null)
                return head;
        }
    
    ListNode prev=null;
    while(ptr2.next!=null){
        prev=ptr1;
        ptr1=ptr1.next;
        ptr2=ptr2.next;
    }
        if(prev==null)
            return head.next;
    prev.next=ptr1.next;
    return head;
}
}