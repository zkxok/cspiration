public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0)return null;
        ListNode fast = head;
        ListNode slow = head;       
        for(int i=1;i<k;i++){
            if(fast.next!=null){
                fast = fast.next;
            }else{
                return null;//k大于了链表节点个数     
            }
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

} 
