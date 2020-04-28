/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 */
public class Day10_MinStack {
    //3ms beats 100%
    class MinStack {

        Node head;

        class Node {
            int val;
            int min;
            Node next;
        }

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            Node temp = new Node();
            temp.val = x;
            if (head == null) {
                head = temp;
                head.min = x;
            } else {
                if (head.min < x) {
                    temp.min = head.min;
                } else {
                    temp.min = x;
                }
                temp.next = head;
                head = temp;
            }
        }

        public void pop() {
            if (head != null) {
                head = head.next;
            }

        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }
}
