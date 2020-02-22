public class Solution {
    public boolean IsPopOrder(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length == 0) return true;
        Stack<Integer> in = new Stack<>();
        int len = popped.length, index = 0;
        for (int i = 0; i < len; i++) {
            in.push(pushed[i]);
            while (!in.isEmpty() && in.peek() == popped[index]) {
                in.pop();
                index++;
            }
        }
        return in.isEmpty();
    }
}
