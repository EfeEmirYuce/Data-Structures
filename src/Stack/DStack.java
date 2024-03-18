package Stack;
public class DStack {
    int capacity = 2;
    int[] stack = new int[capacity];
    int top = 0;

    public void push(int data) {
        if(isFull()){
            expand();
        }
        stack[top] = data;
        top++;
    }
    public void expand(){
        capacity *=2;
        int[] newStack = new int[capacity];
        for(int i=0;i<(capacity/2);i++){
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
    public void shrink(){
        if(top <= capacity/2){
            capacity /=2;
            int[] newStack = new int[capacity];
            for(int i=0;i<(capacity);i++){
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
    }

    public int pop() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            top--;
            data = stack[top];
            stack[top] = 0;
            shrink();
        }
        return data;
    }

    public void show() {
        for (int n : stack) {
            System.out.print(n + " ");
        }System.out.println("");

    }

    public int peek() {
        int data;
        data = stack[top - 1];
        return data;
    }

    public int size() {
        return (top);
    }

    public boolean isEmpty() {
        return top <= 0;
    }

    public boolean isFull() {
        return top >= capacity;
    }
}

