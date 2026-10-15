/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author aaley
 */
public class MyHashMap <K, V> {
    private static final int SIZE = 16;  
    private Entry<K, V>[] table;  

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        table = new Entry[SIZE];  
    }

    private int getIndex(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);  
        Entry<K, V> newEntry = new Entry<>(key, value);  
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) { 
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newEntry;
        }
    }

    public V get(K key) {
        int index = getIndex(key);  
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;  
            }
            current = current.next;  
        }
        return null;  
    }

    public void remove(K key) {
        int index = getIndex(key); 
        Entry<K, V> current = table[index];
        Entry<K, V> previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;  
            }
            previous = current;  
            current = current.next;  
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                Entry<K, V> current = table[i];
                System.out.print("Index " + i + ": ");
                while (current != null) {
                    System.out.print("(" + current.key + " => " + current.value + ") -> ");
                    current = current.next;
                }
                System.out.println("null");
            }
        }
    }   
}
