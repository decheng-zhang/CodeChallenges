/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode smaller = new ListNode(0); //head
    ListNode larger = new ListNode(0); //head
    ListNode st = smaller; //tail
    ListNode lt = larger; //tail
    
    public ListNode partition(ListNode head, int x) {
        
        ListNode runner = head;
        
        while (runner!=null)
        {
            if (runner.val < x)
            {
                st.next = runner;
                st = st.next;
            }
            else if (runner.val>=x )
            {
                lt.next = runner;
                lt = lt.next;
            }
               
            runner= runner.next;
        }
        
      
        
        lt.next = null;
        st.next = larger.next;
        smaller = smaller.next;
        
        return smaller;
        
        
    }
}
