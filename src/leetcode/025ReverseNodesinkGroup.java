package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReverseNodesinkGroup
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 25. Reverse Nodes in k-Group
 */
public class ReverseNodesinkGroup {
    /**
     * For example,
     Given this linked list: 1->2->3->4->5

     For k = 2, you should return: 2->1->4->3->5

     For k = 3, you should return: 3->2->1->4->5

     2->1->4->3->5 k = 2

     time : O(n)
     space : O(n)

     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;//(0)
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {//（1）
            cur = cur.next;
            count++;
        }
        if (count == k) {//count==k时，才翻转，不等于k时就顺序不变
            cur = reverseKGroup(cur, k);//翻转/未足k位未翻转的链表的头结点
            while (count-- > 0) {//一次循环只改变一个元素的指针方向
                ListNode temp = head.next;
                head.next = cur;//到尾时,将当前分组元素指向下一个分组，连接两个分组(只是分组内)
                cur = head;
                head = temp;
            }
            head = cur;
        }
        //count!=k的时候，直接return head了，不能返回cur,因为cur发生了1处的遍历后移,
        //为啥会有2处的情况，因为链表元素数是k的整数倍时,是不存在count!=k的时候的,链表元素数-1是k的整数倍时，在0处就已经返回了head,不会发生后面的cur后移
        return head;//cur,只要链表元素个数是k的整数倍或者链表元素数-1是k的整数倍，返回cur都是对的(2)
    }
}
