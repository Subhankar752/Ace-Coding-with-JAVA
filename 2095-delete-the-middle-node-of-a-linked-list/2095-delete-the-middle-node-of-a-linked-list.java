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
    public ListNode deleteMiddle(ListNode head) {
        int len = 0;
        if(head.next == null)
            return null;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int mid = len/2;
        ListNode prev = null;
        int c = 0;
        temp = head;
        while(c < mid){
            prev = temp;
            temp = temp.next;
            c++;
        }
        prev.next = temp.next;
        return head;
    }
}