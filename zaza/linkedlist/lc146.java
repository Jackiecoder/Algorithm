package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class lc146 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class LRUCache {
        Map<Integer, Node> hashMap;
        Node head;
        Node tail;
        int capacity;

        public class Node {
            int key;
            int val;
            Node next;
            Node pre;

            public Node(){}

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                next = null;
                pre = null;
            }
        }

        public LRUCache(int capacity) {
            hashMap = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
        }

        private void addNode(Node n) {
            n.next = head.next;
            n.pre = head;
            head.next = n;
            n.next.pre = n;
        }

        private Node removeNode(Node n) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
            return n;
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                int val = hashMap.get(key).val;
                addNode(removeNode(hashMap.get(key)));
                return val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                hashMap.get(key).val = value;
                addNode(removeNode(hashMap.get(key)));
            } else {
                Node newNode = new Node(key, value);
                addNode(newNode);
                hashMap.put(key, newNode);
                if (hashMap.size() > capacity) {
                    hashMap.remove(tail.pre.key);
                    removeNode(tail.pre);
                }
            }
        }
    }
}

//class LRUCache extends LinkedHashMap<Integer, Integer>{
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }
//}
//
///**
// * Your LRUCache object will be instantiated and called as such:
// * LRUCache obj = new LRUCache(capacity);
// * int param_1 = obj.get(key);
// * obj.put(key,value);
// */
