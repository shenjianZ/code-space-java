package List;

import java.util.Arrays;

public class SeqList<E> {
    int capacity;
    int size;
    private E[] array;

    public SeqList(){
        capacity=10;
        size=0;
        array = (E[]) new Object[capacity];
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public String toString() {
        return "SeqList{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        if (index < 0 || index >= size)
            return null;
        return (E) this.array[index];
    }

public void set(E element,int index) {
    if(element==null)
        throw new NullPointerException("element==null");
    if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException("index="+index);
    this.array[index]=element;
}

    public boolean insert(E element, int index)  {
        if(element==null)
            throw new NullPointerException("element==null");
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ "+size);
        if (size == capacity) {
            int newCapacity = capacity + (capacity >> 1);
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            this.array = (E[])newArray;
            this.capacity=newCapacity;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        this.size++;
        return true;
    }

    public boolean insert(E element) {
        return this.insert(element, this.size);
    }

    @SuppressWarnings("unchecked")
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index="+index);
        E element= (E) array[index];
        for (int i = index; i<size; i++) {
            array[i] = array[i +1];
        }
        this.array[size-1]=null;
        this.size--;
        return element ;
    }

    public int search(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public boolean equals(Object obj) {
        // 如果是相同的引用，直接返回true
        if (this == obj) {
            return true;
        }

        // 如果传入的对象为空或者不是同一个类，返回false
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // 将传入的对象转换为SeqList类型
        SeqList<?> otherList = (SeqList<?>) obj;

        // 如果大小不相等，返回false
        if (size != otherList.size) {
            return false;
        }

        // 逐个比较数组中的元素
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.array[i])) {
                return false;
            }
        }

        // 如果所有元素都相等，返回true
        return true;
    }


    public static void main(String[] args) {
        SeqList<Integer> seqList=new SeqList<>();
        for (int i = 0; i < 7; i++)
            seqList.insert(i*100,i);
        seqList.set(888,0);
        seqList.set(999,1);
        System.out.print("遍历如下：");
        for (int i = 0; i < seqList.size(); i++)
            System.out.print(seqList.get(i)+"，");
        System.out.println();
        System.out.println("删除元素："+seqList.remove(2));
        System.out.println("是否为空："+seqList.isEmpty());
    }
}
