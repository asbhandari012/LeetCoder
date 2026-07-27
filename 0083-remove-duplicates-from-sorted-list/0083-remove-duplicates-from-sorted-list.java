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
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return head;

        ListNode temp = head;
        ListNode jump = head.next;

        while(temp.next != null && jump != null){
            if(temp.val == jump.val){
            temp.next = jump.next;
            jump = jump.next;
        }else{
            temp = temp.next;
            jump = jump.next;
        }
        }
        return head;
    }
}