package Queue;

public class LinkedQueue <E>{

    //队首不存储数据
    Node<E> head; //队首
    Node<E> tail; //队尾

    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
            next=null;
        }
    }

    public LinkedQueue(){
        head = new Node<>(null);
        tail = new Node<>(null);
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 17; i++) {
            queue.offer(i * 100);
        }
        queue.poll();
        queue.peek();
        queue._print();
    }

    boolean offer(E element) {
        Node<E> front=this.head;
        while(front.next!=null) {
            front=front.next;
        }
        Node<E> newNode = new Node<>(element);
        front.next=newNode;
        this.tail=newNode;
        return true;
    }

    E peek(){
        if(this.head.next==null)
            // 队列为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Queue is empty");
        return this.head.next.element;
    }

    void _print() {
        Node<E> current = this.head.next;
        while (current.next != null) {
            System.out.print(current.element + " << ");
            current = current.next;
        }
        System.out.print(current.element);
    }

    E poll(){
        if(this.head.next==null)
            // 队列为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Queue is empty");
        E element = this.head.next.element;
        this.head.next=this.head.next.next;
        return element;
    }
}


