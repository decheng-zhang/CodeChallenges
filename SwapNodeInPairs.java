/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode L,R,LL;
        L = head; R = L.next;
        LL = new ListNode(Integer.MAX_VALUE);
        LL.next = head;
        head = head.next;
        while (R!=null)
        {
            L.next = R.next;
            R.next = L;
            LL.next = R;
            if (L.next == null)
                break;
            R = L;
            LL = L;
            L = L.next;
            R = R.next.next;
        }
        
        return head;
    }
}
