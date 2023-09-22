package Stack;


public class SeqStack<E> {
    int capacity;
    int top;
    private E[] array;

    public SeqStack(){
        capacity=10;
        top=-1;
        array = (E[]) new Object[capacity];
    }

    public static void main(String[] args) {
        SeqStack<Integer> stack = new SeqStack<>();
        for (int i = 0; i < 15; i++) {
            stack.push(i * 10);
        }
        stack.peek();
        stack.pop();
        stack._print();
    }

    public boolean push(E element) {
        if(this.top==this.capacity-1){
            int capacity = this.capacity + (this.capacity >> 1);
            E[] newArray = (E[])new Object[capacity];
            if (this.capacity >= 0) System.arraycopy(this.array, 0, newArray, 0, this.capacity);
            this.array=newArray;
            this.capacity=capacity;
        }
        this.top++;
        this.array[this.top]=element;
        return true;
    }

    public E peek() {
        if(this.top < 0)
            // 栈为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Stack is empty");
        return this.array[this.top];
    }

    public E pop() {
        if(this.top < 0)
            // 栈为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Stack is empty");
        return this.array[this.top--];
    }

    void _print(){
        for (int i = this.top; i >=0; i--) {
            if(i==0){
                System.out.print(this.array[i]+" ");
                return;
            }
            System.out.print(this.array[i]+" -> ");
        }
    }

    public boolean isEmpty() {
        return this.top == -1;
    }
}
