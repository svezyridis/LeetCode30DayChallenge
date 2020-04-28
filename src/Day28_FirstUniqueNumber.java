import java.util.HashMap;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * <p>
 * Implement the FirstUnique class:
 * <p>
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value) insert value to the queue.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 * <p>
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 * 1 <= value <= 10^8
 * At most 50000 calls will be made to showFirstUnique and add.
 */
public class Day28_FirstUniqueNumber {
    //109 ms not enough submitted solutions for rank
    class FirstUnique {
        HashMap<Integer, Node> map;
        Node head;
        Node last;

        class Node {
            int val;
            Node prev;
            Node next;
        }

        public FirstUnique(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    Node node = new Node();
                    node.val = nums[i];
                    if (head == null) {
                        head = node;
                        last = head;
                    } else {
                        node.prev = last;
                        last.next = node;
                        last = node;
                    }
                    map.put(nums[i], node);
                } else {
                    Node node = map.get(nums[i]);
                    if (node == null) continue;
                    if (node != head) node.prev.next = node.next;
                    else head = head.next;
                    if (node != last) node.next.prev = node.prev;
                    else last = last.prev;
                    map.put(nums[i], null);
                }
            }
        }

        public int showFirstUnique() {
            if (head == null) return -1;
            return head.val;
        }

        public void add(int value) {
            if (!map.containsKey(value)) {
                Node node = new Node();
                node.val = value;
                if (head == null) {
                    head = node;
                    last = head;
                } else {
                    node.prev = last;
                    last.next = node;
                    last = node;
                }
                map.put(value, node);
            } else {
                Node node = map.get(value);
                if (node == null) return;
                if (node != head) node.prev.next = node.next;
                else head = head.next;
                if (node != last) node.next.prev = node.prev;
                else last = last.prev;
                map.put(value, null);
            }
        }

    }

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
}
