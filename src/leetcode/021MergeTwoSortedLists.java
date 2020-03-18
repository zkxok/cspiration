package leetcode;

public class MergeTwoSortedLists {
    /**
     * 21. Merge Two Sorted Lists
     * Merge two sorted linked lists and return it as a new list. The new list should be made
     * by splicing together the nodes of the first two lists.

     time : O(n);
     space :O(1) / O(n);
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);//=l1,不用new 新节点
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);//=l2,不用new 新节点
                l2= l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {//递归写法
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
    
   public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next =l1;
                l1 = l1.next;
            } else {
                cur.next =l2;
                l2= l2.next;
            }
            cur = cur.next;
        }
        // 任一为空，直接连接另一条链表
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }
    //猿辅导面试题(没写出):
    //扩展:单向不递减链表，归并并且删除有重复的节点
	1-2-3-4-4-5-8
	2-5-6-7
	 // 结果1:
	1-3-6-7-8
        // 结果2:
	1-2-3-4-5-6-7-8	
    //结果1解法:先合并再去重LC21 + LC82
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 任一为空，直接连接另一条链表
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return deleteDuplicates1(dummy.next);
    }
    
    public static ListNode deleteDuplicates1(ListNode head) {//重复元素全部去除
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
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
    **********
    //结果2解法2:先合并再去重LC21 + LC83
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        l1 = deleteDuplicates2(l1);
        l2 = deleteDuplicates2(l2);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {// 相同元素只保留一个
                cur.next = l2;
                l1 = l1.next;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 任一为空，直接连接另一条链表
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {//重复元素保留1个
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
    ******
    //结果2解法2:先合并再去重LC21 + LC83
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            } 
            cur = cur.next;
        }
        // 任一为空，直接连接另一条链表
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return deleteDuplicates2(dummy.next);
    }

    public static ListNode deleteDuplicates2(ListNode head) {//重复元素保留1个
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
	
}
