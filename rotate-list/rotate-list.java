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
    public ListNode rotateRight(ListNode head, int k) {
         if(head == null || head.next == null) return head;
    
    //Get count
    ListNode temph = head;
    int count = 0;
    while(temph != null){
        count++;
        temph = temph.next;
    }
    
    //If k is same as count or in multiples of count, return same head
    if(k%count == 0) return head;
    
    //To chop off additional value to count and get rotation point
    k = count - (k%count);
            
    //Find new head at rotation point - If k=2, count=5, then we want to find 2nd element, 
    //which will be set to null and next element is our new head
    temph = head;
    while(k > 1){
        temph = temph.next;
        k--;
    }
    
    //Found new head
    ListNode newHead = temph.next;
    
    //Disconnect till new head
    temph.next = null;
    
    //Traverse till end and connect to original head
    temph = newHead;
    while(temph.next !=null){
        temph = temph.next;
    }
    
    //Joining back to original head
    temph.next = head;
    
    return newHead;
    }
}