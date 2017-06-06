/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode h1 = l1;
        ListNode h2 = l2;
        
        ListNode L = new ListNode(0);
        ListNode H = L;
        
        while (h1!=null && h2!=null)
        {
            if (h1.val <= h2.val)
            {
                L.next = h1;
                L = L.next;
                h1 = h1.next;
            }
            else
            {
                L.next = h2;
                L=L.next;
                h2 = h2.next;
            }
        }
        
        while (h1!=null)
        {
            L.next=h1;
            L = L.next;
            h1 = h1.next;
        }
        while (h2!=null)
        {
            L.next=h2;
            L = L.next;
            h2 = h2.next;
        }
        
        H = H.next;
        
        return H;
        
    }
}
