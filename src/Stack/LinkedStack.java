package Stack;

public class LinkedStack <E>{
    Node<E> top;

    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
            next=null;
        }
    }

    public LinkedStack(){
        this.top = null;
    }
    boolean push(E element){
        Node<E> newNode = new Node<>(element);
        newNode.next=this.top;
        this.top=newNode;
        return true;
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 3; i++) {
            stack.push(i * 100);
        }
        stack.pop();
        stack.peek();
        stack._print();
    }
    E pop(){
        if(this.top.next==null)
            // 栈为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Stack is empty");
        E element=this.top.element;
        this.top=this.top.next;
        return element;
    }
    void _print(){
        Node<E> current = this.top;
        while (current != null) {
            if(current.next==null) {
                System.out.print(current.element);
                return;
            }
            System.out.print(current.element+" -> ");
            current = current.next;
        }
    }

    E peek() {
        if (this.top == null)
            // 栈为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Stack is empty");
        return this.top.element;
    }

}
