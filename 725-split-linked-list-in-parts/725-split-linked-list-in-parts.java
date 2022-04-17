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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] answer = new ListNode[k];
        if(k == 1) {
            answer[0] = head;
        } else {
            int n = getListLength(head);
            ListNode previous = null;
            for(int i = 0 ; i < k ; i++) {
                answer[i] = head;
                int j = n / k + (i < (n%k) ? 1 : 0);
                while(head != null && j > 0) {
                    previous = head;
                    head = head.next;
                    j--;
                }
                if(previous != null) {
                    previous.next = null;
                }   
            }
        }
        return answer;
    }

    public int getListLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
