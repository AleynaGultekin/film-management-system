/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author aaley
 */
public class Stack <T> {
    private Node<T> top;
    private int size;    

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop element.");
            return null; 
        }

        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return null; 
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
    
    public int getSize() {
        return size;
    }
}
