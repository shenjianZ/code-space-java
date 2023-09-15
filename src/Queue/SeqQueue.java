package Queue;

public class SeqQueue<E> {

    int capacity;
    private E [] array;
    int head; //队首
    int tail; //队尾
    public SeqQueue(){
        this.capacity=10;
        this.array =(E[]) new Object[capacity];
        this.head=this.tail=0;
    }
    Boolean offer(E element){
        if((this.tail+1)%this.capacity==this.head){
            int newCapacity=capacity+capacity>>1;
            E [] newArray=(E[])new Object[newCapacity];
            this.capacity=newCapacity;
            for (int i = 0; i < capacity-1; i++) {
                newArray[i]=this.array[i];
            }
            this.array=newArray;
        }
        this.array[tail]=element;
        this.tail=(this.tail+1)%this.capacity;
        return true;
    }
    E peek(){
        return this.array[head];
    }
    E poll(){
        this.head=(this.head+1)%this.capacity;
        return this.array[head-1];
    }
    void _print(){
        int i=this.head;
        do{
            if(i!=tail)
                System.out.print(this.array[i]+",");
            else
                System.out.print(this.array[i]);
            i=(i+1)%this.capacity;
        }while (i!=this.tail);
    }

    public static void main(String[] args) {
        SeqQueue queue=new SeqQueue();
        for (int i = 0; i < 10; i++) {
            queue.offer(i*100);
        }
        queue.peek();
        queue._print();
    }





}
