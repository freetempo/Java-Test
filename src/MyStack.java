// 225. Implement Stack using Queues

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue;
    
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> tempQueue = new LinkedList<Integer>();
        int res = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!queue.isEmpty()) {
                tempQueue.offer(temp);
            } else {
                res = temp;
            }
        }
        
        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        Queue<Integer> tempQueue = new LinkedList<Integer>();
        int res = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            tempQueue.offer(temp);
            if (queue.isEmpty()) {
                res = temp;
            }
        }
        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */