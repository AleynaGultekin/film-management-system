/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author aaley
 */
public class LinkedList <T> {
    private Node<T> head;

    public static class Node<T> {
        T data; 
        Node<T> next; 

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    public Node<T> getHead() {
        return head;
    }
    
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void remove(T data) {
        if (head == null) return;

       
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(data)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public boolean contains(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) return true;
            temp = temp.next;
        }
        return false;
    }
}
