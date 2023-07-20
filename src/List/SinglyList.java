package List;

public class SinglyList<E>{
    private int size;
    private final  Node<E> head;

    //带头结点的单链表
    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
            next=null;
        }
    }

    public SinglyList(){
        head = new Node<>(null);
        size = 0;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public boolean insert(E element,int index){
        if(index<0 || index > size)
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ "+size);
        Node<E> front=head;
        while(index>0){
            front=front.next;
            index--;
        }
        Node<E> node=new Node<>(element);
        Node<E> current=front.next;
        front.next=node;
        node.next=current;
        this.size++;
        return true;
    }
    public E remove(int index){
        if(index < 0 || index > size - 1)  //同样的，先判断位置是否合法
            throw new IndexOutOfBoundsException("删除位置非法，合法的删除位置为：0 ~ "+(size - 1));
        Node<E> front=head;
        while(index>1){
            front=front.next;
            index--;
        }
        Node<E> current=front.next;
        E element=current.element;
        front.next=current.next;
        return element;
    }
    public E get(int index){
        if(index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("非法的位置，合法的位置为：0 ~ "+(size - 1));
        Node<E> front=head;
        while(index>0){
            front=front.next;
            index--;
        }
        Node<E> current=front.next;
        return current.element;
    }
    public void set(E element, int index) {
        if(element==null)
            throw new NullPointerException("element==null");
        if (index < 0 || index > size-1)
            throw new IndexOutOfBoundsException("index="+index);
        Node<E> front=head;
        while(index>0){
            front=front.next;
            index--;
        }
        Node<E> current=front.next;
        current.element=element;
    }
    public int search(E element){
        return -1;
    }

    public boolean equals(Object obj){
        return true;
    }

    public static void main(String[] args) {
        SinglyList<Integer> singlyList=new SinglyList<>();
        for (int i = 0; i < 7; i++)
            singlyList.insert(i*100,i);
        singlyList.set(888,0);
        singlyList.set(999,1);
        System.out.print("遍历如下：");
        for (int i = 0; i < singlyList.size(); i++)
            System.out.print(singlyList.get(i)+"，");
        System.out.println();
        System.out.println("删除元素："+singlyList.remove(2));
        System.out.println("是否为空："+singlyList.isEmpty());
    }






}
