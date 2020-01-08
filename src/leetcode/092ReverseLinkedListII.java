package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReverseLinkedListII
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 92. Reverse Linked List II
 */
public class ReverseLinkedListII {
    /**
     * For example:
     Given 1->2->3->4->5->NULL, m = 2 and n = 4,

     return 1->4->3->2->5->NULL.

     1->2->3->4->5
     p  c  t


     time : O(n);
     space : O(1);

     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for (int i = 1; i < m; i++) {//遍历m-1次，因为要记录m位置前的指针位置
            cur = cur.next;
            pre = pre.next;
        }
        //()里的部分要看成一个整体来进行交换
        //1->2->3->4->5->NULL, m = 2, n = 4;---> dummy->1->(3->2)->4->5 ;--->dummy->1->[4->(3->2)]->5
        for (int i = 0; i < n - m; i++) {//遍历n-m次
            ListNode temp = cur.next;//cur要和temp交换位置(反转)
            cur.next = temp.next;
            temp.next = pre.next;//不能写成temp.next = cur;的原因:temp要和pre.next这个整体交换，当逆转的元素超过两个，就会出问题
            pre.next = temp;
        }
        return dummy.next;
    }
}
