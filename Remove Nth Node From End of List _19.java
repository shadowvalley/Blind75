/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Remove Nth Node From End of List 
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
    // O(2L - n) where L is the list length = ~O(L)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = length(head);
        int idx = length - n;
        int k = 0;
        ListNode prev = null;


        while(k < idx) {
            prev = curr;
            curr = curr.next;
            k+=1;
        }

        if(prev != null) {
            prev.next = curr.next;
        } else if(prev == null) {
            return head.next;
        }
        return head;
    }

    // O(n)
    public int length(ListNode head) {
        ListNode curr = head;
        int size = 0;
        while(curr != null) {
            curr = curr.next;
            size += 1;
        }

        return size;
    }
}