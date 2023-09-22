package problems;

import Stack.SeqStack;


public class evaluation {
    public static int evaluateExpression(String expr) {
        SeqStack<Integer> values = new SeqStack<>();
        SeqStack<Character> operators = new SeqStack<>();
        //遍历expr的每一个字符
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            //c 为数字，则将连续的数字压入数值栈
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num.append(expr.charAt(i));
                    i++;
                }
                //退回以便处理之后的字符
                i--;
                //将数值压入栈帧
                values.push(Integer.parseInt(num.toString()));
            } else if (c == '(') {
                // ( 压入运算符栈
                operators.push(c);
            } else if (c == ')') {
                // 产看运算符栈是否为空，若不为空，则运算栈中运算符逐个取出，进行计算
                while (!operators.isEmpty() && operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                //将 ) 弹出运算符栈
                operators.pop();
            } else if (isOperator(c)) {
                // 如果是运算符，弹出优先级大于或等于当前运算符的运算符，那么就取出数值栈的数字逐个计算
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                //运算符不为空或当前运算符栈的栈顶运算符优先级较低，就将 c 这个更高优先级的运算符入栈
                operators.push(c);
            }
        }
        // 如果运算符栈不为空，取出数值栈的数字逐个计算
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }
        // 返回数值栈栈最后元素，values栈中最后剩下的元素就是表达式的值
        return values.pop();
    }

    /*
     * 判断是否为运算符
     *
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /*
     * 判断运算符优先级
     *
     */
    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    /*
     * 计算表达式结果
     *
     */
    private static int applyOperator(char operator, int operand2, int operand1) {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> throw new IllegalArgumentException("无效运算符");
        };
    }

    public static void main(String[] args) {
        String expr = "(6*7-3)+5+6-2"; // 表达式示例
        int result = evaluateExpression(expr);
        System.out.println("表达式 " + expr + " 的值是 " + result);
    }
}
