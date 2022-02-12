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
        ArrayList<Integer> list = new ArrayList<>();
        for(ListNode l : lists){
            while(l != null){
                list.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(list);
        ListNode res = new ListNode(0);
        ListNode ans = res;
        for(int i : list){
            res.next = new ListNode(i);
            res = res.next;
        }
        return ans.next;
    }
}