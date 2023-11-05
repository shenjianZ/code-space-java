package Tree;

import java.util.Stack;


public class BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        c.left = null;
        d.left = d.right = null;
        e.left = e.right = null;
        f.left = f.right = null;

        preOrder(a);
        System.out.println();
        inOrder(a);
        System.out.println();
        postOrder(a);
    }

    /**
     * //递归写法
     * static void preOrder(TreeNode root) {
     * if (root == null) return;
     * System.out.print(root.element);
     * preOrder(root.left);
     * preOrder(root.right);
     * }
     * <p>
     * //递归写法
     * static void inOrder(TreeNode root) {
     * if (root == null) return;
     * inOrder(root.left);
     * System.out.print(root.element);
     * inOrder(root.right);
     * }
     * <p>
     * //递归写法
     * static void postOrder(TreeNode root) {
     * if (root == null) return;
     * postOrder(root.left);
     * postOrder(root.right);
     * System.out.print(root.element);
     * }
     */
    //非递归写法
    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.element);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    //非递归写法
    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.element);
                root = root.right;
            }
        }
    }

    //非递归写法
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root.flag = 0;
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.peek();
                if (root.flag == 0) {
                    root.flag = 1;
                    root = root.right;
                } else {
                    System.out.print(root.element);
                    stack.pop();
                    root = null;
                }
            }
        }
    }

    public static class TreeNode {
        char element;
        TreeNode left;
        TreeNode right;
        int flag;

        public TreeNode(char element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.flag = 0;
        }
    }
}