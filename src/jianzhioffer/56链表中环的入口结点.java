public class LinkedListCycleII {
    /**
     * time : O(n)
     * space : O(1)
     */
    //题解:https://www.cnblogs.com/hiddenfox/p/3408931.html
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {//fast比slow多走一个环的距离
                ListNode slow2 = head;
                while (slow != slow2) {//不管fast绕了多少圈和slow相遇，依然满足这个情况
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
