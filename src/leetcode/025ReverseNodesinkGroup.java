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
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {//count==k时，才翻转，不等于k时就顺序不变
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {//一次循环只改变一个元素的指针方向
                ListNode temp = head.next;
                head.next = cur;//将下个分组元素指向上一个分组，连接两个两个分组
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
