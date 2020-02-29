public class RemoveDuplicatesfromSortedListII {
      //Given 0->1->2->3->3->4->4->5, return 1->2->5.
     //Given 0->1->1->1->2->3, return 2->3.
     //time : O(n);
     //space : O(1);
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next !=null) {
            if (p.next.val == p.next.next.val) {
                int sameNum = p.next.val;
                while (p.next != null && p.next.val == sameNum) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
