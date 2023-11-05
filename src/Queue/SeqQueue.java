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

    public static void main(String[] args) {
        SeqQueue<Integer> queue = new SeqQueue<>();
        for (int i = 0; i < 15; i++) {
            queue.offer(i * 100);
        }
        queue.peek();
        queue.poll();
        queue._print();
    }

    E peek() {
        return this.array[(this.head + 1) % this.capacity];
    }

    E poll() {
        this.head = (this.head + 1) % this.capacity;
        return this.array[head - 1];
    }

    void _print() {
        int i = this.head;
        do {
            if (i != tail - 1)
                System.out.print(this.array[i] + " << ");
            else
                System.out.print(this.array[i]);
            i = (i + 1) % this.capacity;
        } while (i != this.tail);
    }

    Boolean offer(E element){
        if((this.tail+1)%this.capacity==this.head){
            int newCapacity=capacity+ (capacity >> 1);
            E [] newArray=(E[])new Object[newCapacity];
            if(tail==this.capacity-1) {
                if (this.capacity >= 0) System.arraycopy(this.array, 0, newArray, 0, this.capacity);
            }
            else {
                int j=1;
                for (int i = head+1; i < this.capacity; i++,j++) {
                    newArray[j]=this.array[j];
                }
                for (int i = 0; i <= tail; i++) {
                    newArray[j]=this.array[i];
                }
            }
            this.array=newArray;
            this.capacity=newCapacity;
            this.array[(tail+1)%this.capacity]=element;
            this.head = 0; // 重置 head
        }
        this.array[tail]=element;
        this.tail=(this.tail+1)%this.capacity;
        return true;
    }
}
