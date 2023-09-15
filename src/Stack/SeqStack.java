package Stack;

import List.SeqList;

public class SeqStack<E> {
    int capacity;
    int top;
    private E[] array;

    public SeqStack(){
        capacity=10;
        top=-1;
        array = (E[]) new Object[capacity];
    }
    Boolean push (E element){
        if(this.top==this.capacity-1){
            int capacity = this.capacity + this.capacity >> 1;
            this.array = (E[])new Object[capacity];
            this.capacity=capacity;
        }
        this.top++;
        this.array[this.top]=element;
        return true;
    }

    E peek(){
        if(this.top < 0)  return null;
        return (E)this.array[this.top];
    }

    E pop(){
        if(this.top < 0)  return null;
        return (E)this.array[this.top--];
    }

    void _print(){
        for (int i = 0; i <= this.top; i++) {
            if(i==this.top){
                System.out.print(this.array[i]+" ");
                return;
            }
            else
                System.out.print(this.array[i]+", ");
        }
    }

    public static void main(String[] args) {
        SeqStack stack = new SeqStack();
        for (int i = 0; i < 7; i++) {
            stack.push(i*100);
        }
        stack.peek();
        stack._print();
    }
}
