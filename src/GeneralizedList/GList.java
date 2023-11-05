package GeneralizedList;

public class GList<T> {
    public GListNode<T> head; // 指向广义表的头节点,此头结点是第一个节点

    // 构造函数
    public GList() {
        this.head = null;
    }

    public static void main(String[] args) {
        // 创建一个广义表 (6, ((5, 4), 3), 2, 1)
        GList<Integer> list = new GList<>();
        list.insert(1);                              // 1
        list.insert(2);                              // 2

        GList<Integer> sublist = new GList<>();
        sublist.insert(3);                           // 3

        GList<Integer> nestedSublist = new GList<>();
        nestedSublist.insert(4);                     // 4
        nestedSublist.insert(5);                     // 5

        sublist.insert(nestedSublist);               // (4, 5)
        list.insert(sublist);                        // (3, (4, 5))
        list.insert(6);                              // (6)

        // 打印广义表
        list.print();
        System.out.println();
    }

    // 判断广义表是否为空
    public boolean isEmpty() {
        return head == null;
    }

    // 在广义表头部插入广义表
    public void insert(GList<T> sublist) {
        GListNode<T> newNode = new GListNode<>(null, sublist, null);
        if (!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;
    }

    // 在广义表头部插入数据元素
    public void insert(T data) {
        GListNode<T> newNode = new GListNode<>(data, null, null);
        if (!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;
    }

    // 打印广义表
    public void print() {
        if (isEmpty()) {
            System.out.print("()");
        } else {
            System.out.print("(");
            printList(head);
            System.out.print(")");
        }
    }

    // 递归打印广义表节点
    private void printList(GListNode<T> node) {
        if (node != null) {
            T data = node.data;
            GList<T> child = node.child;

            if (child != null) {
                child.print();
            } else {
                System.out.print(data);
            }

            if (node.next != null) {
                System.out.print(", ");
                printList(node.next);
            }
        }
    }

    public static class GListNode<T> {
        private final T data;              // 数据元素，可以是原子元素或另一个广义表
        private final GList<T> child;      // 指向子广义表的指针
        private GListNode<T> next;   // 指向下一个节点

        // 构造函数
        public GListNode(T data, GList<T> child, GListNode<T> next) {
            this.data = data;
            this.child = child;
            this.next = next;
        }
    }
}
