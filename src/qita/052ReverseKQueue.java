//反转队列前K个元素
class Solution {
    public static void reverseKQueue(Queue queue, int k) {
        Stack stack = new Stack();
        Queue newQueue = new LinkedList();
        int size = queue.size();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        for (int i = 0; i < size; i++) {
            if (i < k) {
                newQueue.offer(stack.pop());
            } else {
                newQueue.offer(queue.poll());
            }
        }
        // 打印
        while (newQueue.size() > 0) {
            System.out.println(newQueue.poll());
        }
    }
}
