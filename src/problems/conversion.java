package problems;

import Stack.SeqStack;

import java.util.Scanner;

/*
 * problem：数值转换
 * author：shenjianZ
 * data：2023-09-21
 */
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个十进制数：");
        int n = sc.nextInt();
        System.out.println("请输入你的目标进制：");
        int r = sc.nextInt();
        System.out.println(f(n, r));
    }
}
