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
        int i=1;
        ListNode temp=head;
        ListNode l=null;
        ListNode r=null;
        while(temp!=null){
            if(i==left)
                l=temp;
            if(i == right)
                r=temp;
            i++;
            temp=temp.next;
        }
        int k = right - left + 1;
        ListNode lprev=null;
        temp=head;
        while(temp!=l){
            lprev=temp;
            temp=temp.next;
        }
        ListNode rnext=null;
        if(r.next!=null)
            rnext=r.next;
        
        ListNode cur=l;
        ListNode head1 = l;
        ListNode prev = null;
        ListNode next=null;
        while(cur!=null && k-->0){
            next= cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        if(lprev != null){
            lprev.next = prev;
            l.next=rnext;
            return head;
        }
        else{
            l.next=rnext;
        
        return prev;
        }
        
        
        
        
//         if(left == right) return head;
//         ListNode l = null, r = null;
//         ListNode temp = head;
//         int i = 1;  
//         while(temp != null){
//             if(i == left){
//                 l = temp;
//             }
//             if(i == right){
//                 r = temp;
//             }
//             temp = temp.next;
//             i++;
//         }
//         temp = head;
//         ListNode prev = null;
//         while(temp != l){
//             prev = temp;
//             temp = temp.next;
//         }
//         if(prev != null){
//             prev.next = r;
//         }
//         else{
//             head = r;
//         }
//         ListNode next = temp.next;
//         while(temp != r){
//             prev = temp;
//             temp = next;
//             next = next.next;
//             temp.next = prev;
//         }
//         l.next = next;
        
//         return head;
        
    }
}