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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = middle(head);
        ListNode second = mid.next;
        mid.next = null;
        return merge(sortList(head) , sortList(second));
    }
    public ListNode middle(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode a , ListNode b){
        ListNode temp = new ListNode(0);
        ListNode fin = temp;
        while(a != null && b != null){
            if(a.val < b.val){
                temp.next = a;
                a = a.next;
            }
            else{
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        temp.next = (a == null) ? b : a;
        return fin.next;
    }
}