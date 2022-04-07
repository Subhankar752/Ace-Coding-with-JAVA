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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode fin = ans;
        while(l1 != null && l2 != null){
            int a = l1.val;
            int b = l2.val;
            int m = a + b + carry;
            sum = m % 10;
            ListNode n = new ListNode(sum);
            ans.next = n;
            ans = ans.next;
            carry = m/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int m = l1.val + carry;
            sum = m%10;
            carry = m/10;
            ans.next = new ListNode(sum);
            ans = ans.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int m = l2.val + carry;
            sum = m%10;
            carry = m/10;
            ans.next = new ListNode(sum);
            ans = ans.next;
            l2 = l2.next;
        }
        if(carry > 0)
            ans.next = new ListNode(carry);
        
        return fin.next;
    }
}