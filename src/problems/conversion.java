package problems;

import Stack.SeqStack;

public class conversion {
    public static String f(int n, int r) {
        StringBuilder output = new StringBuilder();
        SeqStack<Integer> stack = new SeqStack<>();
        while (n != 0) {
            stack.push(n % r);
            n /= r;
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }

}
