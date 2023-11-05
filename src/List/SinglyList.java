package List;

public class SinglyList<E>{
    private int size;
    private final  Node<E> head;

    //带头结点的单链表，即头结点不存储数据
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
        if (element == null)
            throw new NullPointerException("element == null");
        if(index<0 || index > size)
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ "+size);
        Node<E> front=head;
        while(index>0){
            front=front.next;
            index--;
        }
        Node<E> newNode = new Node<>(element);
        Node<E> current=front.next;
        front.next = newNode;
        newNode.next = current;
        this.size++;
        return true;
    }
    public E remove(int index){
        if(index < 0 || index > size - 1)  //同样的，先判断位置是否合法  [0,size-1]
            throw new IndexOutOfBoundsException("删除位置非法，合法的删除位置为：0 ~ "+(size - 1));
        Node<E> front=head;
        while(index>0){
            front=front.next;
            index--;
        }
        Node<E> current=front.next;
        E element=current.element;
        front.next=current.next;
        this.size--;
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

    public int search(E element) {
        if (element == null)
            throw new NullPointerException("element==null");
        Node<E> current = head.next;
        int index = 0;
        while (current != null) {
            if (current.element.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        SinglyList<?> otherList = (SinglyList<?>) obj;
        if (size != otherList.size) {
            return false;
        }

        Node<E> current = head.next;
        Node<?> otherCurrent = otherList.head.next;

        while (current != null) {
            if (!current.element.equals(otherCurrent.element)) {
                return false;
            }
            current = current.next;
            otherCurrent = otherCurrent.next;
        }

        return true;
    }


    public static void main(String[] args) {
        SinglyList<Integer> singlyList=new SinglyList<>();
        for (int i = 0; i < 7; i++)
            singlyList.insert(i*100,i);
        singlyList.set(-100,0);
        System.out.print("遍历如下：");
        for (int i = 0; i < singlyList.size(); i++)
            System.out.print(singlyList.get(i)+"，");
        System.out.println();
        System.out.println("删除元素索引为2的元素："+singlyList.remove(2));
        System.out.println("是否为空："+singlyList.isEmpty());
        System.out.println("长度："+singlyList.size());
    }
}
