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
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode temp = head;
        head = temp.next;
        if(temp!=null && temp.next!=null){
            ListNode temp1 = temp;
            ListNode temp2 = temp.next;
            temp1.next = swapPairs(temp.next.next);
            temp2.next = temp1;
        }
        return head;
    }
}