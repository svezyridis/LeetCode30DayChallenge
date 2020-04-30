import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache(2 (capacity));
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

public class Day24_LRUCache {
    //11ms beats 99.9%
    class LRUCache {
        HashMap<Integer, Node> map;
        Node head;
        Node last;
        int size;
        int capacity;

        class Node {
            int key;
            int val;
            Node prev;
            Node next;
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap(4,0.8f);
        }

        public int get(int key) {
            System.out.println("get " + key);
            if (map.containsKey(key)) {
                Node node = map.get(key);
                if (node == head) return node.val;
                node.prev.next = node.next;
                if (node != last) node.next.prev = node.prev;
                else last = last.prev;
                node.next = head;
                head.prev = node;
                head = node;
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            System.out.println("put " + key);
            if (!map.containsKey(key)) {
                Node node = new Node();
                node.key = key;
                node.val = value;
                if (head == null) {
                    head = node;
                    last = head;
                } else {
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
                map.put(key, node);
                if (size < capacity)
                    size++;
                else {
                    System.out.println(key);
                    System.out.println(last.key);
                    map.remove(last.key);
                    System.out.println(map.containsKey(last.key));
                    last = last.prev;
                    last.next = null;
                    System.out.println(last.key);
                }


            } else {
                Node node = map.get(key);
                node.val = value;
                if (node == head) return;
                node.prev.next = node.next;
                if (node != last) node.next.prev = node.prev;
                else last = last.prev;
                node.next = head;
                head.prev = node;
                head = node;
            }
        }
    }
}
