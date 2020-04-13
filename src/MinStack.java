import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        //keep min value as a buffer and add it to the stack when the new value is less than min
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        //if pop operation could result in the changing of the current minimum value, 
        //pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    /*
    I tried a previous version which I couldn't get to work, but basically instead of using
    the min as a buffer, I added 2*min - x to the stack and kept min as the actual value. That
    way, when I pop the minimum value, I can check to see if x < min, and then reassign min after popping.
    Looked to the discussions for this more efficient, smarter solution.

    Runtime: 4 ms, faster than 90.06% of Java online submissions for Min Stack.
    Memory Usage: 41.1 MB, less than 16.67% of Java online submissions for Min Stack.
     */
}