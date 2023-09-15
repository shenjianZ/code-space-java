package Stack;

import List.SinglyList;

import javax.swing.text.Element;

public class LinkedStack <E>{
    E element;
    Node next;
    Node head;

    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
            next=null;
        }
    }

    public LinkedStack(){
        next = new Node<>(null);
        head = new Node<>(null);
        element = null;
    }
    Boolean push(E element){
        if(this.head.next==null){
            Node newNode = new Node<>(element);
            this.head.next=newNode;
            return true;
        }
        Node newNode = new Node<>(element);
        newNode.next=this.head.next;
        this.head.next=newNode;
        return true;
    }
    E peek(){
        if(this.head.next==null) return null;
        Node<E> current=this.head.next;
        E element=(E)current.element;
        return element;
    }
    E pop(){
        if(this.head.next==null) return null;
        Node<E> current=this.head.next;
        E element=(E)current.element;
        this.head=this.head.next;
        return element;
    }
    void _print(){
        Node<E> current = this.head.next;
        while(current.next != null ){
            System.out.print(current.element+", ");
            current=current.next;
        }
        System.out.print(current.element);
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < 7; i++) {
            stack.push(i * 100);
        }
        stack.pop();
        stack.peek();
        stack._print();
    }

}
