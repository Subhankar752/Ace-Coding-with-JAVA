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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        
        if(lists.length == 1) {
            return lists[0];
        }
        
        ListNode head = merge(lists[0], lists[1]);
        for(int i = 2 ; i < lists.length ; i++){
            head = merge(head, lists[i]);
        }
        
        return head;
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                head = head.next; 
                l1 = l1.next;
            }
            else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        
        if(l1 == null) {
            head.next = l2;
        }
        
        if(l2 == null) {
            head.next = l1;
        }
        
        return ans.next;
    }
}