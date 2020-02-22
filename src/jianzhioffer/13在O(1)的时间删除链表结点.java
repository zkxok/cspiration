class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        // 思路：新开辟一个节点，作为头结点，然后从这个头结点开始，
        // 找当前节点的下一个是否是要删除的值，找到之后直接删除就好了
        ListNode dummy = new ListNode(-1); 
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.val != val){
            cur = cur.next;
        }
        if (cur.next != null){
            ListNode next = cur.next;
            cur.next = next.next;
            //next.next = null; // help gc
        }
        return dummy.next;
    }
}
