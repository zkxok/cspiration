package leetcode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MergekSortedLists
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 23. Merge k Sorted Lists
 */
public class MergekSortedLists {
    /**
   题解: https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode/
     *(k 是链表的数目,我们可以在 O(n) 的时间内合并两个有序链表，其中 n 是两个链表中的总节点数)
     time : O(nlogk) where k is the number of linked lists
     space : O(n) 


     * @param lists
     * @return
     */
    //分而治之,链表两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = (hi - lo) / 2 + lo;
        ListNode l1 = sort(lists, lo, mid);//递归左边
        ListNode l2 = sort(lists, mid + 1, hi);//递归右边
	//左右分别递归到只有一个节点，然后合并
        return merge(l1, l2);//合并l1和l2
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list : lists) {//遍历链表数组，把每个链表的头结点加入最小堆
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }
     
    //***************上面的注释版**************
    public ListNode mergeKLists3(ListNode[] lists) {
	if (lists == null || lists.length == 0) return null;
	//lists.length是队列元素的容量
	PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
	ListNode dummy = new ListNode(0);
	ListNode cur = dummy;
	for (ListNode head : lists) {// 遍历链表数组，把每个链表的头结点加入最小堆
		if (head != null) {
			queue.offer(head);
		}
	}
	while (!queue.isEmpty()) {
		// dummy,1,2,3,
		// cur =dummy,这里cur.next才是合并数组的首位1,它已经被合并了
		cur.next = queue.poll();// 合并后队列的首元素等于队头元素
		cur = cur.next;// 然后这里cur相同于上面的cur.next=1,1已经加入队列了
		if (cur.next != null) {// 这里需要把1的下一位2也加入队列
			queue.offer(cur.next);
		}
	}
	return dummy.next;
    }
}
