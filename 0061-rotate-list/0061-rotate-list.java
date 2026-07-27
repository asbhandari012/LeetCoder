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
    public ListNode rotateRight(ListNode head, int k) {
        

        if(head == null || head.next == null || k == 0) return head;

        int length = 1;

        ListNode a = head;

        while(a.next != null){
            a = a.next;
            length++;
        }

        k %= length;
        int count = 0;

        while(count < k){
            ListNode temp = head;
            ListNode tail = head.next;

            while(tail.next != null){
                temp = temp.next;
                tail = tail.next;
            }

            tail.next = head;
            head = tail;
            temp.next = null;
            count++;
        }

        return head;
    }
}