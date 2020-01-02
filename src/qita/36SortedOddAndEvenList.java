/**
 * 单链表奇数递增偶数递减，使之升序 分三步： 1.拆分成2个链表 2.对逆序的链表反转 3.合并2个链表
 */
public class SortedOddAndEvenList {
    // 首先根据奇数位和偶数位拆分成两个链表。
    //
    // 然后对偶数链表进行反转。
    //
    // 最后将两个有序链表进行合并。

    // 这一步注意细节
    public ListNode[] getTwoList(ListNode head) {
        if (head == null || head.next == null) return null;// 至少要有两个节点
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode next1 = null;
        ListNode next2 = null;
        while (head != null && head.next != null) {
            next1 = head.next.next;// l1的next,不直接等于l2.next是因为,l2遍历过程中无更新
            next2 = head.next;// l2
            head.next = next1;
            next2.next = next1 == null ? null : next1.next;
            head = next1;// l1向后遍历
        }
        return new ListNode[] { l1, l2 };
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

    public ListNode sortLinkedList(ListNode head) {
        ListNode[] twoList = getTwoList(head);// 拆分链表
        ListNode l1 = twoList[0];
        ListNode l2 = reverse(twoList[1]);// 翻转l2
        ListNode res = mergeListNode(l1, l2);// 合并l1,l2
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(3);
        ListNode l9 = new ListNode(8);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;

        ListNode res = new SortedOddAndEvenList().sortLinkedList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}

class ListNode {
    int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
