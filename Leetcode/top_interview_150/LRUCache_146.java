package top_interview_150;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/?envType=study-plan-v2&envId=top-interview-150
 */
public class LRUCache_146 {

    static class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {

        private int capacity;
        private Map<Integer, Node> mp;
        private Node head = null;
        private Node last = null;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            mp = new HashMap<>();
        }

        private void print() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.key + "-" + curr.value + " | ");
                curr = curr.next;
            }
            System.out.println();
        }

        public int get(int key) {
            if (mp.containsKey(key)) {
                Node node = mp.get(key);
                moveNodeToFront(node);
                print();

                return node.value;
            }

            return -1;
        }

        public void put(int key, int value) {
            if (mp.containsKey(key)) {
                Node node = mp.get(key);
                node.value = value;
                mp.put(key, node);

                moveNodeToFront(node);
            } else {
                if (mp.size() >= capacity) {
                   evictNode();
                }

                // put node in front
                Node node = new Node(key, value);
                insertNodeAtFront(node);
            }

            print();
        }

        private boolean isNodeHead(Node node) {
            return head == node;
        }

        private boolean isNodeLast(Node node) {
            return last == node;
        }

        private void moveNodeToFront(Node node) {
            if (isNodeHead(node)) {
                return;
            }

            // update last
            if(isNodeLast(node)) {
                last = node.prev;
            }

            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }

            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        }

        private void insertNodeAtFront(Node node) {
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if (last == null) {
                last = node;
            }

            mp.put(node.key, node);
        }

        private void evictNode() {
            if (last == null) {
                return;
            }
            Node nodeToEvict = last;
            last = last.prev;
            if (isNodeHead(nodeToEvict)) {
                head = null;
            }
            mp.remove(nodeToEvict.key, nodeToEvict);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        lruCache.get(2);
        lruCache.put(3, 2);
        lruCache.get(2);
        lruCache.get(3);
    }

}
