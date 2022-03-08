/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
         ListNode  slowPointer = head;
		ListNode  fastPointer = head;
		boolean cycle = false;
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			//if there is cycle the will meet at a same point 
			if (slowPointer == fastPointer) {
				cycle = true;
				break;
			}
		}
		return cycle;
    }
}