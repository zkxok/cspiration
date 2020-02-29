public class ReverseLinkedList {
     //time : O(n);
     //space : O(1);
    public static ListNode reverseList(ListNode head) {
        //if(head==null) return head;这样写也行，下面一行注释掉也行
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

}
