/**
 * https://leetcode.com/problems/reorder-list/description/
 * Reorder List
 */

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
    // TC -> O(n)
    
    public void reorderList(ListNode head) {
        // 1. Find middle of the Link List
        ListNode middle = findMiddle(head);
        ListNode nhead = middle.next;
        middle.next = null;

        // Step 2 -> Reverse the second Link List
        ListNode reversedLL = reverseLL(nhead);

        // Step 3 -> Merge the 2 LL alternately
        ListNode l1 = head;
        ListNode l2 = reversedLL;
        ListNode n1 = null;
        ListNode n2 = null;

        while(l1 != null && l2 != null) {
            n1 = l1.next;
            n2 = l2.next;
            l1.next = l2;
            l2.next = n1;

            l1 = n1;
            l2 = n2;
        }
    }

    ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}