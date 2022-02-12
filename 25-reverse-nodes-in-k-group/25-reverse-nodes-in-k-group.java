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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=k;
        ListNode cur=head;
        ListNode prev=null;
        ListNode next=null;
        while(cur!=null && count-->0){
            next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        int l=0;
        ListNode p=cur;
        while(p!=null){
            l++;
            p=p.next;
        }
        if(next!=null && l>=k)
            head.next = reverseKGroup(cur , k);
        else
            head.next = cur;
        return prev;
    }
}