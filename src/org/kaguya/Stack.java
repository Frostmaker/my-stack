package org.kaguya;

import java.lang.reflect.Array;

public class Stack<E> {
    private int top;
    final private int size;
    private E[] array;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        try {
            stack.push(3);
            stack.push(4);
            System.out.println(stack.peek());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
//            System.out.println(stack.pop());
        } catch (Exception e) {
            System.exit(-1);
        }

    }

    public Stack() {
        this.size = 64;
        this.top = -1;
        array = (E[]) Array.newInstance(Object.class, this.size);
//        array = (E[]) new Object[this.size];
    }

    public E peek() {
        return array[this.top];
    }

    public E pop() {
        this.top--;
        return array[top + 1];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    private boolean isFull() {
        return (this.top + 1 == size);
    }

    public void push(E elem) throws Exception {
        if (this.isFull())
            throw new Exception("Stack overflow");
        else {
            this.top++;
            array[top] = elem;
        }
    }
}
