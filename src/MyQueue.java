import java.util.Stack;

// 232. Implement Queue using Stacks
public class MyQueue {
    private Stack<Integer> stack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> tempStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        int target = tempStack.pop();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return target;
    }
    
    /** Get the front element. */
    public int peek() {
        Stack<Integer> tempStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        int target = tempStack.peek();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return target;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
