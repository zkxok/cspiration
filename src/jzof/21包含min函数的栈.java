class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(x<min()){
            min.push(x);
        }else{
            min.push(min());
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int min() {
        if(min.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return min.peek();
    }
}
