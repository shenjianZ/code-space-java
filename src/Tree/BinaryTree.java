package Tree;

public class BinaryTree<E> {
    TreeNode<E> root;

    public BinaryTree(E element) {
        this.root = new TreeNode<>(element);
    }

    public static void main(String[] args) {
        BinaryTree<Character> tree = new BinaryTree<>('A');
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');
        tree.insert('F');
    }

    public void insert(E element) {
        insertRecursive(this.root, element);
    }

    private void insertRecursive(TreeNode<E> root, E element) {
        if (root.left == null) {
            root.left = new TreeNode<>(element);
        } else if (root.right == null) {
            root.right = new TreeNode<>(element);
        } else {
            // Insert in left subtree if available, else go right
            insertRecursive(root.left, element);
        }
    }

    public static class TreeNode<E> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E element) {
            this.element = element;
            this.left = this.right = null;
        }
    }
}
