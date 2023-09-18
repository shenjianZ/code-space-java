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
            int capacity = this.capacity + (this.capacity >> 1);
            E[] newArray = (E[])new Object[capacity];
            for (int i = 0; i < this.capacity; i++)
                newArray[i]=this.array[i];
            this.array=newArray;
            this.capacity=capacity;
        }
        this.top++;
        this.array[this.top]=element;
        return true;
    }

    E peek(){
        if(this.top < 0)
            // 栈为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Stack is empty");
        return (E)this.array[this.top];
    }

    E pop(){
        if(this.top < 0)
            // 栈为空，可以抛出异常或返回特定值
            throw new IllegalStateException("Stack is empty");
        return (E)this.array[this.top--];
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

    public static void main(String[] args) {
        SeqStack stack = new SeqStack();
        for (int i = 0; i < 15; i++) {
            stack.push(i*10);
        }
        stack.peek();
        stack.pop();
        stack._print();
    }
}
