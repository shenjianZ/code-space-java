package problems;


import Stack.SeqStack;

/*
 * problem：括号匹配
 * author：shenjianZ
 * data：2023-09-21
 */
public class matching {

    public static boolean isMatching(SeqStack<Character> stack, String expr) {
        for (char c : expr.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (!isMatchingChar(top, c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatchingChar(char top, char c) {
        return (top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']');
    }

    public static void main(String[] args) {
        SeqStack<Character> stack = new SeqStack<>();
        String expr = "({[]})";
        String expr1 = "({[])";
        System.out.println(isMatching(stack, expr) ? expr + " 表达式匹配" : expr + "表达式不匹配");
        System.out.println(isMatching(stack, expr1) ? expr1 + " 表达式匹配" : expr1 + "表达式不匹配");
    }
}
