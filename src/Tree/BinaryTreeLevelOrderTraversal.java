package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        // 创建二叉树节点
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');

        // 构建二叉树结构
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        c.left = null;
        d.left = d.right = null;
        e.left = e.right = null;
        f.left = f.right = null;

        // 层序遍历
        levelOrder(a);
    }

    /**
     * 层序遍历二叉树并打印节点的元素值。
     * 使用队列实现。
     *
     * @param root 二叉树的根节点指针
     */
    static void levelOrder(TreeNode root) {
        // 创建队列用于层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点入队
        queue.offer(root);

        // 执行层序遍历
        while (!queue.isEmpty()) {
            // 出队队头节点
            TreeNode node = queue.poll();
            // 打印当前节点的元素值
            System.out.print(node.element);

            // 如果左子树不为空，入队左子树
            if (node.left != null) {
                queue.offer(node.left);
            }
            // 如果右子树不为空，入队右子树
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static class TreeNode {
        char element;  // 存放元素
        TreeNode left;  // 指向左子树的指针
        TreeNode right;  // 指向右子树的指针
        int flag;  // 辅助后序遍历进行，0表示左子树遍历完成，1表示右子树遍历完成

        // 带有参数的构造函数
        public TreeNode(char element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.flag = 0;
        }
    }
}
