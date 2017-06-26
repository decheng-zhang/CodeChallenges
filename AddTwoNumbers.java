/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode t1,t2,sol;
        
        sol = new ListNode(-1);
        ListNode curr = sol;
        int digit_sum = 0;
        int carry = 0;
        while (l1!=null && l2 != null)
        {
            digit_sum = l1.val + l2.val+carry;
            carry = digit_sum>=10?1:0;
            digit_sum = digit_sum%10;
            curr.next = new ListNode(digit_sum);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1!=null)
        {
            digit_sum = l1.val + carry;
            carry = digit_sum>=10?1:0;
            digit_sum = digit_sum%10;
            curr.next = new ListNode(digit_sum);
            curr = curr.next;
            l1 = l1.next;
        }
        
        while (l2!=null)
        {
            digit_sum = l2.val + carry;
            carry = digit_sum>=10?1:0;
            digit_sum = digit_sum%10;
            curr.next = new ListNode(digit_sum);
            curr = curr.next;
            l2 = l2.next;
        }
        
        if (carry > 0)
            {
                curr.next = new ListNode(carry);
                curr = curr.next;
            }
        
        sol = sol.next;
        
        return sol;
        
    }
}
