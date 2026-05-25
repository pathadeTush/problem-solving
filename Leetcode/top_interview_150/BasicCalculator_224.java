package top_interview_150;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BasicCalculator_224 {

    private enum NodeTypeEnum {
        OPERAND,
        OPERATOR,
        PARANTHESIS;
    }

    private enum OperatorEnum {
        ADD,
        SUBTRACT;
    }

    private static class Node {

        private NodeTypeEnum type;
        private long value;
        private boolean open;
        private OperatorEnum operator;

        public void setType(NodeTypeEnum type) {
            this.type = type;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public void setOpen(boolean open) {
            this.open = open;
        }

        public void setOperator(OperatorEnum operator) {
            this.operator = operator;
        }

        public NodeTypeEnum getType() {
            return type;
        }

        public long getValue() {
            return value;
        }

        public boolean isOpen() {
            return open;
        }

        public OperatorEnum getOperator() {
            return operator;
        }
    }

    public static int calculate(String s) {
        int n = s.length();
        int i = 0;

        Stack<Node> stack = new Stack<>();
        while (i < n) {
            char ch = s.charAt(i);
            switch (ch) {
                case ' ':
                    break;
                case '+': {
                    if (canPushOperator(stack)) {
                        Node node = new Node();
                        node.setType(NodeTypeEnum.OPERATOR);
                        node.setOperator(OperatorEnum.ADD);
                        stack.push(node);
                        break;
                    }
                    return -1;
                }
                case '-': {
                    if (canPushOperator(stack)) {
                        Node node = new Node();
                        node.setType(NodeTypeEnum.OPERATOR);
                        node.setOperator(OperatorEnum.SUBTRACT);
                        stack.push(node);
                        break;
                    }

                    return -1;
                }
                case '(': {
                    Node node = new Node();
                    node.setType(NodeTypeEnum.PARANTHESIS);
                    node.setOpen(true);
                    stack.push(node);
                    break;
                }
                case ')': {
                    Node ans = null;
                    while (!stack.isEmpty() && !(stack.peek().getType().equals(NodeTypeEnum.PARANTHESIS) && stack.peek().isOpen())) {
                        ans = stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    if (ans != null) {
                        solveAndPush(stack, ans.getValue());
                    }
                    break;
                }
                default: {
                    StringBuffer number = new StringBuffer();
                    number.append(ch);
                    while (i + 1 < n && isNumber(s.charAt(i + 1))) {
                        number.append(s.charAt(i + 1));
                        i++;
                    }
                    solveAndPush(stack, Long.parseLong(number.toString()));
                    break;
                }
            }
            i++;
        }


        return (int) stack.peek().getValue();
    }

    private static boolean isNumber(char ch) {
        return switch (ch) {
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                yield true;
            default:
                yield false;
        };
    }

    private static boolean canPushOperator(Stack<Node> stack) {
        return stack.isEmpty() || stack.peek().getType().equals(NodeTypeEnum.OPERAND) || stack.peek().getType().equals(NodeTypeEnum.PARANTHESIS);
    }

    private static void solveAndPush(Stack<Node> stack, long number) {
        if (!stack.isEmpty() && stack.peek().getType().equals(NodeTypeEnum.OPERATOR)) {
            Node operator = stack.pop();
            if (stack.isEmpty()) {
                if (operator.getOperator().equals(OperatorEnum.SUBTRACT)) {
                    solveAndPush(stack, -number);
                } else {
                    solveAndPush(stack, number);
                }
            }
            else {
                Node operand = stack.pop();
                long ans = 0;
                if (operator.getOperator().equals(OperatorEnum.ADD)) {
                    ans = operand.getValue() + number;
                } else {
                    ans = operand.getValue() - number;
                }
                solveAndPush(stack, ans);
            }
        } else {
            Node node = new Node();
            node.setType(NodeTypeEnum.OPERAND);
            node.setValue(number);
            stack.push(node);
        }
    }

    public static void main(String[] args) {
//        String s = "(1+(4+5+2)-3)+(6+8)";
//        System.out.println(BasicCalculator_224.calculate(s));
//        String s = "- (3 + (4 + 5))";
//        System.out.println(BasicCalculator_224.calculate(s));
        String s = "-2147483648";
        System.out.println(BasicCalculator_224.calculate(s));
    }

}
