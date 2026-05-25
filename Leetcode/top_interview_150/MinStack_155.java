package top_interview_150;

import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/min-stack/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinStack_155 {

    class MinStack {

        private TreeMap<Integer, Integer> map;
        private Stack<Integer> stack;

        public MinStack() {
            map = new TreeMap<>();
            stack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        public void pop() {
            int val = stack.pop();
            int count = map.get(val)-1;
            if(count <= 0) {
                map.remove(val);
            } else {
                map.put(val, count);
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return map.keySet().stream().findFirst().get();
        }
    }

}
