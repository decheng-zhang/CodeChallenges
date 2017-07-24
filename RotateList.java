/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int length = 1;
        ListNode temp = head;
        
        while (temp.next!=null)
        {
            temp = temp.next;
            length+=1;
        }
        int rotations = k%length;
        if (rotations==0)
            return head;
        ListNode leading,trailing;
        leading = trailing = head;
        for (int i=0;i<rotations;i++)
            leading = leading.next;
        while (leading.next!=null)
        {
            leading = leading.next;
            trailing = trailing.next;
        }
        
        leading.next = head;
        head = trailing.next;
        trailing.next = null;
        
        return head;
    }
}
