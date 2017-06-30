/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        int counter = 0;
        
        while (counter < n+1 && fast!=null)
        {
            fast = fast.next;
            counter++;
        }
        while (fast!=null)
        {
            fast= fast.next;
            slow = slow.next;
        }
        System.out.println(counter);
        if (counter<n+1) // slow is at head, represents node to be removed
            {
                head = head.next;
                return head;
            }
        slow.next = slow.next.next;
        
        return head;
    }
}
