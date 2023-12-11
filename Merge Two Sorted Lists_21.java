/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Merge Two Sorted Lists
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
    //TC -> O(N+M) N & M are the size of the two lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h1 = list1;
        ListNode h2 = list2;
        ListNode nhead = new ListNode(-1);
        ListNode temp = nhead;

        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                temp.next = h1;
                temp = temp.next;
                h1 = h1.next;
            } else {
                temp.next = h2;
                temp = temp.next;
                h2 = h2.next;
            }


        }

        if(h1 != null) {
            temp.next = h1;
        }

        if(h2 != null) {
            temp.next = h2;
        }

        return nhead.next;
    }
}
