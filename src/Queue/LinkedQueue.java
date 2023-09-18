package Queue;

public class LinkedQueue <E>{

    //头结点不存储数据
    Node head; //队首
    Node tail; //队尾

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
    Boolean offer(E element){
        if(this.head.next==null) {
            Node<E> newNode=new Node<>(element);
            this.tail.element=element;
            this.head.next=newNode;
            this.tail=newNode;
            return true;
        }
        Node<E> front=this.head;
        while(front.next!=null) {
            front=front.next;
        }
        Node<E> newNode= new Node<E>(element);
        front.next=newNode;
        this.tail=newNode;
        return true;
    }
    E peek(){
        if(this.head.next==null)
            // 队列为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Queue is empty");
        return (E)this.head.next.element;
    }
    E poll(){
        if(this.head.next==null)
            // 队列为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Queue is empty");
        E element=(E)this.head.next.element;
        this.head.next=this.head.next.next;
        return element;
    }
    void _print(){
        Node<E> current = this.head.next;
        while( current.next!= null){
            System.out.print(current.element+" << ");
            current=current.next;
        }
        System.out.print(current.element);
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        for (int i = 0; i < 17; i++) {
            queue.offer(i * 100);
        }
        queue.poll();
        queue.peek();
        queue._print();
    }
}


