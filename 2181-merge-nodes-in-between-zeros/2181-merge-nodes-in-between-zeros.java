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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode fin = ans;
        int c = 0;
        int sum = 0;
        while(head != null){
            if(head.val == 0){
                if(sum != 0)
                {
                    ans.next = new ListNode(sum);
                    ans = ans.next;
                    sum = 0;
                }
            }
            else{
                sum += head.val;
            }
            head = head.next;
        }
        return fin.next;
    }
}