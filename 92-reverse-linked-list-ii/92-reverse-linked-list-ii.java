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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode l = head;
        ListNode r = head;
        
        if(left == 1)
            l = null;
        
        for(int i = 2 ; i < left ; i++){
            l = l.next;
        }
        
        for(int i = 0 ; i < right ; i++){
            r = r.next;
        }
       // System.out.println(l + " " + r);
        int len = right - left + 1;
       
        ListNode cur = head;
        ListNode temp = head;
        
        if(l != null)
        {
            cur = l.next;
            temp = l.next;
        }
       // System.out.println(cur.val + " " + temp.val);
        ListNode prev = null;
        
        while(cur != null && len > 0){
            len--;
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        if(l != null)
            l.next = prev;
        if(r != null)
            temp.next = r;
        
        if(l != null)
            return head;
        
        return prev;
        
    }
}